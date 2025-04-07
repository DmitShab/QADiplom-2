package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.DeleteUserSteps;
import steps.LogInSteps;
import steps.SignUpSteps;

public class LogInTests {
    SignUpSteps steps = new SignUpSteps();
    LogInSteps loginSteps = new LogInSteps();
    DeleteUserSteps deleteUserSteps = new DeleteUserSteps();

    @Before
    public void setUp() {
        steps.signUp();
    }

    @After
    public void cleanDb() {
        deleteUserSteps.deleteUserAfterSignp();
    }
    @Test
    @DisplayName("Вход с валидными данными")
    public void logInTest() {
        loginSteps.logIn();
        loginSteps.checkResponseLogIn();
    }

    @Test
    @DisplayName("Вход с невалидным email")
    public void logInNegTest() {
        loginSteps.logInNonexistentEmail();
        loginSteps.checkResponseIncorrectLogIn();
    }

    @Test
    @DisplayName("Вход с невалидным password")
    public void logInNeg1Test() {
        loginSteps.logInNonexistentPassword();
        loginSteps.checkResponseIncorrectLogIn();
    }
}
