package selenium.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pages.PracticeFormPage;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeFormSteps {

    private final PracticeFormPage formPage;
    private final WebDriverWait wait;
    private final WebDriver driver;

    public PracticeFormSteps(WebDriver driver) {
        this.formPage = new PracticeFormPage(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void practiceFillForm(String firstName, String lastName, String email, String mobile, String address) {
        step("Ввод имени", () -> formPage.getInputFirstName().sendKeys(firstName));
        step("Ввод фамилии", () -> formPage.getInputLastName().sendKeys(lastName));
        step("Ввод email", () -> formPage.getInputEmail().sendKeys(email));
        step("Ввод Mobile", () -> formPage.getInputMobile().sendKeys(mobile));
        step("Ввод адреса", () -> formPage.getInputAddress().sendKeys(address));
        step("Клик по радиокнопке Male", () -> formPage.getRadioMale().click());
    }


    // Очень плохая реализация, понимаю. Боролся с баннерами и раскрывающимися списками.
    public void selectDateOfBirth(String month, String year, String day) {
        removeAds();
        step("Открытие календаря", () -> formPage.getDateOfBirthInput().click());

        step("Выбор месяца", () -> {
            formPage.getMonthSelect().click();
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//option[text()='" + month + "']")
            )).click();
        });

        step("Выбор года", () -> {
            formPage.getYearSelect().click();
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//option[text()='" + year + "']")
            )).click();
        });

        step("Выбор дня", () -> {
            String xpath = String.format("//div[contains(@class, 'react-datepicker__day') and not(contains(@class, 'outside-month')) and text()='%s']", day);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
        });

        step("Закрытия календаря", () -> formPage.getDateOfBirthInput().sendKeys(Keys.ESCAPE));
    }

    // Без 2 wait ловлю ошибку is not clickable. Не понимаю почему
    public void setSubject(String subject) {
        formPage.getInputSubjects().click();
        formPage.getInputSubjects().sendKeys(subject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".subjects-auto-complete__menu-list div")
        ));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".subjects-auto-complete__menu-list div")
        ));
        formPage.getInputSubjects().sendKeys(Keys.ENTER);
    }

    public void submitForm() {
        step("Скролл к кнопке и клик по Submit", () -> {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", formPage.getSubmitButton());
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(formPage.getSubmitButton())).click();
        });
    }

    public void verifyModal(String expectedFirstName, String expectedLastName, String expectedEmail,
                            String expectedMobile, String expectedAddress, String expectedSubject,
                            String expectedMonth, String expectedYear, String expectedDay) {
        step("Открыто модальное окно Thanks for submitting the form",
                () -> wait.until(ExpectedConditions.visibilityOf(formPage.getModalTitle())));
        step("Поле Student Name валидно", () -> assertEquals(expectedFirstName + " " + expectedLastName, formPage.getModalStudentName().getText()));
        step("Поле Student Email валидно", () -> assertEquals(expectedEmail, formPage.getModalEmail().getText()));
        step("Поле Gender валидно", () -> assertEquals("Male", formPage.getModalGender().getText()));
        step("Поле Mobile валидно", () -> assertEquals(expectedMobile, formPage.getModalMobile().getText()));
        step("Поле Date of Birth валидно", () -> assertEquals(expectedDay + " " + expectedMonth + "," + expectedYear, formPage.getModalDateOfBirth().getText()));
        step("Поле Subjects валидно", () -> assertEquals(expectedSubject, formPage.getModalSubjects().getText()));
        step("Поле Address валидно", () -> assertEquals(expectedAddress, formPage.getModalAddress().getText()));
    }

    public void closeModal() {
        step("Закрытие модального окна Thanks for submitting the form",
                () -> formPage.getCloseModalButton().click());
    }

    public void verifyFormIsCleared() {
        step("Поле First Name сброшено",
                () -> assertEquals("", formPage.getInputFirstName().getAttribute("value")));
        step("Поле Last Name сброшено",
                () -> assertEquals("", formPage.getInputLastName().getAttribute("value")));
        step("Поле Email сброшено",
                () -> assertEquals("", formPage.getInputEmail().getAttribute("value")));
        step("Поле First Name сброшено",
                () -> assertEquals("", formPage.getInputMobile().getAttribute("value")));
        assertTrue(formPage.getSubmitButton().isEnabled());
    }

    public void removeAds() {
        ((JavascriptExecutor) driver).executeScript(
                "const ads = document.querySelectorAll('iframe, .ads, #adplus-anchor');" +
                        "ads.forEach(ad => ad.remove());");
    }
}
