package apirequests;

import baseHttpClient.BaseHttpClient;
import io.restassured.response.Response;

public class DeleteApi extends BaseHttpClient {
    private final String path = "/api/auth/user";
    public Response deleteUser(Object body, String token){
        return doDeleteRequest(path, body, token);
    }
}
