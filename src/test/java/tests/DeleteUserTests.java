package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import steps.DeleteUserSteps;
import steps.LogInSteps;
import steps.SignUpSteps;

public class DeleteUserTests {
    SignUpSteps singUp = new SignUpSteps();
    LogInSteps logIn = new LogInSteps();
    DeleteUserSteps delete = new DeleteUserSteps();

    @Before
    public void setUp() {
        singUp.signUp();
    }
    @Test
    @DisplayName("Удаление пользователя")
    public void deleteTests(){
        logIn.logIn();
        logIn.extractToken();
        delete.deleteUserAfterLogin();
    }
}
