package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class AstonTests extends TestBase {
    @Test
    public void careerAston() {
        open("/");
        $(withTagAndText("div", "Карьера")).hover().click();
        $(withTagAndText("a", "Карьера")).click();
        $x("//button[contains(text(),'Подтверждаю')]").click();
        $x("//a[contains(text(),'Вакансии')]").click();
        switchTo().window(1);
        $(".tmpl_hh_tab--about .tmpl_hh_header__vacancy-button").click();
        $x("//span[text()='Тестировщик']").shouldBe(Condition.visible);
    }


    @CsvSource(value = {
            "Отрасли,         eCommerce",
            "Услуги,             Разработка мобильных приложений",
    })
    @Owner("Kudryavtsev")
    @Feature("Материалы и Карьера")
    @Story("Открытие страниц Материалы и Карьера")
    @ParameterizedTest
    public void servicesAndIndustries(String param, String expectedText) {
        open("/");
        $x(String.format("//div[text()='%s']", param)).hover();
        $(byTagAndText("a", (expectedText))).click();
        $(".TitleWith-module--title--bojgT").shouldBe(text(expectedText));
    }
}
