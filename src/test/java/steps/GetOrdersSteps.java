package steps;

import apirequests.GetApiGetOrders;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetOrdersSteps {
    GetApiGetOrders getApiGetOrders = new GetApiGetOrders();
    Response response;

    @Step("Получить заказ")
    public Response getOrderStep() {
        response = getApiGetOrders.getOrders(LogInSteps.extractToken());
        response.then().statusCode(200).assertThat()
                .body("success", equalTo(true))
                .body("orders._id", notNullValue());
        return response;
    }

    @Step("Получить заказ без токена")
    public void getOrderStepNoToken() {
        response = getApiGetOrders.getOrders("");
        response.then().statusCode(401).assertThat()
                .body("success", equalTo(false))
                .body("message", equalTo("You should be authorised"));

    }
}