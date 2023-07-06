package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

public class CareerPage {

    private SelenideElement
            secondCareerAston = $(withTagAndText("a", "Почему Aston")),
            careerAston = $(".MainNav-module--list--X5WUN > li:nth-of-type(6) > div > div"),
            vacations = $(".TitleWith-module--button--FTFLX");

    public CareerPage vacations() {
        step("Переход на страницу вакансий", () -> {
            vacations.click();
            switchTo().window(1);
        });
        return this;
    }

    public CareerPage secondCareerAston() {
        step("Открытие вкладки Карьера", () -> {
            secondCareerAston.click();
        });
        return this;
    }

    public CareerPage careerAston() {
        step("Наведение мыши на раздел Карьера", () -> {
            careerAston.hover().click();
        });
        return this;
    }
}
