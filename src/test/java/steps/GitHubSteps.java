package steps;

import io.qameta.allure.Step;
import pages.GitHubPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class GitHubSteps {
    GitHubPage gitHubPage = new GitHubPage();
    @Step("Открытие Github")
    public void open(){
        gitHubPage.openPage();
    }
    @Step("Заполнение полей логин и пароль")
    public void authorization(){
        gitHubPage.setSignIn().click();
        gitHubPage.setLoginField().setValue("DandieKYT");
        gitHubPage.setPassword().setValue("Kydrya719").pressEnter();
    }
    @Step("Ввод в поле поиска")
    public void search(String param){
       gitHubPage.getSearch().setValue(param).pressEnter();
    }
    @Step("Проверка результата поиска")
    public void succsessResultJava(String params){
        gitHubPage.searchResult(params).shouldHave(visible.because("Не найден результат поиска"));
    }
    @Step("Подведение курсора к выпадающему меню")
    public void hoverCursor(){
       gitHubPage.getHoverCursor().click();
    }
    @Step("Открытие страницы Enterpise")
    public void openEnterprise(){
        gitHubPage.getOpenEnterprise().click();
    }
    @Step("Проверка текста на странице Enterpise")
    public void getExpectedTextEnterprise(){
        gitHubPage.getExpectedTextEnterprise();
    }
    @Step("Открытие репозиторя AutomationGitHub")
    public  void getOpenRepository() { gitHubPage.getOpenRepository().click();}

    @Step("Открытие раздела Issue")
    public void getOpenIssue(){ gitHubPage.getGetOpenIssue().click();}

    @Step("Проверка текста в разделе Issue")
    public void issueText(){ gitHubPage.getIssueText().shouldBe(text("Label issues and pull requests for new contributors"));}

    @Step("Открытие выпадающего меню")
    public void dropMenu(){gitHubPage.dropMenu().click();}

    @Step("Нажатие кнопки SignOut")
    public void signOut(){gitHubPage.signOut().click();}

    @Step("Переход на страницу Issue по запросу css")
    public void issueCssText(){
        gitHubPage.issueCssText().click();
    }
    @Step("Проверка что старница показывает результат Isssue")
        public void expectedIssueResult(){
        gitHubPage.expectedIssueResult().shouldBe(text("issues"));
        }
}
