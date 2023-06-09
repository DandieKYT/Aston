package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import steps.AstonSteps;

import javax.swing.*;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@Tag("remote_test")
public class AstonTests extends TestBase {
    AstonSteps astonSteps = new AstonSteps();
    @Owner("Кудрявцев")
    @Feature("Карьера в Aston")
    @Story("Открытие страницы на HH и проверка наличия вакансии Тестировщик")
    @Test
    public void careerAston() {
        astonSteps.openPage();
        astonSteps.careerAston();
        astonSteps.secondCareerAston();
        astonSteps.closeCookie();
        astonSteps.vacations();
        astonSteps.checkVacationQA();
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
        astonSteps.openPage();
        astonSteps.searchByParam(param);
        astonSteps.openTitle(expectedText);
        astonSteps.checkTitle(expectedText);
    }
    @Owner("Кудрявцев")
    @Feature("Технология React")
    @Story("Открытие страницы React и проверка ее содержимого")
    @Test
    public void reactJs(){
        astonSteps.openPage();
        astonSteps.openTechnologies();
        astonSteps.openReact();
        astonSteps.checkReact();
    }
    @Owner("Кудрявцев")
    @Feature("Чат")
    @Story("Проверка ответа бота на запрос")
    @Test
    public void contactWithUs(){
        astonSteps.openPage();
        astonSteps.chatWindow();
        astonSteps.setValueChat();
        astonSteps.checkChatResponse();
    }
    @Owner("Кудрявцев")
    @Feature("Открытие страницы Узнать стоимость")
    @Story("Открытие страницы с конфигурацией для проекта и проверка ее соответствия")
    @Test
    public void projectPrice(){
        astonSteps.openPage();
        astonSteps.buttonPrice();
        astonSteps.checkBoxDesktop();
        astonSteps.lowerButtonPrice();
        astonSteps.checkDesktopParam();
    }
}
