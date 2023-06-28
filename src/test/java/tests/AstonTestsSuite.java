package tests;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.ChatPage;

@Tag("remote_test")
public class AstonTestsSuite extends TestBase {

    @Owner("Кудрявцев")
    @Feature("Карьера в Aston")
    @Story("Проверка наличия вакансии Тестировщик")
    @Test
    public void careerAston() {
        mainPage.openPage();
        careerPage.careerAston();
        careerPage.secondCareerAston();
        mainPage.closeCookie();
        careerPage.vacations();
        vacationPage.qaValue();
        vacationPage.checkQaResult();
    }


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
    @Owner("Кудрявцев")
    @Feature("Технология React")
    @Story("Открытие страницы React и проверка ее содержимого")
    @Test
    public void reactJs(){
        mainPage.openPage();
        reactPage.openTechnologies();
        reactPage.openReact();
        reactPage.checkReact();
    }
    @Owner("Кудрявцев")
    @Feature("Чат")
    @Story("Проверка ответа бота на запрос")
    @Test
    public void contactWithUs(){
        mainPage.openPage();
        chatPage.chatWindow();
        chatPage.setValueChat();
        chatPage.checkChatResponse();
    }
    @Owner("Кудрявцев")
    @Feature("Открытие страницы Узнать стоимость")
    @Story("Открытие страницы с конфигурацией для проекта и проверка ее соответствия")
    @Test
    public void projectPrice(){
        mainPage.openPage();
        projectPricePage.buttonPrice();
        projectPricePage.checkBoxDesktop();
        projectPricePage.lowerButtonPrice();
        projectPricePage.checkDesktopParam();
    }
}
