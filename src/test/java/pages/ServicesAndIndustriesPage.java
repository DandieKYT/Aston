package pages;

import com.codeborne.selenide.SelenideElement;
import help.StartTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ServicesAndIndustriesPage {

ParametrsLoacators locator = new ParametrsLoacators();

private SelenideElement checkTitle = $(".TitleWith-module--title--bojgT");
    public ServicesAndIndustriesPage openTitle(String expectedText) {
        step("Открытие вкладки", () -> {
            locator.openTitle(expectedText).click();
        });
        return this;
    }
    public ServicesAndIndustriesPage checkTitle(String expectedText) {
        step("Проверка страницы по ожидаемому тексту", () -> {
            checkTitle.shouldBe(text(expectedText));
        });
        return this;
    }
    public StartTest searchByParam(String param) {
        step("Открытие верхнего меню", () -> {
            locator.searchByParam(param).hover();
        });
        return null;
    }
    public class ParametrsLoacators{
        public SelenideElement openTitle(String expectedText) {
            return $(byTagAndText("a", (expectedText)));
        }

        public SelenideElement searchByParam(String param) {
            return $x(String.format("//div[text()='%s']", param));
        }
    }
}
