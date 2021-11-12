package ru.zenicko.lesson6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    @BeforeAll
    static void beforeTests(){
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void testGitHub(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("");
        $("[name=q]").setValue("eroshenkoam/allure-example").pressEnter();

        $("[href='/eroshenkoam/allure-example']").click();
        //$(By.linkText("/eroshenkoam/allure-example")).click();

        $(By.partialLinkText("Issues")).click();

        $(Selectors.withText("#681")).shouldBe(Condition.visible);

        sleep(4000);
    }
}
