package help;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StartTest {
    private SelenideElement

            closeCookie = $x("//button[contains(text(),'Подтверждаю')]");


    public StartTest closeCookie() {
        step("Закрытие куки", () -> {
            closeCookie.click();
        });
        return this;
    }

    public StartTest openPage() {
        step("Открытие главной страницы", () -> {
            Selenide.open("/");
        });
        return this;
    }
}


