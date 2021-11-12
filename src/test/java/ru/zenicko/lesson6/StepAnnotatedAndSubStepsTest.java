package ru.zenicko.lesson6;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.zenicko.lesson6.steps.WebSteps;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class StepAnnotatedAndSubStepsTest {
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
        step("Открыть главную страницу", ()-> {
            steps.openMainPage(Configuration.startMaximized);
        });
        step("Найти репозиторий {REPOSITORY}", () -> {
            steps.searchRepository(REPOSITORY);
        });
        step("Перейти в репозиторий {REPOSITORY}", ()-> {
            steps.goToRepository(REPOSITORY);
        });

        step("Открыть вкладку Issues", ()-> {
            steps.openIssuesTab();
        });

        step("Проверка наличия Issue с номером {numberIssue}", ()-> {
            steps.shouldBeVisibleIssueWithNumber(numberIssue);
        });

        sleep(4000);
    }
}
