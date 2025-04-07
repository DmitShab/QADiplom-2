package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.DeleteUserSteps;
import steps.LogInSteps;
import steps.PatchEditUserSteps;
import steps.SignUpSteps;

public class PatchEditUserTests {
    SignUpSteps steps = new SignUpSteps();
    LogInSteps loginSteps = new LogInSteps();
    DeleteUserSteps deleteUserSteps = new DeleteUserSteps();
    PatchEditUserSteps patchEditUserSteps = new PatchEditUserSteps();

    @Before
    public void setUp() {
        steps.signUp();
    }

    @After
    public void cleanDb() {
        deleteUserSteps.deleteUserAfterLogin();
    }
    @Test
    @DisplayName("Редактирование пользователя")
    public void editUserTest() {
        loginSteps.logIn();
        patchEditUserSteps.editUser();
        patchEditUserSteps.checkResponse200();
    }
    @Test
    @DisplayName("Редактирование пользователя без токена в запросе")
    public void editUserNeg401Test() {
        loginSteps.logIn();
        patchEditUserSteps.editUserNoToken();
        patchEditUserSteps.checkResponseNeg401();
    }
    @Test
    @DisplayName("Редактирование пользователя если передать почту, которая уже используется")
    public void editUserNeg403Test() {
        loginSteps.logIn();
        patchEditUserSteps.editUserSameEmail();
        patchEditUserSteps.checkResponseNeg403();
    }
}
