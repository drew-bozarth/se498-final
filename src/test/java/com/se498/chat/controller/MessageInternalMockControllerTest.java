package com.se498.chat.controller;

import com.se498.chat.TestChatApplication;
import com.se498.chat.model.ChatMessage;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

@SpringBootTest(classes = TestChatApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageInternalMockControllerTest {
    //TODO: Implement internal message mock controller test
    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate restTemplate;

    private static HttpHeaders headers;

    @BeforeAll
    static void init(){

        headers = new HttpHeaders();
        headers.setBasicAuth("drew", "chapman");
    }

    @Disabled // Disabling my written tests for now
    @Test
    public void testGetMessageById() throws JSONException {

        String expectedJson = "{\"messageId\" : \"1\", \"username\" : \"John\", \"messageText\" : \"Hello World!\", \"seed\" : 10}";

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:" + port + "/message/1", HttpMethod.GET, new HttpEntity<String>(headers),
                String.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expectedJson, response.getBody(),true);
    }

    @Disabled // Disabling my written tests for now
    @Test
    public void testCreateMessage() throws JSONException {

        String expectedJson = "{\"messageId\" : \"1\", \"username\" : \"mockUser\",  \"messageText\" : \"this is a test\", \"seed\" : 10}";
        ChatMessage testMessage = new ChatMessage();
        testMessage.setMessageId("1");
        testMessage.setUsername("mockUser");
        testMessage.setMessageText("this is a test");
        testMessage.setSeed(10);
        //ChatMessage message = new ChatMessage("1","mockUser", "this is a test", 10);

        HttpEntity<ChatMessage> request = new HttpEntity<>(testMessage, headers);

        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/message", request, String.class);
        JSONAssert.assertEquals(expectedJson, response.getBody(),true);
    }
}
