package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

public class ProjectPriceTest extends TestBase {
    @Owner("Кудрявцев")
    @Feature("Открытие страницы Узнать стоимость")
    @Story("Открытие страницы с конфигурацией для проекта и проверка ее соответствия")
    @Test
    public void projectPrice(){
        startTest.openPage();
        projectPricePage.buttonPrice();
        projectPricePage.checkBoxDesktop();
        projectPricePage.lowerButtonPrice();
        projectPricePage.checkDesktopParam();
    }
}
