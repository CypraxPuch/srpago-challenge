package com.challenge.srpago.data.dao;

import com.challenge.srpago.action.GasStationResponse;
import com.challenge.srpago.data.to.GasStationTo;
import com.challenge.srpago.data.to.Pagination;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: gpucheta<br/>
 * Date: 8/31/19<br/>
 * Time: 8:09 AM<br/>
 * Generated to
 */
@Component
public class GasStationDao {

    private RestTemplate restTemplate;
    private final String GAS_STATION_INFO_URL = "https://api.datos.gob.mx/v1/precio.gasolina.publico";
    private static List<GasStationTo> gasStationList = new ArrayList<>();

    public GasStationDao(@Qualifier("restTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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
}
