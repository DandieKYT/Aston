package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AstonPage {

    private SelenideElement closeCookie = $x("//button[contains(text(),'Подтверждаю')]");
    private SelenideElement careerAston = $(withTagAndText("div", "Карьера"));
    private SelenideElement secondCareerAston =  $(withTagAndText("a", "Карьера"));
    private SelenideElement vacations = $x("//a[contains(text(),'Вакансии')]");
    private SelenideElement buttonVacations = $(".tmpl_hh_tab--about .tmpl_hh_header__vacancy-button");
    private SelenideElement checkVacationQA = $x("//span[text()='Тестировщик']");

    public SelenideElement checkVacationQA(){return checkVacationQA;}
    public SelenideElement buttonVacations(){return  buttonVacations;}
    public SelenideElement vacations(){return vacations; }
    public SelenideElement closeCookie(){return closeCookie; }
    public SelenideElement secondCareerAston() {return secondCareerAston; }
    public SelenideElement careerAston() {
        return careerAston;
    }
}
