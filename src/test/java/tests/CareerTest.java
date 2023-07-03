package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CareerTest extends TestBase {
    @Tag("AstonTests")
    @Tag("CareerTest")
    @Owner("Кудрявцев")
    @Feature("Карьера в Aston")
    @Story("Проверка наличия вакансии Тестировщик")
    @Test
    public void careerAston() {
        basePage.openPage();
        basePage.closeCookie();
        careerPage.careerAston();
        careerPage.secondCareerAston();
        careerPage.vacations();
        vacationPage.qaValue();
        vacationPage.checkQaResult();
    }
}
