package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TensorTests {

    @Test
    void tensorMainHeaderTest() {
        open("https://tensor.ru/");
        $(".tensor_ru-Index__Banner-title").shouldHave(text("Разработка"));

    }

    @Test
    void tensorAboutTest() {
        open("https://tensor.ru/");
        $(byText("О компании")).click();
        $(".tensor_ru-About__block-title-block").shouldHave(text("Работаем"));

    }

    @Test
    void tensorBranchesTest() {
        open("https://tensor.ru/");
        $(byText("Филиалы")).click();
        $(".controls-Field").setValue("Уфа").pressEnter();
        $(".tensor_ru-Branches-list__item-address").shouldHave(text("Октябрьской Революции"));

    }

    @Test
    void tensorSeviceCenterTest() {
        open("https://tensor.ru/");
        $(".tensor_ru-Header__button-area").click();
        $(byText("Сервисный центр")).click();

    }


}