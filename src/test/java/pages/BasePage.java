package pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$x;

public class BasePage {
    public SelenideElement  closeCookie = $x("//button[contains(text(),'Подтверждаю')]");
}
