package steps;

import apirequests.PatchApiEditUser;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.PostRequestSignUPPOJO;
import testData.TestData;

import static org.hamcrest.CoreMatchers.equalTo;


public class PatchEditUserSteps {
    PatchApiEditUser patchApiEditUser = new PatchApiEditUser();
    PostRequestSignUPPOJO body;
    Response response;

    @Step("Валидный запрос на редактирование пользователя")
    public Response editUser() {
        body = new PostRequestSignUPPOJO(TestData.generateRandomName(), TestData.generateRandomEmail(), TestData.generateRandomPassword(10));
        response = patchApiEditUser.sendPatchRequest(body, LogInSteps.extractToken());
        return response;
    }
    @Step("запрос на редактирование пользователя без токена")
    public Response editUserNoToken() {
        body = new PostRequestSignUPPOJO(TestData.generateRandomName(), TestData.generateRandomEmail(), TestData.generateRandomPassword(10));
        response = patchApiEditUser.sendPatchRequest(body, "");
        return response;
    }
    @Step("запрос на редактирование если передать почту, которая уже используется")
    public Response editUserSameEmail() {
        body = new PostRequestSignUPPOJO(TestData.generateRandomName(), LogInSteps.body.getEmail(), TestData.generateRandomPassword(10));
        response = patchApiEditUser.sendPatchRequest(body, LogInSteps.extractToken());
        return response;
    }
    @Step("Валидация ответа при успешном редактировании")
    public void checkResponse200(){
        response.then().statusCode(200).assertThat()
                .body("success", equalTo(true))
                .body("user.email", equalTo(body.getEmail()))
                .body("user.name", equalTo(body.getName()));
    }
    @Step("Валидация ответа при отправки запроса будучи неавторизированным")
    public void checkResponseNeg401(){
        response.then().statusCode(401).assertThat()
                .body("success", equalTo(false))
                .body("message", equalTo("You should be authorised"));
    }
    @Step("Валидация ответа при отправки запроса если передать почту, которая уже используется")
    public void checkResponseNeg403(){
        response.then().statusCode(403).assertThat()
                .body("success", equalTo(false))
                .body("message", equalTo("User with such email already exists"));
    }
}
