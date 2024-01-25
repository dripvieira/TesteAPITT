package com.titan.software.api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TesteApi {


    @Test
    public void testeAdministradorFaturamentoToken() {
        baseURI = "http://192.168.2.253";
        basePath = "/ifholding/ApiTitanRest/index.php";


        String token = given()
            .body("{  \n" +
                        "\"client_id\" : \"5e7fd0c879c2f934ae3c02afa1f83f0f\", \n" +
                        "\"client_secret\" : \"827ccb0eea8a706c4c34a16891f84e7b\"  \n" +
                        "} ")
                .contentType(ContentType.JSON)
            .when()
                .post("/auth")
            .then()
                .log().all()
                .extract()
                .path("token");

        System.out.println(token);

            given()
                    .header("Authorization", token)
                    .header("pag", 29)
                    .header("requisition_date", "2022-07")
            .when()
                    .get("/invoice")
            .then()
                    .log().all()
                    .assertThat()
                    .statusCode(200);

    }


    @Test
    public void testeAdministradorVendasAssistidasToken() {
        baseURI = "http://192.168.2.253";
        basePath = "/ifholding/ApiTitanRest/index.php";


        String token = given()
                .body("{  \n" +
                        "\"client_id\" : \"5e7fd0c879c2f934ae3c02afa1f83f0f\", \n" +
                        "\"client_secret\" : \"827ccb0eea8a706c4c34a16891f84e7b\"  \n" +
                        "} ")
                .contentType(ContentType.JSON)
                .when()
                .post("/auth")
                .then()
                .log().all()
                .extract()
                .path("token");

        System.out.println(token);


        given()
                .header("Authorization", token)
                //.header("pag", 24)
                .header("requisition_date", "2023-06-01")
        .when()
                .get("/assisted_sales")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }
}
