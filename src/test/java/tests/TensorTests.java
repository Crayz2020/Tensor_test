package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TensorTests {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());

    }
    @BeforeEach
    public void beforeEach() {
        open("https://tensor.ru/");
    }



    @Test
    void tensorMainHeaderTest() {
        headerTitle.shouldHave(text(headerText));

    }

    @Test
    void tensorAboutTest() {
        $(byText(about)).click();
        aboutTitle.shouldHave(text(aboutText));

    }

    @Test
    void tensorBranchesTest() {
        $(byText(branches)).click();
        cityField.setValue(city).pressEnter();
        branchesAddress.shouldHave(text(street));

    }

    @Test
    void tensorSeviceCenterTest() {
        moreMenuInformation.click();
        sleep(5000);
        $(byText(serviceCenter)).click();
        submitApplication.click();
        sleep(20000);
        setName.setValue(name);
        setUserNumber.click();
        setUserNumber.sendKeys(userNumber);
        privacyAgree.click();
        textBoxSubmit.click();
        errorType.shouldBe(visible);

    }
// Locators
SelenideElement
        headerTitle = $(".tensor_ru-Index__Banner-title"),
        aboutTitle = $(".tensor_ru-About__block-title-block"),
        cityField = $(".controls-Field"),
        branchesAddress = $(".tensor_ru-Branches-list__item-address"),
        moreMenuInformation = $(".tensor_ru-Header__button-area"),
        submitApplication = $(".tensor_ru-CTO__Banner-btn"),
        setName = $(".ofd-dialog_request-person").$(".controls-TextBox__field"),
        setUserNumber = $(".ofd-dialog_request-contacts").$(".controls-FormattedTextBox__field"),
        privacyAgree = $(".ofd-dialog_request-checkbox-caption"),
        textBoxSubmit = $(".controls-Button__text"),
        errorType = $(".ws-infobox-type-error");

    //Data
String
    headerText = "Разработка",
    about = "О компании",
    aboutText = "Работаем",
    branches = "Филиалы",
    city = "Уфа",
    street = "Октябрьской Революции",
    serviceCenter = "Сервисный центр и ЦТО",
    name = "Андрей",
    userNumber = "1234567890";
}

