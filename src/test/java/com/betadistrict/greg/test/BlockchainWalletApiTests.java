package com.betadistrict.greg.test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.betadistrict.greg.payloads.CreateWalletPayload;

import static org.testng.Assert.assertEquals;

public class BlockchainWalletApiTests extends TestBase {
    private String guid;

    @Test(dataProvider = "walletDataProvider")
    public void createNewWallet(CreateWalletPayload createWalletPayload) {
        Response response = requestHelper.createNewWallet(createWalletPayload);
        JsonPath jsonPath = response.jsonPath();
        guid = jsonPath.get("guid");
        assertEquals(jsonPath.get("label"), "some_label");
    }

    @DataProvider
    public Object[][] walletDataProvider() {
        CreateWalletPayload createWalletPayload = testDataReader.getCreateWalletPayload();

        return new Object[][]{
                new Object[]{
                        createWalletPayload
                }
        };
    }
}
