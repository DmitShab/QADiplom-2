package apirequests;

import baseHttpClient.BaseHttpClient;
import io.restassured.response.Response;

public class PostApiMakeOrder extends BaseHttpClient {
    private final String path = "/api/orders";
    public Response makeOrder(Object body, String token){
        return doPostRequest(path, body, token);
    }
}