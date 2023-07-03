package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ProjectPriceTest extends TestBase {
    @Tag("AstonTests")
    @Tag("ProjectPriceTest")
    @Owner("Кудрявцев")
    @Feature("Открытие страницы Узнать стоимость")
    @Story("Открытие страницы с конфигурацией для проекта и проверка ее соответствия")
    @Test
    public void projectPrice() {
        basePage.openPage();
        basePage.closeCookie();
        projectPricePage.buttonPrice();
        projectPricePage.checkBoxDesktop();
        projectPricePage.lowerButtonPrice();
        projectPricePage.checkDesktopParam();
    }
}
