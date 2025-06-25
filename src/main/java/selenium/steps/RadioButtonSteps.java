package selenium.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pages.RadioButtonPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static io.qameta.allure.Allure.step;


public class RadioButtonSteps {

    private final WebDriverWait wait;
    private final RadioButtonPage radioButtonPage;

    public RadioButtonSteps(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.radioButtonPage = new RadioButtonPage(driver);
    }

    public boolean isRadioButtonsContainerDisplayedStep() {
        step("Проверка отображения блока радиокнопок и вывода", () -> {
            wait.until(ExpectedConditions.visibilityOf(radioButtonPage.getRadioButtonsContainer()));
        });
        return radioButtonPage.getRadioButtonsContainer().isDisplayed();
    }

    public void clickYesStep() {
        step("Клик по радиокнопке YES",
                () -> wait.until(ExpectedConditions.elementToBeClickable(radioButtonPage.getYesRadioButton())).click());
    }

    public void clickImpressiveStep() {
        step("Клик по радиокнопке Impressive",
                () -> wait.until(ExpectedConditions.elementToBeClickable(radioButtonPage.getImpressiveRadioButton())).click());
    }

    public boolean isNoRadioButtonDisplayedStep() {
        step("Проверка отображения кнопки NO");
        return radioButtonPage.getNoRadioButton().isDisplayed();
    }

    public boolean isNoRadioButtonDisabledStep() {
        step("Проверка кнопки NO disable");
        return !radioButtonPage.getNoRadioButtonInput().isEnabled();
    }

    public String getSelectedTextStep() {
        step("Проверка вывода после активации радиокнопки",
                () -> wait.until(ExpectedConditions.visibilityOf(radioButtonPage.getSelectedText())));
        return radioButtonPage.getSelectedText().getText();
    }
}
