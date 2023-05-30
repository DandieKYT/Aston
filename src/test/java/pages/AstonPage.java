package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AstonPage {
    private SelenideElement checkTitle = $(".TitleWith-module--title--bojgT");
    private SelenideElement closeCookie = $x("//button[contains(text(),'Подтверждаю')]");
    private SelenideElement careerAston = $(withTagAndText("div", "Карьера"));
    private SelenideElement secondCareerAston =  $(withTagAndText("a", "Карьера"));
    private SelenideElement vacations = $x("//a[contains(text(),'Вакансии')]");
    private SelenideElement buttonVacations = $(".tmpl_hh_tab--about .tmpl_hh_header__vacancy-button");
    private SelenideElement checkVacationQA = $x("//span[text()='Тестировщик']");
    private SelenideElement openTechnologies = $x("//div[text()='Технологии']");
    private SelenideElement openReact = $(byTagAndText("a","React"));

    private SelenideElement checkReact = $x("//h1[contains(text(),'React-разработка')]");
    private SelenideElement chatWindow = $x("//jdiv[@class='hoverl_a548']");
    private SelenideElement setValueChat = $x(" //textarea[@placeholder='Введите сообщение']");
    private SelenideElement checkChatResponse = $(".text_dd60");
    private SelenideElement buttonPrice = $x("//a[text()='Узнать стоимость']");
    private SelenideElement checkBoxDesktop = $(byTagAndText("div", "Desktop"));
    private SelenideElement lowerButtonPrice = $x("//button[@class='Button-module--button--CU-kq Button-module--sizeSM--eCtqi PreviewModal-module--button--JmKgy']");
    private SelenideElement checkDesktopParam = $(byTagAndText("div", "Desktop"));


    public SelenideElement checkDesktopParam(){return checkDesktopParam;}
    public SelenideElement lowerButtonPrice(){return lowerButtonPrice;}
    public SelenideElement checkBoxDesktop(){return checkBoxDesktop;}
    public SelenideElement buttonPrice(){return buttonPrice;}
    public SelenideElement checkChatResponse(){return checkChatResponse;}
    public SelenideElement setValueChat(){return setValueChat;}
    public SelenideElement chatWindow(){return chatWindow;}
    public SelenideElement checkReact(){return checkReact;}
    public SelenideElement openReact(){return openReact;}
    public SelenideElement openTechnologies(){return openTechnologies; }
    public SelenideElement checkTitle(){return checkTitle;}
    public SelenideElement openTitle(String expectedText){
        return $(byTagAndText("a", (expectedText)));
    }
    public SelenideElement searchByParam(String param){
        return $x(String.format("//div[text()='%s']", param));
    }
    public SelenideElement checkVacationQA(){return checkVacationQA;}
    public SelenideElement buttonVacations(){return  buttonVacations;}
    public SelenideElement vacations(){return vacations; }
    public SelenideElement closeCookie(){return closeCookie; }
    public SelenideElement secondCareerAston() {return secondCareerAston; }
    public SelenideElement careerAston() {
        return careerAston;
    }
}
