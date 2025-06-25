package selenium.pages;

import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.BasePage;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    // Поля формы
    @FindBy(id = "userName")
    WebElement fullName;

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    @FindBy(id = "submit")
    WebElement submitButton;

    // Блок вывода
    @FindBy(id = "output")
    WebElement outputSection;

    @FindBy(id = "name")
    WebElement outputName;

    @FindBy(id = "email")
    WebElement outputEmail;

    @FindBy(xpath = "//p[@id='currentAddress']")
    WebElement outputCurrentAddress;

    @FindBy(xpath = "//p[@id='permanentAddress']")
    WebElement outputPermanentAddress;

    public WebElement getFullName() {
        return fullName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getCurrentAddress() {
        return currentAddress;
    }

    public WebElement getPermanentAddress() {
        return permanentAddress;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getOutputSection() {
        return outputSection;
    }

    public WebElement getOutputName() {
        return outputName;
    }

    public WebElement getOutputEmail() {
        return outputEmail;
    }

    public WebElement getOutputCurrentAddress() {
        return outputCurrentAddress;
    }

    public WebElement getOutputPermanentAddress() {
        return outputPermanentAddress;
    }
}
