package steps;

import apirequests.DeleteApi;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.DeleteRequestPOJO;

import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteUserSteps {
    DeleteApi delete = new DeleteApi();
    DeleteRequestPOJO body;
    Response response;

    @Step("Удаление существующего юзера получение токена через logIn")
    public Response deleteUserAfterLogin() {
        body = new DeleteRequestPOJO(LogInSteps.extractToken());
        response = delete.deleteUser(body, body.getToken());
        response.then().statusCode(202).assertThat().body("success", equalTo(true));
        return response;
    }
    @Step("Удаление существующего юзера получение токена через signUp")
    public Response deleteUserAfterSignp() {
        body = new DeleteRequestPOJO(SignUpSteps.signUpToken);
        response = delete.deleteUser(body, body.getToken());
        response.then().statusCode(202).assertThat().body("success", equalTo(true));
        return response;
    }
}
