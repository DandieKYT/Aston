package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ParamPage {
MainPage mainPage = new MainPage();

private SelenideElement checkTitle = $(".TitleWith-module--title--bojgT");
    public ParamPage openTitle(String expectedText) {
        step("Открытие вкладки", () -> {
            mainPage.openTitle(expectedText).click();
        });
        return this;
    }
    public ParamPage checkTitle(String expectedText) {
        step("Проверка страницы по ожидаемому тексту", () -> {
            checkTitle.shouldBe(text(expectedText));
        });
        return this;
    }
    public MainPage searchByParam(String param) {
        step("Открытие верхнего меню", () -> {
            mainPage.searchByParam(param).hover();
        });
        return null;
    }
}
