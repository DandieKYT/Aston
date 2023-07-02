package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

public class CareerTest  extends TestBase{
    @Owner("Кудрявцев")
    @Feature("Карьера в Aston")
    @Story("Проверка наличия вакансии Тестировщик")
    @Test
    public void careerAston() {
        startTest.openPage();
        startTest.closeCookie();
        careerPage.careerAston();
        careerPage.secondCareerAston();
        startTest.closeCookie();
        careerPage.vacations();
        vacationPage.qaValue();
        vacationPage.checkQaResult();
    }
}
