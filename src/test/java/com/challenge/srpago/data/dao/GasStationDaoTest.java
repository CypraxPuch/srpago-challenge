package com.challenge.srpago.data.dao;

import com.challenge.srpago.data.dao.repository.BankPaymentCardRepository;
import com.challenge.srpago.data.dao.repository.CardHolderRepository;
import com.challenge.srpago.data.dao.repository.GasSellRepository;
import com.challenge.srpago.data.dao.repository.GasStationRepository;
import com.challenge.srpago.data.entity.GasStation;
import com.challenge.srpago.data.to.GasStationTo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.RoundingMode;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: gpucheta<br/>
 * Date: 9/3/19<br/>
 * Time: 8:31 PM<br/>
 * Generated to
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GasStationDaoTest {

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

    private String gasStationId = "587fbd6aedfe99480a0732fa";
    private String cardHolderEmail = "testDao@testDao.Dao";
    private String cardNumber = "7332567890124895";

    @Before
    public void setUp() throws Exception {
        assertNotNull(restTemplateTest);
        assertNotNull(gasStationRepositoryTest);
        assertNotNull(cardHolderRepositoryTest);
        assertNotNull(bankPaymentCardRepositoryTest);
        assertNotNull(gasSellRepositoryTest);
        gasStationDaoTest = new GasStationDao(restTemplateTest, gasStationRepositoryTest, cardHolderRepositoryTest, bankPaymentCardRepositoryTest, gasSellRepositoryTest);
        assertNotNull(gasStationDaoTest);

    }

    @Test
    public void test_saveGasStation() {
        GasStationTo to = new GasStationTo();
        to.setId(gasStationId);
        to.setCalle("Canal de Tezontle No. 2623 Col. Leyes de Reforma Iztapalapa");
        to.setCodigoPostal("9310");
        to.setColonia("");
        to.setLatitude("19.38326");
        to.setLongitude("-99.06647");
        to.setNumeroPermiso("PL/2207/EXP/ES/2015");
        to.setRazonSocial("SERVICIO LEYES DE REFORMA S.A. DE C.V.");
        to.setRfc("SLR980420867");
        to.setRegularPrice("16.32");
        to.setPremiumPrice("18.20");
        Optional<GasStation> resultGasStationOptional = gasStationDaoTest.saveGasStation(to);
        assertNotNull(resultGasStationOptional);
        assertTrue(resultGasStationOptional.isPresent());

        GasStation gasStation = resultGasStationOptional.get();
        assertEquals("SERVICIO LEYES DE REFORMA S.A. DE C.V.", gasStation.getRazonSocial());
        assertEquals("Canal de Tezontle No. 2623 Col. Leyes de Reforma Iztapalapa", gasStation.getCalle());
        assertEquals("SLR980420867", gasStation.getRfc());
        assertEquals("", gasStation.getColonia());
        assertEquals("9310", gasStation.getCodigoPostal());
        assertEquals("PL/2207/EXP/ES/2015", gasStation.getNumeroPermiso());
        assertEquals("16.32", gasStation.getRegularPrice().setScale(2, RoundingMode.UNNECESSARY).toString());
        assertEquals("18.20", gasStation.getPremiumPrice().setScale(2, RoundingMode.UNNECESSARY).toString());
        /*continue with validation in a real environment*/
    }

    @Test
    public void test_findGasStationById() {
        Optional<GasStation> gasStationById = gasStationDaoTest.findGasStationById(gasStationId);
        assertNotNull(gasStationById);
        if( !gasStationById.isPresent() ){
            GasStationTo to = new GasStationTo();
            to.setId(gasStationId);
            to.setCalle("Canal de Tezontle No. 2623 Col. Leyes de Reforma Iztapalapa");
            to.setCodigoPostal("9310");
            to.setColonia("");
            to.setLatitude("19.38326");
            to.setLongitude("-99.06647");
            to.setNumeroPermiso("PL/2207/EXP/ES/2015");
            to.setRazonSocial("SERVICIO LEYES DE REFORMA S.A. DE C.V.");
            to.setRfc("SLR980420867");
            to.setRegularPrice("16.32");
            to.setPremiumPrice("18.20");
            gasStationById = gasStationDaoTest.saveGasStation(to);
        }
        assertTrue(gasStationById.isPresent());
        GasStation gasStation = gasStationById.get();
        assertNotNull(gasStation);

        assertEquals("SERVICIO LEYES DE REFORMA S.A. DE C.V.", gasStation.getRazonSocial());
        assertEquals("Canal de Tezontle No. 2623 Col. Leyes de Reforma Iztapalapa", gasStation.getCalle());
        assertEquals("SLR980420867", gasStation.getRfc());
        assertEquals("", gasStation.getColonia());
        assertEquals("9310", gasStation.getCodigoPostal());
        assertEquals("PL/2207/EXP/ES/2015", gasStation.getNumeroPermiso());
        assertEquals("16.32", gasStation.getRegularPrice().setScale(2, RoundingMode.UNNECESSARY).toString());
        assertEquals("18.20", gasStation.getPremiumPrice().setScale(2, RoundingMode.UNNECESSARY).toString());
        /*continue with validation in a real environment*/
    }

   /* @Test
    public void saveGasStation() {
    }

    @Test
    public void findCardHolderById() {
    }

    @Test
    public void saveCardHolder() {
    }

    @Test
    public void findBankPaymentCard() {
    }

    @Test
    public void saveBankPaymentCard() {
    }

    @Test
    public void saveGasSell() {
    }*/
}