package selenium.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.enums.FormsTab;
import selenium.pages.FormsPage;

import java.time.Duration;

import static io.qameta.allure.Allure.step;

public class FormsSteps {

    private final WebDriverWait wait;
    private final FormsPage formsPage;

    public FormsSteps(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.formsPage = new FormsPage(driver);
    }

    public void expandFormsMenuIfCollapsedStep() {
        step("Проверка и раскрытие секции 'Forms', если она свернута", () -> {
            boolean isExpanded;
            try {
                formsPage.getMaxFormsMenuHeader()
                        .findElement(By.xpath(".//div[contains(@class, 'collapse show')]"));
                isExpanded = true;
            } catch (NoSuchElementException e) {
                isExpanded = false;
            }

            if (!isExpanded) {
                wait.until(ExpectedConditions.elementToBeClickable(formsPage.getMinFormsMenuHeader())).click();
            }
        });
    }

    public void openTabForms(FormsTab tab) {
        step("Клик по элементу -" + tab, () -> {
            expandFormsMenuIfCollapsedStep();
            By tabLocator = By.xpath("//span[text()='" + tab.getTabName() + "']");
            WebElement tabForms = wait.until(ExpectedConditions.elementToBeClickable(tabLocator));
            tabForms.click();
        });
    }

}
