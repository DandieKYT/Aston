package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class ServicesAndIndustriesPage {
MainPage mainPage = new MainPage();

private SelenideElement checkTitle = $(".TitleWith-module--title--bojgT");
    public ServicesAndIndustriesPage openTitle(String expectedText) {
        step("Открытие вкладки", () -> {
            mainPage.openTitle(expectedText).click();
        });
        return this;
    }
    public ServicesAndIndustriesPage checkTitle(String expectedText) {
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
