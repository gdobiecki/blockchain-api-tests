package com.betadistrict.greg.utils;

import com.betadistrict.greg.payloads.CreateWalletPayload;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestDataReader {
    @XmlElement
    private CreateWalletPayload createWalletPayload;

    public CreateWalletPayload getCreateWalletPayload() {
        return createWalletPayload;
    }
}
