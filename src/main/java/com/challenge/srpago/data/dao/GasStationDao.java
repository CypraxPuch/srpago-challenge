package com.challenge.srpago.data.dao;

import com.challenge.srpago.action.GasStationResponse;
import com.challenge.srpago.data.dao.repository.BankPaymentCardRepository;
import com.challenge.srpago.data.dao.repository.CardHolderRepository;
import com.challenge.srpago.data.dao.repository.GasSellRepository;
import com.challenge.srpago.data.dao.repository.GasStationRepository;
import com.challenge.srpago.data.entity.BankPaymentCard;
import com.challenge.srpago.data.entity.CardHolder;
import com.challenge.srpago.data.entity.GasSell;
import com.challenge.srpago.data.entity.GasStation;
import com.challenge.srpago.data.to.GasStationTo;
import com.challenge.srpago.data.to.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: gpucheta<br/>
 * Date: 8/31/19<br/>
 * Time: 8:09 AM<br/>
 * Generated to
 */
@Component
public class GasStationDao {

    private static Logger logger = LoggerFactory.getLogger(GasStationDao.class);

    private RestTemplate restTemplate;
    private GasStationRepository gasStationRepository;
    private CardHolderRepository cardHolderRepository;
    private BankPaymentCardRepository bankPaymentCardRepository;
    private GasSellRepository gasSellRepository;
    private final String GAS_STATION_INFO_URL = "https://api.datos.gob.mx/v1/precio.gasolina.publico";
    private static List<GasStationTo> gasStationList = new ArrayList<>();

    public GasStationDao(
            RestTemplate restTemplate
            , GasStationRepository gasStationRepository
            , CardHolderRepository cardHolderRepository
            , BankPaymentCardRepository bankPaymentCardRepository
            , GasSellRepository gasSellRepository) {

        this.restTemplate = restTemplate;
        this.gasStationRepository = gasStationRepository;
        this.cardHolderRepository = cardHolderRepository;
        this.bankPaymentCardRepository = bankPaymentCardRepository;
        this.gasSellRepository = gasSellRepository;
    }

    public List<GasStationTo> getAllGasStation() {
        //List<GasStationTo> gasStationList = new ArrayList<>();
        int totalPages = 0;
        ResponseEntity<GasStationResponse> rateResponse =
                restTemplate.exchange(GAS_STATION_INFO_URL,
                        HttpMethod.GET, null, new ParameterizedTypeReference<GasStationResponse>() {
                        });
        if (rateResponse.getBody() != null) {
            GasStationResponse body = rateResponse.getBody();
            Pagination pagination = body.getPagination();
            totalPages = Math.floorDiv(pagination.getTotal(), pagination.getPageSize());
            if ((pagination.getTotal() % pagination.getPageSize()) > 0) {
                totalPages += 1;
            }
            gasStationList.addAll(body.getResults());

            //page 1 was already queried, so now starts with page 2 until the end
            for (int page = 2; page <= totalPages; page++) {
                rateResponse =
                        restTemplate.exchange(GAS_STATION_INFO_URL.concat("?page=" + page),
                                HttpMethod.GET,
                                null,
                                new ParameterizedTypeReference<GasStationResponse>() {
                                });
                //get the new results
                body = rateResponse.getBody();

                gasStationList.addAll(body.getResults());
                System.out.println("-> size: " + gasStationList.size());
            }
        } else {
            return Collections.emptyList();
        }

        return gasStationList;
    }

    public Optional<GasStationTo> getGasStationById(String gasStationId) {
        ResponseEntity<GasStationResponse> rateResponse =
                restTemplate.exchange(GAS_STATION_INFO_URL.concat("?_id=" + gasStationId),
                        HttpMethod.GET, null, new ParameterizedTypeReference<GasStationResponse>() {
                        });
        Optional<GasStationTo> optional = Optional.empty();
        if (rateResponse.getBody() != null) {
            GasStationResponse body = rateResponse.getBody();
            optional = Optional.of(body.getResults().get(0));
        }
        return optional;
    }

    public Optional<GasStation> findGasStationById(String gasStationId) {
        return gasStationRepository.findById(gasStationId);
    }

    public Optional<GasStation> saveGasStation(GasStationTo gasStationTo) {
        GasStation gasStation = new GasStation();
        gasStation.setId(gasStationTo.getId());
        gasStation.setCalle(gasStationTo.getCalle());
        gasStation.setRfc(gasStationTo.getRfc());
        gasStation.setDateInsert(gasStationTo.getDateInsert());
        gasStation.setColonia(gasStationTo.getColonia());
        gasStation.setNumeroPermiso(gasStationTo.getNumeroPermiso());
        gasStation.setFechaAplicacion(gasStationTo.getFechaAplicacion());
        gasStation.setPermisoId(gasStationTo.getPermisoid());
        gasStation.setLongitud(new BigDecimal(gasStationTo.getLongitude()));
        gasStation.setLatitud(new BigDecimal(gasStationTo.getLatitude()));
        if (gasStationTo.getRegularPrice() != null && !gasStationTo.getRegularPrice().isEmpty()) {
            gasStation.setRegularPrice(new BigDecimal(gasStationTo.getRegularPrice()));
        }
        if (gasStationTo.getPremiumPrice() != null && !gasStationTo.getPremiumPrice().isEmpty()) {
            gasStation.setPremiumPrice(new BigDecimal(gasStationTo.getPremiumPrice()));
        }
        if (gasStationTo.getDiesel() != null && !gasStationTo.getDiesel().isEmpty()) {
            gasStation.setDieselPrice(new BigDecimal(gasStationTo.getDiesel()));
        }
        gasStation.setRazonSocial(gasStationTo.getRazonSocial());
        gasStation.setCodigoPostal(gasStationTo.getCodigoPostal());

        Optional<GasStation> opt;
        try {
            opt = Optional.of(gasStationRepository.save(gasStation));
        } catch (Exception e) {
            logger.error("failure saving gas station info", e);
            opt = Optional.empty();
        }
        return opt;
    }

    public Optional<CardHolder> findCardHolderById(String email) {
        return cardHolderRepository.findById(email);
    }

    public Optional<CardHolder> saveCardHolder(String email, String name, String lastName) {
        CardHolder cardHolder = new CardHolder();
        cardHolder.setId(email);
        cardHolder.setName(name);
        cardHolder.setLastName(lastName);

        Optional<CardHolder> opt;
        try {
            opt = Optional.of(cardHolderRepository.save(cardHolder));
        } catch (Exception e) {
            logger.error("failure saving card holder info", e);
            opt = Optional.empty();
        }
        return opt;
    }

    public Optional<BankPaymentCard> findBankPaymentCard(String cardNumber){
        BankPaymentCard card = new BankPaymentCard();
        card.setCardNumber(cardNumber);
        return bankPaymentCardRepository.findOne(Example.of(card));
    }

    public Optional<BankPaymentCard> saveBankPaymentCard(String cardNumber, String expYear, String expMonth){
        BankPaymentCard bankPaymentCard = new BankPaymentCard();

        bankPaymentCard.setId(UUID.randomUUID().toString());
        bankPaymentCard.setCardNumber(cardNumber);
        bankPaymentCard.setExpirationYear(expYear);
        bankPaymentCard.setExpirationMonth(expMonth);

        Optional<BankPaymentCard> opt;
        try {
            opt = Optional.of(bankPaymentCardRepository.save(bankPaymentCard));
        } catch (Exception e) {
            logger.error("failure saving bank payment card info", e);
            opt = Optional.empty();
        }
        return opt;
    }

    public Optional<GasSell> saveGasSell(String cardHolderId, String bankPaymentCardId, String gasStationId, String gasType, BigDecimal amount, String sellerName){
        GasSell gasSell = new GasSell();
        gasSell.setId(UUID.randomUUID().toString());
        gasSell.setCardHolderId(cardHolderId);
        gasSell.setBankPaymentCardId(bankPaymentCardId);
        gasSell.setGasStationId(gasStationId);
        gasSell.setGasType(gasType);
        gasSell.setAmount(amount);
        gasSell.setSellerName(sellerName);

        Optional<GasSell> opt;
        try {
            opt = Optional.of(gasSellRepository.save(gasSell));
        } catch (Exception e) {
            logger.error("failure saving gas sell info", e);
            opt = Optional.empty();
        }
        return opt;
    }
}
