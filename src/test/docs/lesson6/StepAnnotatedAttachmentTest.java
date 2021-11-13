package docs.lesson6;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.internal.AllureStorage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.zenicko.lesson6.steps.WebSteps;

import static com.codeborne.selenide.Selenide.sleep;

public class StepAnnotatedAttachmentTest {
    private static String REPOSITORY = "eroshenkoam/allure-example";
    private static String numberIssue = "68";
    private WebSteps steps = new WebSteps();

    @BeforeAll
    static void beforeTests() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void testGitHub() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        steps.openMainPage(Configuration.startMaximized);
        steps.searchRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.takeScreenshot();
        steps.shouldBeVisibleIssueWithNumber(numberIssue);
        sleep(4000);
    }

}


