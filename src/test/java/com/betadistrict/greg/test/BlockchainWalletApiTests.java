package com.betadistrict.greg.test;

import com.betadistrict.greg.payloads.CreateWalletPayload;
import com.betadistrict.greg.payloads.Wallet;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BlockchainWalletApiTests extends TestBase {
    private Wallet wallet;

    @Test(dataProvider = "walletDataProvider", priority = 1)
    public void createNewWallet(CreateWalletPayload createWalletPayload) {
        wallet = requestHelper.createNewWallet(createWalletPayload);
        assertEquals(wallet.getWarning(), "Created non-HD wallet, for privacy and security, it is recommended that new wallets are created with hd=true");
    }

    @Test(priority = 2)
    public void enableHD() {
        requestHelper.enableHD(wallet.getGuid());
    }

    @Test(priority = 3)
    public void createNewHDAccount_archiveIt() {
        String walletGuid = wallet.getGuid();
        Response response = requestHelper.createHdAccount(walletGuid);
        JsonPath jsonPath = response.jsonPath();
        assertFalse(jsonPath.get("archived"));
        assertTrue(jsonPath.getList("address_labels").isEmpty());

        String xpub = jsonPath.get("xpub").toString();

        Response r = requestHelper.archiveAccount(walletGuid, xpub);
        JsonPath jp = r.jsonPath();
        assertTrue(jp.get("archived"));
    }

    @Test(priority = 4)
    public void getFirstWalletBalance() {
        Response response = requestHelper.getWalletBalance(wallet.getGuid());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.get("balance").toString(), "0");
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
