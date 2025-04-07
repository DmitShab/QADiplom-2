package steps;

import apirequests.PostApiLogIn;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.PostRequestLogInPOJO;
import pojo.postLoginResponse.FullBody;
import testData.TestData;

import static org.hamcrest.CoreMatchers.equalTo;

public class LogInSteps {
    PostApiLogIn post = new PostApiLogIn();
    static PostRequestLogInPOJO body;
    static Response response;

    @Step("логин под существующим пользователем")
    public Response logIn() {
        body = new PostRequestLogInPOJO(SignUpSteps.body.getEmail(), SignUpSteps.body.getPassword());
        response = post.logIn(body);
        return response;
    }

    @Step("Валидацая ответа при входе")
    public void checkResponseLogIn() {
        response.then().statusCode(200).assertThat()
                .body("success", equalTo(true));
    }

    @Step("логин с неверным email")
    public Response logInNonexistentEmail() {
        body = new PostRequestLogInPOJO(TestData.generateRandomEmail(), SignUpSteps.body.getPassword());
        response = post.logIn(body);
        return response;
    }

    @Step("логин с неверным password")
    public Response logInNonexistentPassword() {
        body = new PostRequestLogInPOJO(SignUpSteps.body.getEmail(), TestData.generateRandomPassword(10));
        response = post.logIn(body);
        return response;
    }

    @Step("Валидацая ответа при некорректном входе")
    public void checkResponseIncorrectLogIn() {
        response.then().statusCode(401).assertThat()
                .body("success", equalTo(false));
    }

    @Step("Получение токена")
    public static String extractToken() {
        return response.as(FullBody.class).getAccessToken();
    }
}
