package com.betadistrict.greg.payloads;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseHdEnabled {
    @XmlElement
    private String balance;
    @XmlElement
    private String label;
    @XmlElement
    private String index;
    @XmlElement
    private boolean archived;
    @XmlElement
    private String extendedPublicKey;
    @XmlElement
    private String extendedPrivateKey;
    @XmlElement
    private String receiveIndex;
    @XmlElement
    private String lastUsedReceiveIndex;
    @XmlElement
    private String receiveAddress;

    public String getBalance() {
        return balance;
    }

    public String getLabel() {
        return label;
    }

    public String getIndex() {
        return index;
    }

    public boolean isArchived() {
        return archived;
    }

    public String getExtendedPublicKey() {
        return extendedPublicKey;
    }

    public String getExtendedPrivateKey() {
        return extendedPrivateKey;
    }

    public String getReceiveIndex() {
        return receiveIndex;
    }

    public String getLastUsedReceiveIndex() {
        return lastUsedReceiveIndex;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }
}
