import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import selenide.steps.TextBoxSelenSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TextBoxSelenideTest {

    private final TextBoxSelenSteps steps = new TextBoxSelenSteps();

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 1000;
    }

    @AfterAll
    static void tearDown() {
        closeWebDriver();
    }

    @Test
    void testTextBoxForm() {
        steps.openTextBoxPage();
        steps.fillForm("Артем QA", "qa@test.com", "г. Казань", "ул. Тестовая");
        steps.submitForm();
        steps.verifyFormSubmission("Артем QA", "qa@test.com", "г. Казань", "ул. Тестовая");
    }
}
