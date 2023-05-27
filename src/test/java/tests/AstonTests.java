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
    @Test
    public void careerAston() {
        astonSteps.openPage();
        astonSteps.careerAston();
        astonSteps.secondCareerAston();
        astonSteps.closeCookie();
        astonSteps.vacations();
        astonSteps.buttonVacations();
        astonSteps.checkVacationQA();
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
        astonSteps.openPage();
        $x(String.format("//div[text()='%s']", param)).hover();
        $(byTagAndText("a", (expectedText))).click();
        $(".TitleWith-module--title--bojgT").shouldBe(text(expectedText));
    }
        @Test
        public void reactJs(){
            astonSteps.openPage();
            $x("//div[text()='Технологии']").hover();
            $(byTagAndText("a", "React")).click();
            $x("//h1[contains(text(),'React-разработка')]").shouldBe(text("React-разработка"));
        }
        @Test
       public void contactWithUs(){
            astonSteps.openPage();
            $x("//jdiv[@class='hoverl_e34b']").click();
            $x(" //textarea[@placeholder='Введите сообщение']").setValue("autotest").pressEnter();
            $(".text_dd60").shouldBe(text("Укажите ваши контакты, чтобы мы смогли ответить вам"));
        }
        @Test
        public void projectPrice(){
            astonSteps.openPage();
            $x("//a[text()='Узнать стоимость']").click();
            $(byTagAndText("div", "Desktop")).click();
            $x("//button[@class='Button-module--button--CU-kq Button-module--sizeSM--eCtqi PreviewModal-module--button--JmKgy']").click();
            $(byTagAndText("div", "Desktop")).shouldBe(visible);
        }
}
