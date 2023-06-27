package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;


public class VacationPage {
    private SelenideElement
            qaValue = $(".Filters_wrapper__xmdf6 > div:nth-of-type(3) > div > div > input"),
            checkQaResult = $(".Filters_wrapper__xmdf6 > div:nth-of-type(3) > div > ul > li > button > span");

    public VacationPage qaValue() {
        step("Ввод в поиск QA", () -> {
            qaValue.setValue("QA");
        });
        return this;
    }
    public VacationPage checkQaResult() {
        step("Проверка наличия вакансий", () -> {
            checkQaResult.shouldBe(visible);
            Selenide.closeWindow();
            switchTo().window(0);
        });
        return this;
    }
}


