package selenide.steps;

import com.codeborne.selenide.Condition;
import selenide.page.TextBoxSelenPage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TextBoxSelenSteps {

    private final TextBoxSelenPage page = new TextBoxSelenPage();

    public void openTextBoxPage() {
        step("Открыть страницу Text Box", () -> open("/text-box"));
    }

    public void fillForm(String name, String email, String currentAddress, String permanentAddress) {
        step("Заполнение полей формы", () -> {
            page.inputFullName.shouldBe(Condition.visible).setValue(name);
            page.inputEmail.shouldBe(Condition.visible).setValue(email);
            page.inputCurrentAddress.shouldBe(Condition.visible).setValue(currentAddress);
            page.inputPermanentAddress.shouldBe(Condition.visible).setValue(permanentAddress);
        });

        step("Проверка - все поля заполнены", () -> {
            page.inputFullName.shouldHave(Condition.value(name));
            page.inputEmail.shouldHave(Condition.value(email));
            page.inputCurrentAddress.shouldHave(Condition.value(currentAddress));
            page.inputPermanentAddress.shouldHave(Condition.value(permanentAddress));
        });
    }

    public void submitForm() {
        step("Клик по кнопке Submit", () -> {
            page.submitButton.shouldBe(Condition.enabled)
                    .scrollIntoView(true)
                    .click();
        });
    }

    public void verifyFormSubmission(String name, String email, String currentAddress, String permanentAddress) {
        step("Форма вывода отображается на странице", () -> page.outputBlock.shouldBe(Condition.visible));
        step("Данные в форме вывода валидны", () -> {
            page.outputName.shouldHave(Condition.text(name));
            page.outputEmail.shouldHave(Condition.text(email));
            page.outputCurrentAddress.shouldHave(Condition.value(currentAddress));
            page.outputPermanentAddress.shouldHave(Condition.value(permanentAddress));
        });
    }
}
