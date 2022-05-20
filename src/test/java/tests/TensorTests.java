package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static tests.TestData.*;



public class TensorTests extends TestBase {


    @Test
    @DisplayName("Проверка главной страницы")
    void tensorMainHeaderTest() {
        tensorPage.checkMainHeader(headerText);

    }

    @Test
    @DisplayName("Проверка страницы 'О компании'")
    void tensorAboutTest() {
        tensorPage
                .aboutPage()
                .checkAboutText(aboutText);
    }

    @Test
    @DisplayName("Проверка верного отображения филиалов")
    void tensorBranchesTest() {
        tensorPage
                .branchesPage()
                .setBranchCity(city)
                .checkAddress(street);

    }

    @Test
    @DisplayName("Проверка ошибки заполнения формы")
    void tensorServiceCenterTest() {
        tensorPage
                .serviceCenterPage()
                .application()
                .setName(name)
                .setNumber(userNumber)
                .confirmData()
                .checkError();

    }


}

