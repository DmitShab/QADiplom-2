package pojo.postLoginResponse;




public class FullBody {
    private Boolean success;
    private String accessToken;
    private String refreshToken;
    private User user;

    public Boolean getSuccess() {
        return success;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public User getUser() {
        return user;
    }

//    public FullBody() {
//    }
}
