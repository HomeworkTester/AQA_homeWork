package selenium.pages;

import lombok.experimental.FieldDefaults;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import selenium.BasePage;

import static lombok.AccessLevel.PRIVATE;

/**
 * Page Object для страницы Elements.
 * Содержит навигацию по боковому меню.
 */
@FieldDefaults(level = PRIVATE)
public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    // Заголовок группы "Elements" в левом меню (свернутый режим)
    @FindBy(xpath = "//div[@class='element-group'][1]/span")
    WebElement minElementsMenuHeader;

    // Заголовок группы "Elements" в левом меню (развернутый режим)
    @FindBy(xpath = "//div[@class='element-group'][1]")
    WebElement maxElementsMenuHeader;

    public WebElement getMinElementsMenuHeader() {
        return minElementsMenuHeader;
    }

    public WebElement getMaxElementsMenuHeader() {
        return maxElementsMenuHeader;
    }

}