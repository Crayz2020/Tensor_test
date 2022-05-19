package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static tests.TestData.*;

public class TensorPage {
    // Locators
    SelenideElement
            headerTitle = $(".tensor_ru-Index__Banner-title"),
            aboutTitle = $(".tensor_ru-About__block-title-block"),
            cityField = $(".controls-Field"),
            branchesAddress = $(".tensor_ru-Branches-list__item-address"),
            moreMenuInformation = $(".tensor_ru-Header__button-area"),
            submitApplication = $(".tensor_ru-CTO__Banner-btn"),
            setUserName = $(".ofd-dialog_request-person").$(".controls-TextBox__field"),
            setUserNumber = $(".ofd-dialog_request-contacts").$(".controls-FormattedTextBox__field"),
            privacyAgree = $(".ofd-dialog_request-checkbox-caption"),
            textBoxSubmit = $(".controls-Button__text"),
            errorType = $(".ws-infobox-type-error");

    //actions
    //tensorMainHeaderTest
    @Step ("Проверяем отображение главной страницы")
    public TensorPage checkMainHeader(String headerText) {
        headerTitle.shouldHave(text(headerText));

        return this;
    }



    //tensorAboutTest
    @Step ("Открывем страницу 'О компании'")
    public TensorPage aboutPage() {
        $(byText(about)).click();

        return this;
    }
    @Step ("Проверяем верное отображение страницы")
    public TensorPage checkAboutText(String aboutText) {
        aboutTitle.shouldHave(text(aboutText));

        return this;
    }



    //TensorBranchesTest
    @Step("Открывем страницу филиалов")
    public TensorPage branchesPage() {
        $(byText(branches)).click();

        return this;
    }
    @Step("Вводим интересующий нас город")
    public TensorPage setBranchCity(String city) {
        cityField.setValue(city).pressEnter();

        return this;
    }
    @Step("Проверяем верное отображение адреса")
    public TensorPage checkAddress(String street) {
        branchesAddress.shouldHave(text(street));

        return this;
    }



    //TensorServiceTest
    @Step("Открывем страницу сервисного центра")
    public TensorPage serviceCenterPage() {
        moreMenuInformation.click();
        sleep(5000);
        $(byText(serviceCenter)).click();

        return this;

    }
    @Step("Открываем форму для отправки заявки")
    public TensorPage application() {
        submitApplication.click();
        sleep(20000);

        return this;

    }
    @Step("Вводим имя")
    public TensorPage setName(String name) {
        setUserName.setValue(name);

        return this;
    }
    @Step("Вводим номер телефона")
    public TensorPage setNumber(String userNumber) {
        setUserNumber.click();
        setUserNumber.sendKeys(userNumber);

        return this;
    }
    @Step("Подтверждаем условия и отправляем заявку")
    public TensorPage confirmData() {
        privacyAgree.click();
        textBoxSubmit.click();

        return this;
    }
    @Step("Проверяем верное отображение ошибки")
    public TensorPage checkError() {
        errorType.shouldBe(visible);

        return this;
    }
}
