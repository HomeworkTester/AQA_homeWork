package selenium.pages;

import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.BasePage;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement inputFirstName;

    @FindBy(id = "lastName")
    WebElement inputLastName;

    @FindBy(id = "userEmail")
    WebElement inputEmail;

    @FindBy(id = "currentAddress")
    private WebElement inputAddress;

    @FindBy(xpath = "//label[text()='Male']")
    WebElement radioMale;

    @FindBy(id = "userNumber")
    WebElement inputMobile;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(xpath = "//div[@id='example-modal-sizes-title-lg']")
    WebElement modalTitle;

    @FindBy(xpath = "//table//td[text()='Student Name']/following-sibling::td")
    WebElement modalStudentName;

    @FindBy(xpath = "//table//td[text()='Student Email']/following-sibling::td")
    WebElement modalEmail;

    @FindBy(xpath = "//td[text()='Mobile']/following-sibling::td")
    WebElement modalMobile;

    @FindBy(xpath = "//td[text()='Gender']/following-sibling::td")
    WebElement modalGender;

    @FindBy(xpath = "//td[text()='Date of Birth']/following-sibling::td")
    WebElement modalDateOfBirth;

    @FindBy(xpath = "//td[text()='Subjects']/following-sibling::td")
    WebElement modalSubjects;

    @FindBy(xpath = "//td[text()='Address']/following-sibling::td")
    WebElement modalAddress;

    @FindBy(id = "closeLargeModal")
    WebElement closeModalButton;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthInput;

    @FindBy(className = "react-datepicker__month-select")
    private WebElement monthSelect;

    @FindBy(className = "react-datepicker__year-select")
    private WebElement yearSelect;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    public WebElement getInputFirstName() {
        return inputFirstName;
    }

    public WebElement getInputLastName() {
        return inputLastName;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getRadioMale() {
        return radioMale;
    }

    public WebElement getInputAddress() {
        return inputAddress;
    }

    public WebElement getInputMobile() {
        return inputMobile;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getModalTitle() {
        return modalTitle;
    }

    public WebElement getModalStudentName() {
        return modalStudentName;
    }

    public WebElement getModalEmail() {
        return modalEmail;
    }

    public WebElement getCloseModalButton() {
        return closeModalButton;
    }

    public WebElement getDateOfBirthInput() {
        return dateOfBirthInput;
    }

    public WebElement getMonthSelect() {
        return monthSelect;
    }

    public WebElement getYearSelect() {
        return yearSelect;
    }

    public WebElement getInputSubjects() {
        return subjectsInput;
    }

    public WebElement getModalMobile() {
        return modalMobile;
    }

    public WebElement getModalGender() {
        return modalGender;
    }

    public WebElement getModalDateOfBirth() {
        return modalDateOfBirth;
    }

    public WebElement getModalSubjects() {
        return modalSubjects;
    }

    public WebElement getModalAddress() {
        return modalAddress;
    }
}
