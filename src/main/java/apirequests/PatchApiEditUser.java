package apirequests;

import baseHttpClient.BaseHttpClient;
import io.restassured.response.Response;

public class PatchApiEditUser extends BaseHttpClient {
    private final String path = "/api/auth/user";
    public Response sendPatchRequest(Object body, String token){
        return doPatchRequest(path, body, token);
    }
}
