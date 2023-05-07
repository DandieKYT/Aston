package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.selector.ByTagAndText;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import steps.GitHubSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class IssueTest {
    GitHubSteps gitHubSteps = new GitHubSteps();

    @Test
    @DisplayName("Проверка страницы Issue")
    public void issueTest() {
        gitHubSteps.open();
        gitHubSteps.authorization();
        gitHubSteps.getOpenRepository();
        gitHubSteps.getOpenIssue();
        gitHubSteps.issueText();
        gitHubSteps.dropMenu();
        gitHubSteps.signOut();

    }

    @Test
    @DisplayName("Проверка страницы Issue")
    public void anotherTestIssue() {
        step("Открываем главную страницу", () -> {
            gitHubSteps.open();
        });
        step("Авторизация на GitHub", () -> {
            gitHubSteps.authorization();
        });
        step("Открываем раздел Issue", () -> {
            gitHubSteps.getOpenRepository();
            gitHubSteps.getOpenIssue();
        });
        step("Проверяем текст на соответсвие странице", () -> {
            gitHubSteps.issueText();
        });
        step("Выход со страницы", () -> {
            gitHubSteps.dropMenu();
            gitHubSteps.signOut();
        });
    }

    @Test
    @DisplayName("Тест Issue с Listener")
    public void testIssueListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");

        $(byTagAndText("a", "Sign in")).click();
        $("#login_field").setValue("DandieKYT");
        $("#password").setValue("Kydrya719").pressEnter();

        $x("//aside[@aria-label='Account']//li[1]//div[1]//div[1]//a[1]").click();
        $x("//a[@id='issues-tab']").click();

        $(".mb-1.h4").shouldBe(text("Label issues and pull requests for new contributors"));

        $x("//summary[@aria-label='View profile and more']//span[@class='dropdown-caret']").click();
        $("button[role='menuitem'][type='submit']").click();

    }
}


