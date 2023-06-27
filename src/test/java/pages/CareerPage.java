package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

public class CareerPage {
    private SelenideElement vacations = $(".TitleWith-module--button--FTFLX");

    public CareerPage vacations() {
        step("Переход на страницу вакансий", () -> {
            vacations.click();
            switchTo().window(1);
        });
        return this;
    }
}
