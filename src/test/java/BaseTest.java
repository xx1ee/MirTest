import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        String driverPath = getDriverPathFromProperties();
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        this.driver = driver;
        driver.manage().window().maximize();
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private String getDriverPathFromProperties() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(input);
            return properties.getProperty("chrome.driver.path");
        } catch (IOException e) {
            throw new RuntimeException("Не удалось загрузить application.properties", e);
        }
    }
}