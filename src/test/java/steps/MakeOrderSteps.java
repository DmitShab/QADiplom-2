package steps;

import apirequests.PostApiMakeOrder;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.PostMakeOrderRequestPOJO;
import testData.TestData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import static steps.LogInSteps.extractToken;

public class MakeOrderSteps {
    PostApiMakeOrder postApiMakeOrder = new PostApiMakeOrder();
    PostMakeOrderRequestPOJO body;
    Response response;

    @Step("Создать заказ")
    public void makeOrderStep() {
        body = new PostMakeOrderRequestPOJO(TestData.makeIngredientList());
        response = postApiMakeOrder.makeOrder(body, extractToken());
        response.then()
                .statusCode(200)
                .assertThat()
                .body("order.number", notNullValue())
                .body("success", equalTo(true));
    }
    @Step("Создать заказ без авторизации")
    public void makeOrderStepNegNoToken() {
        body = new PostMakeOrderRequestPOJO(TestData.makeIngredientList());
        response = postApiMakeOrder.makeOrder(body, "");
        response.then()
                .statusCode(401)
                .assertThat()
                .body("message", equalTo("You should be authorised"))
                .body("success", equalTo(false));
    }

    @Step("Создать заказ c несуществующим хешем ингредиента")
    public void makeOrderStepNeg() {
        body = new PostMakeOrderRequestPOJO(TestData.makeIngredientListNeg());
        response = postApiMakeOrder.makeOrder(body, extractToken());
        response.then().assertThat()
                .statusCode(500);

    }
    @Step("Создать заказ без ингредиентов")
    public void makeOrderStepNegNoHash() {
        body = new PostMakeOrderRequestPOJO(TestData.makeIngredientListNegNoHash());
        response = postApiMakeOrder.makeOrder(body, extractToken());
        response.then()
                .statusCode(400)
                .assertThat()
                .body("message", equalTo("Ingredient ids must be provided"))
                .body("success", equalTo(false));
    }
}

