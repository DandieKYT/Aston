package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

public class ChatTest extends TestBase {
    @Owner("Кудрявцев")
    @Feature("Чат")
    @Story("Проверка ответа бота на запрос")
    @Test
    public void contactWithUs(){
        startTest.openPage();
        chatPage.chatWindow();
        chatPage.setValueChat();
        chatPage.checkChatResponse();
    }
}