package apirequests;

import baseHttpClient.BaseHttpClient;
import io.restassured.response.Response;

public class PostApiSignUp extends BaseHttpClient {
    private final String path = "/api/auth/register";

    public Response signUp(Object body){
        return doPostRequest(body, path);
    }
}
