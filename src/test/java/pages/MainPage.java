package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPage {
    private SelenideElement

             closeCookie = $x("//button[contains(text(),'Подтверждаю')]");


    public MainPage closeCookie() {
        step("Закрытие куки", () -> {
            closeCookie.click();
        });
        return this;
    }

    public MainPage openPage() {
        step("Открытие главной страницы", () -> {
            Selenide.open("/");
        });
        return this;
    }

    public SelenideElement openTitle(String expectedText) {
        return $(byTagAndText("a", (expectedText)));
    }

    public SelenideElement searchByParam(String param) {
        return $x(String.format("//div[text()='%s']", param));
    }
}
