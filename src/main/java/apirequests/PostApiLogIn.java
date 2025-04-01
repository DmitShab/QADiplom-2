package apirequests;

import baseHttpClient.BaseHttpClient;
import io.restassured.response.Response;

public class PostApiLogIn extends BaseHttpClient {
    private final String path = "/api/auth/login";

    public Response logIn(Object body) {
        return doPostRequest(body, path);
    }
}
