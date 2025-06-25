package selenium.steps;

import org.openqa.selenium.WebDriver;
import selenium.driver.CustomWebDriverManager;
import selenium.pages.HomePage;

import static io.qameta.allure.Allure.step;


public class HomeSteps {

    private final WebDriver driver;
    private final HomePage homePage;

    public HomeSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    public void openDemoqaPageStep() {
        step("Открытие главной страницы demoqa",
                () -> driver.get("https://demoqa.com"));
    }

    public void clickElementsCardStep() {
        step("Клик по элементу - Elements\"",
                () -> homePage.getElementsCard().click());
    }

    public void clickFormsCardStep() {
        step("Клик по элементу - Forms\"",
                () -> homePage.getFormsCard().click());
    }

    public void closeBrowserStep() {
        step("Закртие браузера", CustomWebDriverManager::quitDriver);
    }
}
