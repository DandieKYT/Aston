package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class GitHubPage {
    public GitHubPage openPage(){
        open("https://github.com/");
        return this;
    }
    private SelenideElement signIn = $(byTagAndText("a","Sign in"));
    private SelenideElement loginField = $("#login_field");
    private SelenideElement password = $("#password");
    private SelenideElement search = $("[aria-label=\"Search GitHub\"]");
    private SelenideElement hoverCursor = $(byTagAndText("button", "Solutions"));

    private SelenideElement openEnterprise = $x("//div[@class='HeaderMenu-dropdown dropdown-menu rounded m-0 p-0 py-2 py-lg-4 position-relative position-lg-absolute left-0 left-lg-n3 px-lg-4']//a[contains(text(),'Enterprise')]");

    private SelenideElement expectedTextEnterprise = $x("(//h1[@class='h1-mktg mb-3 color-fg-default'])[1]");

    private  SelenideElement getOpenRepository = $x("//aside[@aria-label='Account']//li[1]//div[1]//div[1]//a[1]");

    private  SelenideElement getOpenIssue = $x("//a[@id='issues-tab']");

    private  SelenideElement issueText = $(".mb-1.h4");

    private  SelenideElement dropMenu = $x("//summary[@aria-label='View profile and more']//span[@class='dropdown-caret']");

    private  SelenideElement signOut = $("button[role='menuitem'][type='submit']");

    private  SelenideElement issueCssText = $x("(//a[@class='menu-item'])[3]");

    private SelenideElement expectedIssueResult =$(withTagAndText("h3","issues"));

    public SelenideElement expectedIssueResult(){
        return expectedIssueResult;
    }

    public  SelenideElement issueCssText(){
        return issueCssText;
    }

    public SelenideElement signOut(){
        return signOut;
    }
    public SelenideElement dropMenu() {
        return dropMenu;
    }

    public SelenideElement getIssueText() {
        return issueText;
    }

    public SelenideElement getGetOpenIssue(){
        return getOpenIssue;
    }

    public SelenideElement getOpenRepository(){
        return getOpenRepository;
    }

    public GitHubPage getExpectedTextEnterprise(){
         expectedTextEnterprise.shouldHave(text("Build like the best"));
        return this;
    }

    public SelenideElement searchResult(String params)  {
        return $x(String.format("//h3[normalize-space()='%s']", params));}
    public SelenideElement setSignIn(){
        return signIn;
    }
    public SelenideElement setLoginField(){
        return loginField;
    }
    public SelenideElement setPassword(){
        return password;
    }
    public SelenideElement getSearch(){
        return search;
    }
    public SelenideElement getHoverCursor(){
        return hoverCursor;
    }
    public SelenideElement getOpenEnterprise() {
        return openEnterprise;
    }
}
