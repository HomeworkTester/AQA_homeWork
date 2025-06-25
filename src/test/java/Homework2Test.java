import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import selenium.driver.CustomWebDriverManager;
import selenium.enums.ElementsTab;
import selenium.enums.FormsTab;
import selenium.steps.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Homework2Test {

    WebDriver driver = CustomWebDriverManager.getDriver();
    private HomeSteps homeSteps;
    private RadioButtonSteps radioButtonSteps;
    private ElementsSteps elementsSteps;
    private FormsSteps formsSteps;
    private PracticeFormSteps practiceFormSteps;

    @BeforeEach
    void setUp() {
        homeSteps = new HomeSteps(driver);
        radioButtonSteps = new RadioButtonSteps(driver);
        elementsSteps = new ElementsSteps(driver);
        formsSteps = new FormsSteps(driver);
        practiceFormSteps = new PracticeFormSteps(driver);
        homeSteps.openDemoqaPageStep();
    }

    @AfterEach
    void tearDown() {
        homeSteps.closeBrowserStep();
    }

    @Test
    @Description("Форма Radio Button — проверка корректного отображения данных по нажатию радиокнопок")
    @DisplayName("Radio Button: валидация ввода и вывода")
    void radioButtonTest() {
        homeSteps.clickElementsCardStep();
        elementsSteps.openTabElements(ElementsTab.RADIO_BUTTON);

        assertTrue(radioButtonSteps.isRadioButtonsContainerDisplayedStep(), "Блок радио кнопок не отображается");

        radioButtonSteps.clickYesStep();
        assertEquals(radioButtonSteps.getSelectedTextStep(), "You have selected Yes");

        radioButtonSteps.clickImpressiveStep();
        assertEquals(radioButtonSteps.getSelectedTextStep(), "You have selected Impressive");

        assertTrue(radioButtonSteps.isNoRadioButtonDisplayedStep(), "Кнопка NO отображается");
        assertTrue(radioButtonSteps.isNoRadioButtonDisabledStep(), "Кнопка NO Disable");

    }

    @ParameterizedTest
    @Description("Форма Practice Form — заполнение формы и валидация заполненных полей")
    @DisplayName("Practice Form: валидация ввода и вывода")
    @CsvSource({
            "Игорь, QAспециалист, igorQA@test.com, 7777777777, г. Москва пр.Ленина, Maths, 11, June, 2015",
            "Илья, BackРазработчик, back@test.com, 8888888888, г. ekb Nekrasova, Maths, 29, June, 2000"
    })
    void practiceFormWorkflowTest(String firstName, String lastName, String email, String mobile, String address,
                                  String subjects, String day, String month, String year) throws InterruptedException {
        homeSteps.clickFormsCardStep();
        formsSteps.openTabForms(FormsTab.PRACTICE_FORM);

        practiceFormSteps.practiceFillForm(firstName, lastName, email, mobile, address);
        practiceFormSteps.selectDateOfBirth(month, year, day);
        practiceFormSteps.setSubject(subjects);
        Thread.sleep(5000);

        practiceFormSteps.submitForm();
        practiceFormSteps.verifyModal(firstName, lastName, email, mobile, address, subjects, month, year, day);

        practiceFormSteps.closeModal();
        practiceFormSteps.verifyFormIsCleared();

    }
}
