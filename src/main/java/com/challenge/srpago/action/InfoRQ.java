package com.challenge.srpago.action;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: gpucheta<br/>
 * Date: 8/30/19<br/>
 * Time: 11:21 AM<br/>
 * Generated for srpago challenge
 */
public class InfoRQ {


    @NotEmpty(message = "Please provide email.")
    private String email;
    @NotEmpty(message = "Please provide name.")
    private String name;
    @NotEmpty(message = "Please provide last name.")
    private String lastName;
    @NotEmpty(message = "Please provide card number.")
    private String cardNumber;
    @NotNull(message = "Please provide expiration date year.")
    private Integer expirationDateYear;
    @NotEmpty(message = "Please provide expiration date month.")
    private String expirationDateMonth;
    @NotNull(message = "Please provide the gas type.")
    private Integer gasType;
    @NotNull(message = "Please provide amount.")
    @DecimalMin(value = "1.00", message = "Must be greater than or equal to $1.00")
    private Double amount;
    @NotEmpty(message = "Please provide the gas station.")
    private String gasStation;
    @NotEmpty(message = "Please provide a seller name.")
    private String sellerName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getExpirationDateYear() {
        return expirationDateYear;
    }

    public void setExpirationDateYear(Integer expirationDateYear) {
        this.expirationDateYear = expirationDateYear;
    }

    public String getExpirationDateMonth() {
        return expirationDateMonth;
    }

    public void setExpirationDateMonth(String expirationDateMonth) {
        this.expirationDateMonth = expirationDateMonth;
    }

    public Integer getGasType() {
        return gasType;
    }

    public void setGasType(Integer gasType) {
        this.gasType = gasType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getGasStation() {
        return gasStation;
    }

    public void setGasStation(String gasStation) {
        this.gasStation = gasStation;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public String toString() {
        return "InfoRQ{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expirationDateYear=" + expirationDateYear +
                ", expirationDateMonth='" + expirationDateMonth + '\'' +
                ", gasType=" + gasType +
                ", amount=" + amount +
                ", gasStation='" + gasStation + '\'' +
                ", sellerName='" + sellerName + '\'' +
                '}';
    }
}
