package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ReactPage {
    private SelenideElement checkReact = $x("//h1[contains(text(),'React-разработка')]");

    public ReactPage checkReact() {
        step("Проверка страницы React", () -> {
            checkReact.shouldBe(text("React-разработка"));
        });
        return this;
    }
}
