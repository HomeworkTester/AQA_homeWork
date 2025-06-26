import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import selenium.driver.CustomWebDriverManager;
import selenium.enums.ElementsTab;
import selenium.steps.ElementsSteps;
import selenium.steps.HomeSteps;
import selenium.steps.TextBoxSteps;
import selenium.utils.LoggingExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Homework1Test {

    WebDriver driver = CustomWebDriverManager.getDriver();
    private HomeSteps homeSteps;
    private ElementsSteps elementsSteps;
    private TextBoxSteps textBoxSteps;

    @BeforeEach
    void setUp() {
        homeSteps = new HomeSteps(driver);
        elementsSteps = new ElementsSteps(driver);
        textBoxSteps = new TextBoxSteps(driver);
        homeSteps.openDemoqaPageStep();
    }

    @AfterEach
    void tearDown() {
        homeSteps.closeBrowserStep();
    }

    @ParameterizedTest
    @Description("Форма Text Box — проверка корректного отображения введённых данных")
    @DisplayName("Text Box: валидация ввода и вывода")
    @CsvSource({
            "Петечка Петров, petya@test.com, Алматы, Москва",
            "Иван Иванов, ivan@example.com, Новосибирск, Санкт-Петербург"
    })
    @ExtendWith(LoggingExtension.class)
    void textBoxFormTest(String name, String email, String address, String permAddress) {
        homeSteps.clickElementsCardStep();
        elementsSteps.openTabElements(ElementsTab.TEXT_BOX);


        textBoxSteps.fillForm(name, email, address, permAddress);
        textBoxSteps.submit();

        assertTrue(textBoxSteps.isOutputDisplayed(), "Блок вывода отображается");

        assertEquals("Name:" + name, textBoxSteps.getOutputNameText());
        assertEquals("Email:" + email, textBoxSteps.getOutputEmailText());
        assertEquals("Current Address :" + address, textBoxSteps.getOutputCurrentAddressText());
        assertEquals("Permananet Address :" + permAddress, textBoxSteps.getOutputPermanentAddressText());
    }
}
