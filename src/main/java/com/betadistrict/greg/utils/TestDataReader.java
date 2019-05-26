package com.betadistrict.greg.utils;

import com.betadistrict.greg.payloads.CreateWalletPayload;
import com.betadistrict.greg.payloads.OutgoingPaymentPayload;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestDataReader {
    @XmlElementWrapper
    @XmlElement(name = "createWalletPayload")
    private List<CreateWalletPayload> createWalletPayloads = new ArrayList<>();
    @XmlElement
    private OutgoingPaymentPayload outgoingPaymentPayload;

    public List<CreateWalletPayload> getCreateWalletPayload() {
        return createWalletPayloads;
    }

    public OutgoingPaymentPayload getOutgoingPaymentPayload() {
        return outgoingPaymentPayload;
    }
}
