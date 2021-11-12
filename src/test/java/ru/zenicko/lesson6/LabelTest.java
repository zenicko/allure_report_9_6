package ru.zenicko.lesson6;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelTest {

    @Test
    @DisplayName("My precious1")
    @Owner("Karl Marx")
    @Feature("Revolution")
    @Story("Authorisation by email")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name="Rivendale", url="https://github.com")
    void testLabelByAnnotated(){


    }

    @Test
    void testLabelByLambdaAndClassic(){
        Allure.getLifecycle().updateTestCase(testCase -> {
            testCase.setName("My precious2");
        });
        Allure.label("owner", "Karl Marx");
        Allure.story("Authorisation by email");
        Allure.feature("Revolution");

        Allure.label("severity", "BLOCKER");
        Allure.link("Rivendale", "https://github.com");
    }
}
