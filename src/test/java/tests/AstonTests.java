package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class AstonTests extends TestBase{
    @Test
    public void careerAston(){
        open("/");
        $x("//li[@tabindex='Карьера']").hover().click();
        $(withTagAndText("a","Карьера")).click();
        $x("//button[contains(text(),'Подтверждаю')]").click();
        $x("//a[contains(text(),'Вакансии')]").click();
        $(".tmpl_hh_tab--about .tmpl_hh_header__vacancy-button").click();
        $x("//span[text()='Тестировщик']").shouldBe(Condition.visible);
        sleep(5000);
    }
}
