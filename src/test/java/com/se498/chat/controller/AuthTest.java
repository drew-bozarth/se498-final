package com.se498.chat.controller;

import com.se498.chat.TestChatApplication;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;


import com.se498.chat.controller.SignupController;
import com.se498.chat.model.Participant;
import com.se498.chat.service.ParticipantService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {TestChatApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthTest {

    @Mock
    private ParticipantService participantService;

    @Mock
    private Model model;

    @InjectMocks
    private SignupController signupController;

    @LocalServerPort
    private Integer port;

    @Test
    void testAuth() {

        RestAssured
                .given()
                .filter(new RequestLoggingFilter())
                .auth().basic("drew", "chapman")
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:" + port + "/image/1")
                .then()
                .statusCode(200)
                .extract();
    }
}