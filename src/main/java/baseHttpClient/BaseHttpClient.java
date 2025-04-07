package baseHttpClient;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import url.URL;

import static io.restassured.RestAssured.given;

public abstract class BaseHttpClient {
    private RequestSpecification baseRequestSpec = new RequestSpecBuilder()
            .setBaseUri(URL.HOST)
            .addHeader("Content-Type", "application/json")
            .setRelaxedHTTPSValidation()
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new ErrorLoggingFilter())
            .build();

    protected Response doPostRequest(Object body, String path) {
        return given()
                .spec(baseRequestSpec)
                .body(body)
                .when().post(path)
                .thenReturn();
    }
    protected Response doPostRequest(String path, Object body, String token) {
        return given()
                .spec(baseRequestSpec)
                .header("Authorization", token)
                .body(body)
                .when().post(path)
                .thenReturn();
    }
    protected Response doDeleteRequest(String path, Object body, String token){
        return given()
                .spec(baseRequestSpec)
                .header("Authorization", token)
                .body(body)
                .when().delete(path)
                .thenReturn();
    }
    protected Response doPatchRequest(String path, Object body, String token){
        return given()
                .spec(baseRequestSpec)
                .header("Authorization", token)
                .body(body)
                .when().patch(path)
                .thenReturn();
    }
    protected Response doGetRequest(String path, String token){
        return given()
                .spec(baseRequestSpec)
                .header("Authorization", token)
                .when().get(path)
                .thenReturn();
    }

}
