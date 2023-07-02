package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ChatPage {
    private SelenideElement
            chatWindow = $(".hoverl_b094"),
            setValueChat = $x(" //textarea[@placeholder='Введите сообщение']"),
            checkChatResponse = $x("//jdiv[@class='text_b080 __bot_fba3']");

    public ChatPage chatWindow() {
        step("Открытие чата", () -> {
            chatWindow.click();
        });
        return this;
    }
    public ChatPage setValueChat() {
        step("Отправка сообщения autotest", () -> {
            setValueChat.setValue("autotest").pressEnter();
        });
        return this;
    }
    public ChatPage checkChatResponse() {
        step("Проверка ответа чата на сообщение", () -> {
            checkChatResponse.shouldBe(text("Представьтесь в чате"));
        });
        return this;
    }
}
