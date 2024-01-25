package com.titan.software.POJOExperimentos;

import com.titan.software.POJOExperimentos.POJOPratica;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class TesteCodigos {
    private static RequestSpecification recSpec;

    @BeforeAll
    static void setup() {
        baseURI = "http://192.168.2.253";
        //port = 8080;
        basePath = "/ifholding/ApiTitanRest/index.php";
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.log(LogDetail.ALL);
        recSpec = requestSpecBuilder.build();
    }

    @Test
    void resgatarToken() {


        given()
                .spec(recSpec)
                .body("{  \n" +
                        "\"client_id\" : \"5e7fd0c879c2f934ae3c02afa1f83f0f\", \n" +
                        "\"client_secret\" : \"827ccb0eea8a706c4c34a16891f84e7b\"  \n" +
                        "}")
                .when()
                .post("/auth")

                .then()
                //.log().all()
                .statusCode(200);
    }


    @Test
    void VendasAssistidas() {
        given()
                .spec(recSpec)
                .header("Authorization", "eyJhbGciOiAiSFMyNTYiLCAidHlwIjogIkpXVCJ9.ewogICAgICAgICAgICAic3ViIjogIjc3ZDQ2ZGIzNDllZTNkOTU0YmU2MjRjNDdjMGVlZTNmIiwKICAgICAgICAgICAgInVzZXIiOiAiSUZPT0RfVEVTVEUiLAogICAgICAgICAgICAicGFzc3dvcmQiOiAiODI3Y2NiMGVlYThhNzA2YzRjMzRhMTY4OTFmODRlN2IiLAogICAgICAgICAgICAiZ3JvdXAiOiAiYWRtaW5pc3RyYWRvciIsCiAgICAgICAgICAgICJpYXQiOiAiMTY5NTg2MDk0OCIKICAgICAgICB9.NOJLATEylcvW-KbdK8AWJcYAAbtEg2bFHj1FJ37y360")
                //.header("pag", 24)
                .header("requisition_date", "2023-06-01")
                .when()
                .get("/assisted_sales")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("itens", is("24907"))
                .body("paginas", is(1));


    }


    @Test
    public void VendasAssistidasJunit() {
        Response response = RestAssured.request(Method.GET, "http://192.168.2.253/ifholding/ApiTitanRest/index.php/assisted_sales");
        Assertions.assertEquals("24907", response.path("itens"));
        Assertions.assertEquals(new int[1], response.path("paginas"));
        Assertions.assertEquals(Integer.valueOf(1), response.path("paginas"));

    }

    @Test
    void testarValidacao() {
        given()
                .spec(recSpec)
                .header("Authorization", "eyJhbGciOiAiSFMyNTYiLCAidHlwIjogIkpXVCJ9.ewogICAgICAgICAgICAic3ViIjogIjc3ZDQ2ZGIzNDllZTNkOTU0YmU2MjRjNDdjMGVlZTNmIiwKICAgICAgICAgICAgInVzZXIiOiAiSUZPT0RfVEVTVEUiLAogICAgICAgICAgICAicGFzc3dvcmQiOiAiODI3Y2NiMGVlYThhNzA2YzRjMzRhMTY4OTFmODRlN2IiLAogICAgICAgICAgICAiZ3JvdXAiOiAiYWRtaW5pc3RyYWRvciIsCiAgICAgICAgICAgICJpYXQiOiAiMTY5NTg2MDk0OCIKICAgICAgICB9.NOJLATEylcvW-KbdK8AWJcYAAbtEg2bFHj1FJ37y360")
                .header("requisition_date", "2022-01-06")
                .when()
                .get("assisted_sales")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("itens", is("1349"))
                .body("paginas", is(1))
                .body("data", hasSize(1349))
                .body("data[0].origem", is("IFOOD"))
                .body("data.cnpj", notNullValue());
    }

    @Test
    void token2() {
        String userPass = "{\"client_id\" : \"5e7fd0c879c2f934ae3c02afa1f83f0f\", "+
                "\"client_secret\" : \"827ccb0eea8a706c4c34a16891f84e7b\"}";
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(userPass)
                .when()
                .post("/auth");
        String token = response.jsonPath().getString("token");
        System.out.println("Seu token é: " + token);
    }


    @Test
    void token3() {
        POJOPratica newToken = new POJOPratica();
        newToken.setClient_id("5e7fd0c879c2f934ae3c02afa1f83f0f");
        newToken.setClient_secret("827ccb0eea8a706c4c34a16891f84e7b");
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(newToken)
                .when()
                .post("/auth");
        String token = response.jsonPath().getString("token");
        System.out.println("Seu token é: " + token);
    }
}