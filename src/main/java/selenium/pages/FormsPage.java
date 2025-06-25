package selenium.pages;

import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.BasePage;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class FormsPage extends BasePage {

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    // Заголовок группы "Forms" в левом меню (свернуто)
    @FindBy(xpath = "//div[@class='element-group'][2]/span")
    WebElement minFormsMenuHeader;

    // Заголовок группы "Forms" в левом меню (развернуто)
    @FindBy(xpath = "//div[@class='element-group'][2]")
    WebElement maxFormsMenuHeader;

    public WebElement getMinFormsMenuHeader() {
        return minFormsMenuHeader;
    }

    public WebElement getMaxFormsMenuHeader() {
        return maxFormsMenuHeader;
    }

}
