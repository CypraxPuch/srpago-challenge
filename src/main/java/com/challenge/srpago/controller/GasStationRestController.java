package com.challenge.srpago.controller;

import com.challenge.srpago.action.InfoRQ;
import com.challenge.srpago.action.Response;
import com.challenge.srpago.data.dao.GasStationDao;
import com.challenge.srpago.data.to.GasStationTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    @PostMapping(value = "/gas-station")
    Response consulta(@Valid @RequestBody InfoRQ infoRQ) {
        Response response = new Response();
        response.setError(null);
        response.setMessage("Correct Information");
        response.setSuccess(Boolean.TRUE);

        Optional<GasStationTo> optional = gasStationDao.getGasStationById(infoRQ.getGasStation());

        System.out.println("input: " + infoRQ.toString());
        System.out.println("result: " + optional.get());

        return response;
    }

}
