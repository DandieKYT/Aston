package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.swing.*;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        Selenide.closeWindow();
        switchTo().window(0);
        sleep(3000);
    }


    @CsvSource(value = {
            "Отрасли,         eCommerce",
            "Услуги,             Разработка мобильных приложений",
    })
    @Owner("Kudryavtsev")
    @Feature("Отрасли и Услуги")
    @Story("Открытие страниц  eCommerce и Разработка мобильных приложений")
    @ParameterizedTest
    public void servicesAndIndustries(String param, String expectedText) {
        open("/");
        $x(String.format("//div[text()='%s']", param)).hover();
        $(byTagAndText("a", (expectedText))).click();
        $(".TitleWith-module--title--bojgT").shouldBe(text(expectedText));
    }
        @Test
        public void reactJs(){
            open("/");
            $x("//div[text()='Технологии']").hover();
            $(byTagAndText("a", "React")).click();
            actions().scrollToElement( $x("//div[text()='Тестирование']"));
            $x("//div[text()='Тестирование']").click();
            $x("//button[text()='Next']").click();
            $x("//*[contains(@class, 'slick-current')]//h3[text()='Mocha']").shouldBe(text("Mocha"));
        }
        @Test
       public void contactWithUs(){
            open("/");
            $x("//jdiv[@class='hoverl_e34b']").click();
            $x(" //textarea[@placeholder='Введите сообщение']").setValue("autotest").pressEnter();
            $(".text_dd60").shouldBe(text("Укажите ваши контакты, чтобы мы смогли ответить вам"));
        }
        @Test
        public void projectPrice(){
            open("/");
            $x("//a[text()='Узнать стоимость']").click();
            $(byTagAndText("div", "Desktop")).click();
            $x("//button[@class='Button-module--button--CU-kq Button-module--sizeSM--eCtqi PreviewModal-module--button--JmKgy']").click();
            $(byTagAndText("div", "Desktop")).shouldBe(visible);
            sleep(2000);
        }
}
