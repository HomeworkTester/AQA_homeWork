package selenium.pages;

import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.BasePage;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Elements']/ancestor::div[contains(@class,'card')]")
    WebElement elementsCard;

    @FindBy(xpath = "//h5[text()='Forms']/ancestor::div[contains(@class,'card-body')]")
    WebElement formsCard;

    public WebElement getFormsCard() {
        return formsCard;
    }

    public WebElement getElementsCard() {
        return elementsCard;
    }
}
