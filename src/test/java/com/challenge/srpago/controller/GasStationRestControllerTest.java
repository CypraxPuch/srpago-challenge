package com.challenge.srpago.controller;

import com.challenge.srpago.action.InfoRQ;
import com.challenge.srpago.action.Response;
import com.challenge.srpago.data.dao.GasStationDao;
import com.challenge.srpago.data.dao.repository.BankPaymentCardRepository;
import com.challenge.srpago.data.dao.repository.CardHolderRepository;
import com.challenge.srpago.data.dao.repository.GasSellRepository;
import com.challenge.srpago.data.dao.repository.GasStationRepository;
import com.challenge.srpago.data.entity.BankPaymentCard;
import com.challenge.srpago.data.entity.CardHolder;
import com.challenge.srpago.data.entity.GasStation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: gpucheta<br/>
 * Date: 9/3/19<br/>
 * Time: 2:42 PM<br/>
 * Generated to
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GasStationRestControllerTest {

    @Autowired
    private RestTemplate restTemplateTest;
    @Autowired
    private GasStationRepository gasStationRepositoryTest;
    @Autowired
    private CardHolderRepository cardHolderRepositoryTest;
    @Autowired
    private BankPaymentCardRepository bankPaymentCardRepositoryTest;
    @Autowired
    private GasSellRepository gasSellRepositoryTest;
    @Autowired
    private GasStationDao gasStationDaoTest;
    @Autowired
    private GasStationRestController gasStationRestControllerTest;

    @Before
    public void init(){
        assertNotNull(restTemplateTest);
        assertNotNull(gasStationRepositoryTest);
        assertNotNull(cardHolderRepositoryTest);
        assertNotNull(bankPaymentCardRepositoryTest);
        assertNotNull(gasSellRepositoryTest);
        gasStationDaoTest = new GasStationDao(restTemplateTest, gasStationRepositoryTest, cardHolderRepositoryTest, bankPaymentCardRepositoryTest, gasSellRepositoryTest);
        assertNotNull(gasStationDaoTest);
        gasStationRestControllerTest = new GasStationRestController(gasStationDaoTest);
        assertNotNull(gasStationRestControllerTest);
    }

    @Test
    public void test_buyGasService_null_param() {
        Response response = gasStationRestControllerTest.buyGasService(null);
        assertNotNull(response);
        assertEquals(false, response.getSuccess());
        assertEquals("Bad parameter", response.getError());
        assertEquals("The service should contain an entry body", response.getMessage());

    }

    /**
     * General Test, in this one i can test all Dao methods added (save and find)
     */
    @Test
    public void test_buyGasService() {
        InfoRQ infoRQ = new InfoRQ();
        String cardHolderEmail = "test@test.test";
        String gasStationId = "587fbd6aedfe99480a073298";
        String cardNumber = "1234567890123456";

        infoRQ.setEmail(cardHolderEmail);
        infoRQ.setName("TestName");
        infoRQ.setLastName("Test LastName");
        infoRQ.setCardNumber(cardNumber);
        infoRQ.setExpirationDateYear("2019");
        infoRQ.setExpirationDateMonth("11");
        infoRQ.setGasType(1);
        infoRQ.setAmount(10.11);
        infoRQ.setGasStation(gasStationId);
        infoRQ.setSellerName("Seller Test");

        Response response = gasStationRestControllerTest.buyGasService(infoRQ);
        assertNotNull(response);
        assertEquals(true, response.getSuccess());
        assertNull(response.getError());
        assertEquals("Correct Information", response.getMessage());

        Optional<CardHolder> cardHolderById = gasStationDaoTest.findCardHolderById(cardHolderEmail);
        assertNotNull(cardHolderById);
        assertTrue(cardHolderById.isPresent());
        assertEquals("TestName", cardHolderById.get().getName());
        assertEquals("Test LastName", cardHolderById.get().getLastName());

        Optional<GasStation> gasStationById = gasStationDaoTest.findGasStationById(gasStationId);
        assertNotNull(gasStationById);
        assertTrue(gasStationById.isPresent());
        GasStation gasStation = gasStationById.get();
        assertNotNull(gasStation);
        assertEquals("VEXAL  S.A. DE C.V. ", gasStation.getRazonSocial());
        assertEquals("Adolfo Ruiz Cortines No.245  Lomas De Atizapán  Atizapán", gasStation.getCalle());
        assertEquals("VEX101109SK7", gasStation.getRfc());
        assertEquals("", gasStation.getColonia());
        assertEquals("52977", gasStation.getCodigoPostal());
        assertEquals("PL/1845/EXP/ES/2015", gasStation.getNumeroPermiso());
        /*continue with validation in a real environment*/

        Optional<BankPaymentCard> bankPaymentCard = gasStationDaoTest.findBankPaymentCard(cardNumber);
        assertNotNull(bankPaymentCard);
        assertTrue(bankPaymentCard.isPresent());
        BankPaymentCard paymentCard = bankPaymentCard.get();
        assertNotNull(paymentCard);
        assertEquals("11", paymentCard.getExpirationMonth());
        assertEquals("2019", paymentCard.getExpirationYear());

    }

}