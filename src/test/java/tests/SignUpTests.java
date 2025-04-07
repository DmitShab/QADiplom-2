package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import steps.DeleteUserSteps;
import steps.SignUpSteps;

public class SignUpTests {
    SignUpSteps steps = new SignUpSteps();
    DeleteUserSteps deleteUserSteps = new DeleteUserSteps();

    @After
    public void clear() {
        deleteUserSteps.deleteUserAfterSignp();
    }

    @Test
    @DisplayName("Успешная регистрация уникального пользователя")
    public void signUpTest() {
        steps.signUp();
        steps.checkResponseBodyPos();
    }

    @Test
    @DisplayName("Неуспешная регистрация ранее созданного пользователя")
    public void signUpNegTest() {
        steps.signUp();
        steps.signUpDouble();
        steps.checkResponseBodyNeg();
    }
}
