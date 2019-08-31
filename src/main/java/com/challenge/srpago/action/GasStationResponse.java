package com.challenge.srpago.action;

import com.challenge.srpago.data.to.GasStationTo;
import com.challenge.srpago.data.to.Pagination;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: gpucheta<br/>
 * Date: 8/30/19<br/>
 * Time: 9:44 PM<br/>
 * Generated to
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GasStationResponse {
    private Pagination pagination;
    private List<GasStationTo> results;

    public GasStationResponse(Pagination pagination, List<GasStationTo> results) {
        this.pagination = pagination;
        this.results = results;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<GasStationTo> getResults() {
        return results;
    }

    public void setResults(List<GasStationTo> results) {
        this.results = results;
    }
}
