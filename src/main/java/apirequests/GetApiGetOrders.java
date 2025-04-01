package apirequests;

import baseHttpClient.BaseHttpClient;
import io.restassured.response.Response;

public class GetApiGetOrders extends BaseHttpClient {
    private final String path = "/api/orders";
    public Response getOrders(String token){
        return doGetRequest(path, token);
    }
}
