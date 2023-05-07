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
        gitHubSteps.search("css");
        gitHubSteps.issueCssText();
        gitHubSteps.expectedIssueResult();

    }

    @Test
    @DisplayName("Проверка страницы Issue")
    public void anotherTestIssue() {
        step("Открываем главную страницу", () -> {
            gitHubSteps.open();
        });
        step("В поле поиска пишем css", () -> {
            gitHubSteps.search("css");
        });
        step("Открываем раздел Issue", () -> {
            gitHubSteps.issueCssText();
        });
        step("Проверяем текст на соответсвие странице", () -> {
            gitHubSteps.expectedIssueResult();
        });
    }

    @Test
    @DisplayName("Тест Issue с Listener")
    public void testIssueListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $("[aria-label=\"Search GitHub\"]").setValue("css").pressEnter();
        $x("(//a[@class='menu-item'])[3]").click();
        $(withTagAndText("h3","issues")).shouldBe(text("issues"));

    }
}


