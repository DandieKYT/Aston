package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class ChatTest extends TestBase {
    @Tag("AstonTests")
    @Tag("ChatTest")
    @Owner("Кудрявцев")
    @Feature("Чат")
    @Story("Проверка ответа бота на запрос")
    @Test
    public void contactWithUs() {
        startTest.openPage();
        startTest.closeCookie();
        chatPage.chatWindow();
        chatPage.setValueChat();
        chatPage.checkChatResponse();
    }
}
