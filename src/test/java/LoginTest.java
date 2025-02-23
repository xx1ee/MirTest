import org.example.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends BaseTest {

    private void handleAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            Assertions.assertTrue(alertText.equals("Неверные данные для авторизации")
                            || alertText.equals("Неверные данные для авторизации."),
                    "Ожидалось сообщение 'Неверные данные для авторизации'.");
            alert.accept();
        } catch (Exception e) {
            Assertions.fail("Ожидалось предупреждение с текстом 'Неверные данные для авторизации'.");
        }
    }

    private void verifySuccessfulLogin() {
        String expectedTitle = "Mirapolis LMS";
        Assertions.assertEquals(expectedTitle, driver.getTitle(),
                "Пользователь должен успешно войти и оказаться на главной странице.");
    }

    @ParameterizedTest
    @CsvSource({
            "fominaelena, 1P73BP4Z, true",
            "FOMINAELENA, 1P73BP4Z, true",
            "fominaelena, wrongpassword, false",
            "wronglogin, 1P73BP4Z, false",
            "'', '', false",
            "'', 1P73BP4Z, false",
            "fominaelena, '', false",
            "fominaelena, ' OR '1'='1', false",
    })
    public void testLogin(String username, String password, boolean isSuccessExpected) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        if (isSuccessExpected) {
            verifySuccessfulLogin();
        } else {
            handleAlert();
        }
    }
}
