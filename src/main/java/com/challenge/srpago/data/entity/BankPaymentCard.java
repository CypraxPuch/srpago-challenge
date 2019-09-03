package com.challenge.srpago.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: gpucheta<br/>
 * Date: 9/1/19<br/>
 * Time: 11:49 PM<br/>
 * Generated to
 */
@Entity(name = "bank_payment_card")
public class BankPaymentCard {
    @Id
    private String id;
    @Column(name = "CARD_NUMBER")
    private String cardNumber;
    @Column(name = "EXPIRATION_YEAR")
    private String expirationYear;
    @Column(name = "EXPIRATION_MONTH")
    private String expirationMonth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }
}
