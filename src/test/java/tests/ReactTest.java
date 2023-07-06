package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ReactTest extends TestBase {
    @Tag("AstonTests")
    @Tag("ReactTest")
    @Owner("Кудрявцев")
    @Feature("Технология React")
    @Story("Открытие страницы React и проверка ее содержимого")
    @Test
    public void reactJs() {
        basePage.openPage();
        basePage.closeCookie();
        reactPage.openTechnologies();
        reactPage.openReact();
        reactPage.checkReact();
    }
}
