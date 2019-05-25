package com.betadistrict.greg.requests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.betadistrict.greg.payloads.CreateWalletPayload;

import static io.restassured.RestAssured.given;

public class RequestHelper {
    private RequestSpecification requestSpecification;

    public RequestHelper(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public Response createNewWallet(CreateWalletPayload createWalletPayload) {
        return given()
                .spec(requestSpecification)
                .body(createWalletPayload)
                .queryParam("hd", "true")
                .post("/create")
                .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract()
                .response();
    }
}
