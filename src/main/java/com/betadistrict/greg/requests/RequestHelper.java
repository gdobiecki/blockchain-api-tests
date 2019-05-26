package com.betadistrict.greg.requests;

import com.betadistrict.greg.payloads.ResponseHdEnabled;
import com.betadistrict.greg.payloads.Wallet;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.betadistrict.greg.payloads.CreateWalletPayload;

import static io.restassured.RestAssured.given;

public class RequestHelper {
    private RequestSpecification requestSpecification;

    public RequestHelper(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public Wallet createNewWallet(CreateWalletPayload createWalletPayload) {
        return given()
                .spec(requestSpecification)
                .body(createWalletPayload)
                .post("/api/v2/create")
                .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract()
                .response()
                .as(Wallet.class);
    }

    public Response getWalletBalance(String guid) {
        return given()
                .spec(requestSpecification)
                .queryParam("password", "B3t4D15Trict")
                .get("/merchant/{walletGuid}/balance/", guid)
                .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract()
                .response();
    }

    public ResponseHdEnabled enableHD(String guid) {
        return given()
                .spec(requestSpecification)
                .queryParam("password", "B3t4D15Trict")
                .queryParam("second_password", "An0th3rPassword")
                .get("/merchant/{guid}/enableHD", guid)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response()
                .as(ResponseHdEnabled.class);
    }

    public Response createHdAccount(String walletGuid) {
        return given()
                .spec(requestSpecification)
                .queryParam("password", "B3t4D15Trict")
                .queryParam("second_password", "An0th3rPassword")
                .get("/merchant/{guid}/accounts/create", walletGuid)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();

    }

    public Response archiveAccount(String walletGuid, String xpub) {
        return given()
                .spec(requestSpecification)
                .queryParam("password", "B3t4D15Trict")
                .queryParam("second_password", "An0th3rPassword")
                .get("/merchant/{guid}/accounts/{xpub}/archive", walletGuid, xpub)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();
    }
}
