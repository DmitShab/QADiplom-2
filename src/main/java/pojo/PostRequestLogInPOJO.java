package pojo;

public class PostRequestLogInPOJO {

    private String email;
    private String password;


    public PostRequestLogInPOJO() {
    }

    public PostRequestLogInPOJO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
