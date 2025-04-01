package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.DeleteUserSteps;
import steps.LogInSteps;
import steps.MakeOrderSteps;
import steps.SignUpSteps;

public class MakeOrderTests {
    MakeOrderSteps makeOrderSteps = new MakeOrderSteps();
    SignUpSteps steps = new SignUpSteps();
    LogInSteps loginSteps = new LogInSteps();
    DeleteUserSteps deleteUserSteps = new DeleteUserSteps();
    @Before
    public void setUp() {
        steps.signUp();
        loginSteps.logIn();
    }
    @After
    public void cleanDb() {
        deleteUserSteps.deleteUserAfterLogin();
    }
    @Test
    @DisplayName("Создать заказ c авторизацие")
    public void makeOrderTest(){
        makeOrderSteps.makeOrderStep();
    }
    @Test
    @DisplayName("Создать заказ без авторизации")
    public void makeOrderNoTokenTest(){
        makeOrderSteps.makeOrderStepNegNoToken();
    }
    @Test
    @DisplayName("Создать заказ c несуществующим хешем ингредиента c авторизацие")
    public void makeOrderNoExistentHashTest(){
        makeOrderSteps.makeOrderStepNeg();
    }
    @Test
    @DisplayName("Создать заказ без ингредиентов c авторизацие")
    public void makeOrderNoHashTest(){
        makeOrderSteps.makeOrderStepNegNoHash();
    }
}
