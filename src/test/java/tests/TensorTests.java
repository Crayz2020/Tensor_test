package tests;


import org.junit.jupiter.api.Test;

import static tests.TestData.*;



public class TensorTests extends TestBase {


    @Test
    void tensorMainHeaderTest() {
        tensorPage.checkMainHeader(headerText);

    }

    @Test
    void tensorAboutTest() {
        tensorPage
                .aboutPage()
                .checkAboutText(aboutText);
    }

    @Test
    void tensorBranchesTest() {
        tensorPage
                .branchesPage()
                .setBranchCity(city)
                .checkAddress(street);

    }

    @Test
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

