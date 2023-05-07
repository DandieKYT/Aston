package tests;

import org.junit.jupiter.api.Test;
import steps.GitHubSteps;

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
        open("https://www.google.com/?hl=ru");
        $("#APjFqb").setValue("Спортмастер").pressEnter();
        $x("//h3[contains(text(),'Спортмастер — спортивный магазин для всей семьи!')]").click();
        sleep(5000);
    }
}
