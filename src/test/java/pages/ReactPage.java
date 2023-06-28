package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ReactPage {
    private SelenideElement
            openTechnologies = $x("//div[text()='Технологии']"),
            openReact = $(byTagAndText("a","React")),
            checkReact = $x("//h1[contains(text(),'React-разработка')]");


    public ReactPage checkReact() {
        step("Проверка страницы React", () -> {
            checkReact.shouldBe(text("React-разработка"));
        });
        return this;
    }
    public ReactPage openTechnologies() {
        step("Открытие раздела Технологии", () -> {
            openTechnologies.hover();
        });
        return this;
    }
    public ReactPage openReact() {
        step("Открытие страницы React", () -> {
            openReact.click();
        });
        return this;
    }
}
