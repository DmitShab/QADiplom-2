package steps;

import apirequests.PostApiSignUp;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.PostRequestSignUPPOJO;
import testData.TestData;

import static org.hamcrest.CoreMatchers.equalTo;

public class SignUpSteps {
    PostApiSignUp postApiSignUp = new PostApiSignUp();
    Response response;
    static PostRequestSignUPPOJO body;
    public static String signUpToken;

    @Step("Регистрация")
    public Response signUp() {
        body = new PostRequestSignUPPOJO(TestData.generateRandomName(), TestData.generateRandomEmail(), TestData.generateRandomPassword(10));
        response = postApiSignUp.signUp(body);
        signUpToken = response.jsonPath().getString("accessToken");
        return response;
    }

    //Для параметризации
    @Step("Регистрация")
    public Response signUp(String name, String email, String password) {
        body = new PostRequestSignUPPOJO(name, email, password);
        response = postApiSignUp.signUp(body);
        signUpToken = response.jsonPath().getString("accessToken");
        return response;
    }

    @Step("Провалидировали код-статус и тело ответа при успешном запросе")
    public void checkResponseBodyPos() {
        response.then().statusCode(200).assertThat().body("success", equalTo(true));
    }

    @Step("Регистрация уже зарегестрированного пользователя")
    public Response signUpDouble() {
        body = new PostRequestSignUPPOJO(body.getName(), body.getEmail(), body.getPassword());
        response = postApiSignUp.signUp(body);
        return response;
    }

    @Step("Провалидировали код-статус и тело ответа при регистрации уже зарегестрированного пользователя")
    public void checkResponseBodyNeg() {
        response.then().statusCode(403)
                .assertThat()
                .body("success", equalTo(false))
                .body("message", equalTo("User already exists"));

    }
    @Step("Провалидировали код-статус и тело ответа при регистрации без заполнения обязательных полей")
    public void checkResponseBodyNegNoRequiredFields() {
        response.then().statusCode(403)
                .assertThat()
                .body("success", equalTo(false))
                .body("message", equalTo("Email, password and name are required fields"));

    }

}