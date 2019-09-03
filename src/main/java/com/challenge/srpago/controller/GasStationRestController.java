package com.challenge.srpago.controller;

import com.challenge.srpago.action.InfoRQ;
import com.challenge.srpago.action.Response;
import com.challenge.srpago.data.dao.GasStationDao;
import com.challenge.srpago.data.dao.repository.GasStationRepository;
import com.challenge.srpago.data.entity.BankPaymentCard;
import com.challenge.srpago.data.entity.CardHolder;
import com.challenge.srpago.data.entity.GasSell;
import com.challenge.srpago.data.entity.GasStation;
import com.challenge.srpago.data.to.GasStationTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: gpucheta<br/>
 * Date: 8/29/19<br/>
 * Time: 9:12 PM<br/>
 * Generated for srpago challenge
 */
@RestController
public class GasStationRestController {

    private static Logger logger = LoggerFactory.getLogger(GasStationRestController.class);
    private GasStationDao gasStationDao;

    public GasStationRestController(GasStationDao gasStationDao) {
        this.gasStationDao = gasStationDao;
    }

    /**
     * Example execution: <br/>
     * curl -X POST localhost:8080/gastation -H 'Content-type:application/json' -d '{"email": "pucheta@srpago.com", "name": "Gerardo", "lastName": "Pucheta Figueroa", "cardNumber": "9877654432111594", "expirationDateYear": "2020", "expirationDateMonth": "1", "gasType": "1", "amount": "100.00", "gasStation": "9a8ds4f9a41sd95f4a9sd", "sellerName": "Pedrito"}'<br/><br/>
     *
     * @param infoRQ
     * @return
     */
    @PostMapping(value = "/buy-gas-service")
    public Response buyGasService(@Valid @RequestBody InfoRQ infoRQ) {
        Optional<GasStationTo> optional = gasStationDao.getGasStationById(infoRQ.getGasStation());
        GasStationTo gasStationTo = optional.get();

        Optional<GasStation> optionalGasStation = computeGasStationInfo(gasStationTo);
        Optional<CardHolder> optionalCardHolder = computeCardHolderInfo(infoRQ);
        Optional<BankPaymentCard> optionalBankPaymentCard = computeBankPaymentCard(infoRQ);

        Response response = new Response();
        Optional<GasSell> optionalGasSell = Optional.empty();
        if(optionalGasStation.isPresent() && optionalCardHolder.isPresent() && optionalBankPaymentCard.isPresent()){
            optionalGasSell = computeGasSell(optionalCardHolder.get().getId()
                    , optionalBankPaymentCard.get().getId()
                    , optionalGasStation.get().getId()
                    , infoRQ);
        }

        if(optionalGasSell.isPresent()){
            response.setError(null);
            response.setMessage("Correct Information");
            response.setSuccess(Boolean.TRUE);
        } else {
            response.setError("Issues with DB");
            response.setMessage("Failure saving info into the DB");
            response.setSuccess(Boolean.FALSE);
        }

        return response;
    }

    private Optional<GasStation> computeGasStationInfo(GasStationTo gasStationTo){
        Optional<GasStation> optionalGasStation = gasStationDao.findGasStationById(gasStationTo.getId());
        if(optionalGasStation.isPresent()){
            logger.info("gas station has been saved before this.");
        }else{
            optionalGasStation = gasStationDao.saveGasStation(gasStationTo);
            logger.info("gas station inserted. Id:"+optionalGasStation.get().getId());
        }
        return optionalGasStation;
    }

    private Optional<CardHolder> computeCardHolderInfo(InfoRQ infoRQ){
        Optional<CardHolder> optionalCardHolder = gasStationDao.findCardHolderById(infoRQ.getEmail());
        if(optionalCardHolder.isPresent()){
            logger.info("card holder has been saved before this");
        } else {
            optionalCardHolder = gasStationDao.saveCardHolder(infoRQ.getEmail(), infoRQ.getName(), infoRQ.getLastName());
            logger.info("card holder info inserted. Id:"+optionalCardHolder.get().getId());
        }
        return optionalCardHolder;
    }

    private Optional<BankPaymentCard> computeBankPaymentCard(InfoRQ infoRQ){
        Optional<BankPaymentCard> optionalBankPaymentCard = gasStationDao.findBankPaymentCard(infoRQ.getCardNumber());
        if(optionalBankPaymentCard.isPresent()){
            logger.info("bank payment card has been saved before this");
        } else {
            optionalBankPaymentCard = gasStationDao.saveBankPaymentCard(infoRQ.getCardNumber(), infoRQ.getExpirationDateYear(), infoRQ.getExpirationDateMonth());
            logger.info("bank payment card info inserted. Id:"+optionalBankPaymentCard.get().getId());
        }
        return optionalBankPaymentCard;
    }

    private Optional<GasSell> computeGasSell(String cardHolderId, String bankPaymentCardId, String gasStationId, InfoRQ infoRQ ){
        return gasStationDao.saveGasSell(cardHolderId, bankPaymentCardId, gasStationId, infoRQ.getGasType().toString(), new BigDecimal(infoRQ.getAmount()), infoRQ.getSellerName() );
    }

}
