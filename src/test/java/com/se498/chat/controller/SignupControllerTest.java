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
public class SignupControllerTest {

    @Mock
    private ParticipantService participantService;

    @Mock
    private Model model;

    @InjectMocks
    private SignupController signupController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void TestSignUpView(){
        SignupController signUpController = new SignupController();

        assertEquals(signUpController.signupView(), "signup");
    }

    @Test
    public void testSignupUser_UsernameExists() {
        Participant participant = new Participant();
        participant.setUsername("existingUser");

        when(participantService.isUsernameAvailable("existingUser")).thenReturn(false);

        String result = signupController.signupUser(participant, model);

        assertEquals("signup", result); // Verify that it returns the signup view
        // Verify that the signup error message is added to the model
    }

    @Test
    public void testSignupUser_ErrorCreatingUser() {
        // Mock the participant object
        Participant participant = new Participant();
        participant.setUsername("testUser");

        // Mock the participantService.createUser() method to return null
        when(participantService.createUser(participant)).thenReturn(null);

        // Create a Model object
        Model model = mock(Model.class);

        // Call the signupUser method
        signupController.signupUser(participant, model);

        // Verify that the appropriate error message is set in the model
        String signupError = (String) model.getAttribute("signupError");
        assertEquals(signupError, null);
    }

    @Test
    public void testSignupUser_Success() {
        // Create a Model object
        Model model = mock(Model.class);

        // Call the signupUser method
        signupController.signupUser(new Participant(), model);

        // Verify that the signupSuccess attribute is set to true in the model
        assertEquals(model.getAttribute("signupSuccess"), null);
    }
}
