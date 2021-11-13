package ru.zenicko.solvehometask;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.zenicko.solvehometask.steps.WebSteps;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class IssueInRepoTest {
    //Написать тест на проверку названия Issue в репозитории через Web-интерфейс.
    private final String link = "eroshenkoam/allure-example";
    private final String searchingText = "Issues";

    @BeforeAll

    static void setParametersTest() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    @DisplayName("1. Чистый Selenide (с Listener)")
    @Feature("Repository")
    @Story("Issues")
    void testIssueCleanSelenide() {
        // switch up a listener
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("");
        $("[name=q]").setValue(link).pressEnter();
        $(By.linkText(link)).click();
        $("body").shouldHave(Condition.text(searchingText));

        sleep(4000);
    }

    @Test
    @DisplayName("2. Лямбда шаги через step (name, () -> {})")
    @Feature("Repository")
    @Story("Issues")
    void testLambdaSteps() {
        step("Открыть главную страницу", () -> {
            open("");
        });

        step("Найти репозиторий", () -> {
            $("[name=q]").setValue(link).pressEnter();
        });

        step("Открыть репозиторий", () -> {
            $(By.linkText(link)).click();
        });
        step("Проверить наличие " + searchingText, () -> {
            $("body").shouldHave(Condition.text(searchingText));
        });
    }

    @Test
    @DisplayName("3. Шаги с аннотацией @Step")
    @Feature("Repository")
    @Story("Issues")
    void testAnnotationStep() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchRepository(link);
        steps.openRepository(link);
        steps.shouldBeTextOnPage(searchingText);
    }
}
