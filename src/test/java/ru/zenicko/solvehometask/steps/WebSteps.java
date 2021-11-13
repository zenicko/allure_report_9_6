package ru.zenicko.solvehometask.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открыть главную страницу")
    public void openMainPage(){
        open("");
    }
    @Step("Найти репозиторий")
    public void searchRepository(String link){
        $("[name=q]").setValue(link).pressEnter();
    }
    @Step("Открыть репозиторий")
    public void openRepository(String link){
        $(By.linkText(link)).click();
    }
    @Step("Открыть репозиторий {searchingText}")
    public void shouldBeTextOnPage(String searchingText){
        $("body").shouldHave(Condition.text(searchingText));
    }

}
