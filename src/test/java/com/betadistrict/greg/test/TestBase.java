package com.betadistrict.greg.test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.betadistrict.greg.requests.RequestHelper;
import com.betadistrict.greg.utils.TestDataReader;
import com.betadistrict.greg.utils.TestUtils;

import javax.xml.bind.JAXBException;

public class TestBase {
    protected TestDataReader testDataReader;
    protected RequestSpecification requestSpecification;
    protected RequestHelper requestHelper;

    @Parameters({"pathToFile", "baseUri", "basePath"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String pathToFile, String baseUri, String basePath) throws JAXBException {
        testDataReader = new TestUtils<>(TestDataReader.class).getTestDataFromFile(pathToFile);

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setBasePath(basePath)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        requestHelper = new RequestHelper(requestSpecification);
    }
}
