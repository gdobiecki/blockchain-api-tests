package com.betadistrict.greg.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TestUtils<T> {
    private final Class<T> typeClass;

    public TestUtils(Class<T> typeClass) {
        this.typeClass = typeClass;
    }

    public T getTestDataFromFile(String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(typeClass);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (T) unmarshaller.unmarshal(new File(path));
    }
}
