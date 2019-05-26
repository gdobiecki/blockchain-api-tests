package com.betadistrict.greg.utils;

import com.betadistrict.greg.payloads.CreateWalletPayload;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestDataReader {
    @XmlElement(name = "createWalletPayload")
    private CreateWalletPayload createWalletPayload;

    public CreateWalletPayload getCreateWalletPayload() {
        return createWalletPayload;
    }
}
