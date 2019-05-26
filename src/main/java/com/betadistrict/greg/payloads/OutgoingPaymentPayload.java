package com.betadistrict.greg.payloads;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class OutgoingPaymentPayload {
    @XmlElement(required = true)
    private String main_password;
    @XmlElement(required = true)
    private String second_password;
    @XmlElement(required = true)
    private String to;
    @XmlElement(required = true)
    private String amount;
    @XmlElement
    private String from;
    @XmlElement
    private String fee;

    public String getMain_password() {
        return main_password;
    }

    public void setMain_password(String main_password) {
        this.main_password = main_password;
    }

    public String getSecond_password() {
        return second_password;
    }

    public void setSecond_password(String second_password) {
        this.second_password = second_password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
