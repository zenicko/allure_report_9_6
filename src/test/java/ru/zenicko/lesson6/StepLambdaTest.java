package ru.zenicko.lesson6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepLambdaTest {
    private static String REPOSITORY = "eroshenkoam/allure-example";
    private static String numberIssue = "68";

    @BeforeAll
    static void beforeTests() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void testGitHub() {
        step("Open page " + Configuration.baseUrl, () -> {
            open("");

        });
        step("Find the repository" + REPOSITORY, () -> {
            $("[name=q]").setValue(REPOSITORY).pressEnter();
        });

        step("Go to repository " + REPOSITORY, () -> {
            //$("[href='/eroshenkoam/allure-example']").click();
            $(By.linkText(REPOSITORY)).click();
        });

        step("Open tab" + "Issues", () -> {
            $(By.partialLinkText("Issues")).click();
        });

        step("Check issue " + numberIssue, () -> {
            $(Selectors.withText("#" + numberIssue)).shouldBe(Condition.visible);
        });

        sleep(4000);
    }
}
