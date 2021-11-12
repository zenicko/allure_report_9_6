package ru.zenicko.lesson6.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Open page {value}")
    public void openMainPage(Object value){
        open("");
    }

    @Step("Find the repository {REPOSITORY}")
    public void searchRepository(final String REPOSITORY){
        $("[name=q]").setValue(REPOSITORY).pressEnter();
    }

    @Step("Go to repository {REPOSITORY}")
    public void goToRepository (final String REPOSITORY){
        //$("[href='/eroshenkoam/allure-example']").click();
        $(By.linkText(REPOSITORY)).click();
    }

    @Step("Open tab Issues")
    public void openIssuesTab(){
        $(By.partialLinkText("Issues")).click();
    }

    @Step("Check issue {numberIssue}")
    public void shouldBeVisibleIssueWithNumber(String numberIssue){
        $(Selectors.withText("#" + numberIssue)).shouldBe(Condition.visible);
    }

    @Attachment(value = "screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
