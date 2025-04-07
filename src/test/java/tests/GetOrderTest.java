package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.*;

public class GetOrderTest {
    GetOrdersSteps getOrdersSteps = new GetOrdersSteps();
    MakeOrderSteps makeOrderSteps = new MakeOrderSteps();
    SignUpSteps steps = new SignUpSteps();
    LogInSteps loginSteps = new LogInSteps();
    DeleteUserSteps deleteUserSteps = new DeleteUserSteps();
    @Before
    public void setUp() {
        steps.signUp();
        loginSteps.logIn();
        makeOrderSteps.makeOrderStep();
    }
    @After
    public void cleanDb() {
        deleteUserSteps.deleteUserAfterLogin();
    }
    @Test
    @DisplayName("Получить заказ")
    public void getOrderTest(){
        getOrdersSteps.getOrderStep();
    }
    @Test
    @DisplayName("Получить заказ без токена")
    public void gerOrderNoTokenTest(){
        getOrdersSteps.getOrderStepNoToken();
    }
}
