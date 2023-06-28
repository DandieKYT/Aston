package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ServicesAndIndustriesTest extends TestBase{
    @CsvSource(value = {
            "Отрасли,         eCommerce",
            "Услуги,             Разработка мобильных приложений",
    })
    @Owner("Кудрявцев")
    @Feature("Отрасли/Услуги")
    @Story("Открытие страниц  eCommerce и Разработка мобильных приложений")
    @ParameterizedTest
    public void servicesAndIndustries(String param, String expectedText) {
        mainPage.openPage();
        paramPage.searchByParam(param);
        paramPage.openTitle(expectedText);
        paramPage.checkTitle(expectedText);
    }
}
