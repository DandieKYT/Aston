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
             careerAston =  $(".MainNav-module--list--X5WUN > li:nth-of-type(6) > div > div"),
             secondCareerAston =  $(withTagAndText("a", "Почему Aston")),
             closeCookie = $x("//button[contains(text(),'Подтверждаю')]"),
             openReact = $(byTagAndText("a","React")),
             chatWindow = $(".hoverl_b094"),
             setValueChat = $x(" //textarea[@placeholder='Введите сообщение']"),
             checkChatResponse = $x("//jdiv[@class='text_b080 __bot_fba3']"),
             buttonPrice = $x("//a[text()='Узнать стоимость']"),
             openTechnologies = $x("//div[text()='Технологии']");

    public MainPage careerAston() {
        step("Наведение мыши на раздел Карьера", () -> {
            careerAston.hover().click();
        });
        return this;
    }
    public MainPage secondCareerAston() {
        step("Открытие вкладки Карьера", () -> {
            secondCareerAston.click();
        });
        return this;
    }
    public MainPage closeCookie() {
        step("Закрытие куки", () -> {
            closeCookie.click();
        });
        return this;
    }
    public MainPage openReact() {
        step("Открытие страницы React", () -> {
            openReact.click();
        });
        return this;
    }
    public MainPage chatWindow() {
        step("Открытие чата", () -> {
            chatWindow.click();
        });
        return this;
    }
    public MainPage setValueChat() {
        step("Отправка сообщения autotest", () -> {
            setValueChat.setValue("autotest").pressEnter();
        });
        return this;
    }
    public MainPage checkChatResponse() {
        step("Проверка ответа чата на сообщение", () -> {
            checkChatResponse.shouldBe(text("Представьтесь в чате"));
        });
        return this;
    }
    public MainPage openTechnologies() {
        step("Открытие раздела Технологии", () -> {
            openTechnologies.hover();
        });
        return this;
    }
    public MainPage openPage() {
        step("Открытие главной страницы", () -> {
            Selenide.open("/");
        });
        return this;
    }
    public MainPage buttonPrice() {
        step("Нажатие на кнопку Узнать стоимость", () -> {
            buttonPrice.click();
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
