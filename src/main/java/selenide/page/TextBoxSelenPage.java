package selenide.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxSelenPage {

    public SelenideElement inputFullName = $("#userName");
    public SelenideElement inputEmail = $("#userEmail");
    public SelenideElement inputCurrentAddress = $("#currentAddress");
    public SelenideElement inputPermanentAddress = $("#permanentAddress");
    public SelenideElement submitButton = $("#submit");

    public SelenideElement outputBlock = $("#output");
    public SelenideElement outputName = $("#name");
    public SelenideElement outputEmail = $("#email");
    public SelenideElement outputCurrentAddress = $x("//textarea[@id='currentAddress']");
    public SelenideElement outputPermanentAddress = $("#permanentAddress");
}