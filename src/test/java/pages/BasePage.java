package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import tests.TestBase;


import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class BasePage {
    public SelenideElement closeCookie = $x("//button[contains(text(),'Подтверждаю')]");
    public  BasePage closeCookie() {
    step("Закрытие куки", () -> {
        closeCookie.click();
    });
            return this;
}
    public  BasePage openPage() {
        step("Открытие главной страницы", () -> {
            Selenide.open("/");
        });
        return this;
    }
}
