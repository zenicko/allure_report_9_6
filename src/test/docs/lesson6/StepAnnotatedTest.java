package docs.lesson6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.zenicko.lesson6.steps.WebSteps;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepAnnotatedTest {
    private static String REPOSITORY = "eroshenkoam/allure-example";
    private static String numberIssue = "68";
    WebSteps steps = new WebSteps();

    @BeforeAll
    static void beforeTests() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void testGitHub() {
        steps.openMainPage(Configuration.startMaximized);
        steps.searchRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldBeVisibleIssueWithNumber(numberIssue);
        sleep(4000);
    }
}
