package selenium.pages;

import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.BasePage;

import static lombok.AccessLevel.PRIVATE;


@FieldDefaults(level = PRIVATE)
public class RadioButtonPage extends BasePage {

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]")
    WebElement radioButtonsContainer;

    @FindBy(xpath = "//label[contains(text(),'Yes')]")
    WebElement yesRadioButton;

    @FindBy(xpath = "//label[contains(text(),'Impressive')]")
    WebElement impressiveRadioButton;

    @FindBy(xpath = "//label[contains(text(),'No')]")
    WebElement noRadioButton;

    @FindBy(xpath = "//input[@id='noRadio']")
    WebElement noRadioButtonInput;

    @FindBy(xpath = "//p[@class='mt-3']")
    WebElement selectedText;

    public WebElement getRadioButtonsContainer() {
        return radioButtonsContainer;
    }

    public WebElement getYesRadioButton() {
        return yesRadioButton;
    }

    public WebElement getImpressiveRadioButton() {
        return impressiveRadioButton;
    }

    public WebElement getNoRadioButton() {
        return noRadioButton;
    }

    public WebElement getNoRadioButtonInput() {
        return noRadioButtonInput;
    }

    public WebElement getSelectedText() {
        return selectedText;
    }
}