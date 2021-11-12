package ru.zenicko.lesson6;

import com.codeborne.selenide.*;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.OutputType.BYTES;

public class StepLambdaWithAttachmentTest {
    private static String REPOSITORY = "eroshenkoam/allure-example";
    private static String numberIssue = "68";

    @BeforeAll
    static void beforeTests() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void testWithAttachment() {
        AllureLifecycle lifeCycle = Allure.getLifecycle();

        step("Open page " + Configuration.baseUrl, () -> {
            open("");

        });
        step("Find the repository" + REPOSITORY, () -> {
            $("[name=q]").setValue(REPOSITORY).pressEnter();
            lifeCycle.addAttachment("screenshot",
                    "image/png",
                    "png",
                    takeScreenShot());
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

    private static byte[] takeScreenShot(){
        WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }
}

