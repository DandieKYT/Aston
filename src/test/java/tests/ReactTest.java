package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

public class ReactTest extends TestBase {
    @Owner("Кудрявцев")
    @Feature("Технология React")
    @Story("Открытие страницы React и проверка ее содержимого")
    @Test
    public void reactJs(){
        startTest.openPage();
        startTest.closeCookie();
        reactPage.openTechnologies();
        reactPage.openReact();
        reactPage.checkReact();
    }
}
