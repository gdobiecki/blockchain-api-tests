package com.betadistrict.greg.payloads;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CreateWalletPayload {
    @XmlElement(required = true)
    private String password;

    @XmlElement
    private String second_password;

    @XmlElement(required = true)
    private String api_code;

    @XmlElement(required = true)
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecond_password() {
        return second_password;
    }

    public void setSecond_password(String second_password) {
        this.second_password = second_password;
    }

    public String getApi_code() {
        return api_code;
    }

    public void setApi_code(String api_code) {
        this.api_code = api_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
