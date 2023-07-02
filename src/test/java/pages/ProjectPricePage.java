package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ProjectPricePage {
    private SelenideElement
            checkBoxDesktop = $(byTagAndText("div", "Desktop")),
            buttonPrice = $x("//a[text()='Узнать стоимость']"),
            lowerButtonPrice = $x("//button[@class='Button-module--button--CU-kq Button-module--sizeSM--eCtqi PreviewModal-module--button--JmKgy']"),
            checkDesktopParam = $(byTagAndText("div", "Desktop"));


    public ProjectPricePage checkBoxDesktop() {
        step("Проставление отметки в чек-бокс Desktop", () -> {
            checkBoxDesktop.click();
        });
        return this;
    }

    public ProjectPricePage lowerButtonPrice() {
        step("Нажатие на кнопку Узнать стоимость внизу страницы", () -> {
            lowerButtonPrice.click();
        });
        return this;
    }

    public ProjectPricePage checkDesktopParam() {
        step("Проверка наличия параметра Desktop", () -> {
            checkDesktopParam.shouldBe(Condition.visible);
        });
        return this;
    }

    public ProjectPricePage buttonPrice() {
        step("Нажатие на кнопку Узнать стоимость", () -> {
            buttonPrice.click();
        });
        return this;
    }
}
