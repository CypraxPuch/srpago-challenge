package com.challenge.srpago.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: gpucheta<br/>
 * Date: 9/1/19<br/>
 * Time: 11:50 PM<br/>
 * Generated to
 */
@Entity(name = "gas_sell")
public class GasSell {

    @Id
    private String id;
    @Column(name = "CARD_HOLDER_ID")
    private String cardHolderId;
    @Column(name = "BANK_PAYMENT_CARD_ID")
    private String bankPaymentCardId;
    @Column(name = "GAS_STATION_ID")
    private String gasStationId;
    @Column(name = "GAS_TYPE")
    private String gasType;
    private BigDecimal amount;
    @Column(name = "SELLER_NAME")
    private String sellerName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardHolderId() {
        return cardHolderId;
    }

    public void setCardHolderId(String cardHolderId) {
        this.cardHolderId = cardHolderId;
    }

    public String getBankPaymentCardId() {
        return bankPaymentCardId;
    }

    public void setBankPaymentCardId(String bankPaymentCardId) {
        this.bankPaymentCardId = bankPaymentCardId;
    }

    public String getGasStationId() {
        return gasStationId;
    }

    public void setGasStationId(String gasStationId) {
        this.gasStationId = gasStationId;
    }

    public String getGasType() {
        return gasType;
    }

    public void setGasType(String gasType) {
        this.gasType = gasType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
