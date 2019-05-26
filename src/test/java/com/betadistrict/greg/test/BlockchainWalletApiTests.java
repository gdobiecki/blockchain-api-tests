package com.betadistrict.greg.test;

import com.betadistrict.greg.payloads.Wallet;
import com.betadistrict.greg.utils.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.betadistrict.greg.payloads.CreateWalletPayload;


import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BlockchainWalletApiTests extends TestBase {
    private List<Wallet> walletList = new ArrayList<>();

    @Test(dataProvider = "walletDataProvider", priority = 1)
    public void createNewWallet(CreateWalletPayload createWalletPayload) {
        Wallet createdWallet = requestHelper.createNewWallet(createWalletPayload);
        walletList.add(createdWallet);
        assertEquals(createdWallet.getWarning(), "Created non-HD wallet, for privacy and security, it is recommended that new wallets are created with hd=true");
    }

    @Test(dataProvider = "walletGuidDataProvider", priority = 2)
    public void enableHD(String walletGuid) {
        requestHelper.enableHD(walletGuid);
    }

    @Test(dataProvider = "walletGuidDataProvider", priority = 3)
    public void createNewHDAccount_archiveIt(String walletGuid) {
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
    @Ignore
    public void getFirstWalletBalance() {
        Response response = requestHelper.getWalletBalance(walletList.get(0).getGuid());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.get("balance").toString(), "0");
    }

    @DataProvider
    public Object[][] walletDataProvider() {
        List<CreateWalletPayload> createWalletPayloads = testDataReader.getCreateWalletPayload();

        return TestUtils.payloadsToArray(createWalletPayloads);
    }

    @DataProvider
    public Object[][] walletGuidDataProvider() {
        List<String> guids = new ArrayList<>();
        walletList.forEach(wallet -> guids.add(wallet.getGuid()));

        return TestUtils.payloadsToArray(guids);
    }
}
