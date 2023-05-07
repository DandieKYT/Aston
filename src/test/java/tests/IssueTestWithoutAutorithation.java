package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import steps.GitHubSteps;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class IssueTestWithoutAutorithation {
    GitHubSteps gitHubSteps = new GitHubSteps();
    @Test
    public void issueTest(){
        gitHubSteps.open();
        gitHubSteps.search("css");
        gitHubSteps.issueCssText();
        gitHubSteps.expectedIssueResult();
    }
    @Test
    public void sportMast(){
        open("https://bi.zone/");
        $x("//span[contains(text(),'Экспертиза')]").hover();
        $(byTagAndText("a", "Материалы")).click();
        $x("//h1[contains(text(),'Материалы')]").shouldBe(Condition.visible);

    }
}
