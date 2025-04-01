package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import steps.SignUpSteps;
import testData.TestData;

@RunWith(Parameterized.class)
public class SignUpRequiredFieldsParamTests {
    SignUpSteps steps = new SignUpSteps();
    private final String name;
    private final String email;
    private final String password;

    public SignUpRequiredFieldsParamTests(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"", TestData.generateRandomEmail(), TestData.generateRandomPassword(10)},
                {TestData.generateRandomName(), "", TestData.generateRandomPassword(10)},
                {TestData.generateRandomName(), TestData.generateRandomEmail(), ""},
        };
    }
    @Test
    @DisplayName("Регистрация не заполнив обязательные поля")
    public void signUpParamsTest(){
        steps.signUp(name, email, password);
        steps.checkResponseBodyNegNoRequiredFields();
    }
}
