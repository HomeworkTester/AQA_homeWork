package selenium.steps;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pages.TextBoxPage;

import java.time.Duration;

import static io.qameta.allure.Allure.step;

public class TextBoxSteps {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final TextBoxPage textBoxPage;

    public TextBoxSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.textBoxPage = new TextBoxPage(driver);
    }

    public void fillForm(String name, String mail, String address, String permAddress) {
        step("Заполнение формы Text Box - Full Name, Mail, Current Address, Permanent Address", () -> {
            textBoxPage.getFullName().sendKeys(name);
            textBoxPage.getEmail().sendKeys(mail);
            textBoxPage.getCurrentAddress().sendKeys(address);
            textBoxPage.getPermanentAddress().sendKeys(permAddress);
        });
    }

    public void submit() {
        step("Клик по кнопке Submit на форме Text Box", () -> {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(textBoxPage.getSubmitButton())).click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript(
                        "document.querySelectorAll('iframe').forEach(el => el.style.display='none')"
                );
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", textBoxPage.getSubmitButton());
            }
        });
    }

    public boolean isOutputDisplayed() {
        boolean outputSection = textBoxPage.getOutputSection().isDisplayed();
        step("Блок вывода на форме Text Box - " + outputSection);
        return outputSection;
    }

    public String getOutputNameText() {
        String outputName = textBoxPage.getOutputName().getText();
        step("Вывод Name - " + outputName);
        return outputName;
    }

    public String getOutputEmailText() {
        String outputEmail = textBoxPage.getOutputEmail().getText();
        step("Вывод Email - " + outputEmail);
        return outputEmail;
    }

    public String getOutputCurrentAddressText() {
        String outputCurrentAddress = textBoxPage.getOutputCurrentAddress().getText();
        step("Вывод Current Address - " + outputCurrentAddress);
        return outputCurrentAddress;
    }

    public String getOutputPermanentAddressText() {
        String outputPermanentAddress = textBoxPage.getOutputPermanentAddress().getText();
        step("Вывод Permanent Address - " + outputPermanentAddress);
        return outputPermanentAddress;
    }
}
