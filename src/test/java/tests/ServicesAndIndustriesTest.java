package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ServicesAndIndustriesTest extends TestBase{
    @Tag("AstonTests")
    @Tag("ServicesAndIndustriesTest")
    @CsvSource(value = {
            "Отрасли,         eCommerce",
            "Услуги,             Разработка мобильных приложений",
    })
    @Owner("Кудрявцев")
    @Feature("Отрасли/Услуги")
    @Story("Открытие страниц  eCommerce и Разработка мобильных приложений")
    @ParameterizedTest
    public void servicesAndIndustries(String param, String expectedText) {
        basePage.openPage();
        basePage.closeCookie();
        servicesAndIndustriesPage.searchByParam(param);
        servicesAndIndustriesPage.openTitle(expectedText);
        servicesAndIndustriesPage.checkTitle(expectedText);
    }
}
