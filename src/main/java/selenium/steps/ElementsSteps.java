package selenium.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.enums.ElementsTab;
import selenium.pages.ElementsPage;

import java.time.Duration;

import static io.qameta.allure.Allure.step;

public class ElementsSteps {

    private final WebDriverWait wait;
    private final ElementsPage elementsPage;

    public ElementsSteps(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.elementsPage = new ElementsPage(driver);
    }

    public void expandElementsMenuIfCollapsedStep() {
        step("Раскрытие секции Elements в меню навигации",
                () -> {
                    boolean isExpanded;

                    try {
                        elementsPage.getMaxElementsMenuHeader().findElement(By.xpath(".//div[contains(@class, 'collapse show')]"));
                        isExpanded = true;
                    } catch (NoSuchElementException e) {
                        isExpanded = false;
                    }

                    if (!isExpanded) {
                        wait.until(ExpectedConditions.elementToBeClickable(elementsPage.getMinElementsMenuHeader())).click();
                    }
                });
    }

    public void openTabElements(ElementsTab tab) {
        step("Клик по элементу - " + tab, () -> {
            expandElementsMenuIfCollapsedStep();
            By tabLocator = By.xpath("//span[text()='" + tab.getTabName() + "']");
            WebElement tabElement = wait.until(ExpectedConditions.elementToBeClickable(tabLocator));
            tabElement.click();
        });
    }
}
