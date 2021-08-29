package accounts.controller;


import accounts.AccountsApplication;
import accounts.TestData;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@Slf4j
class AccountsControllerTest {

    @LocalServerPort
    private Integer port;
    private Assertions Assert;

    @Test
    public void accountList_shouldReturn200() {

        given()
                .port(port)
                .when()
                .get("/accounts")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void accountTransactionDetails_shouldReturn200() {

        String responseBody = given()
                .port(port)
                .when()
                .get("/accounts/585309209")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().body().asString();

        Assert.assertEquals(TestData.getExpectedDataForTrxns(), responseBody);
    }

    @Test
    public void accountNotAvailable_return404() {

        given()
                .port(port)
                .when()
                .get("/accounts/111111111")
                .then()
                .statusCode(404)
                .log().all();
    }
}