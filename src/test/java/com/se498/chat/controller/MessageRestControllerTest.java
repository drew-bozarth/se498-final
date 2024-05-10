package com.se498.chat.controller;

import com.se498.chat.TestChatApplication;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.TimeToLive;
import org.mockserver.matchers.Times;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@SpringBootTest(classes = TestChatApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageRestControllerTest {
    //TODO: Implement message REST controller test

    @LocalServerPort
    private static Integer port;

    @BeforeAll
    static void init(){

        ClientAndServer.startClientAndServer(1090);

        new MockServerClient("localhost", 1090)
                .when(
                        request()
                                .withMethod("GET")
                                .withPath("/message/1"),
                        Times.unlimited(),
                        TimeToLive.unlimited(),
                        0
                )
                .respond(
                        response()
                                .withBody("{\n \"messageId\" : \"1\", \"username\" : \"John\", \"messageText\" : \"Hello World!\", \"seed\" : 10\n}")
                );
    }
    //@Disabled // Disabling my written tests for now
    @Test
    void testGetMessageById() throws JSONException {

        String expectedJson = "{\"messageId\" : \"1\", \"username\" : \"John\", \"messageText\" : \"Hello World!\", \"seed\" : 10}";

        ExtractableResponse<Response> response = RestAssured
                .given()
                .filter(new RequestLoggingFilter())
                .auth().basic("drew", "chapman")
                .contentType(ContentType.JSON)
                .when()
                .get("http://54.243.22.124:" + 1090 + "/message/1")
                .then()
                .statusCode(200)
                .extract();

        JSONAssert.assertEquals(expectedJson, response.body().asPrettyString(),true);
    }
}
