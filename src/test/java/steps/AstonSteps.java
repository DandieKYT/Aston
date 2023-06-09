package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.AstonPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class AstonSteps {

    AstonPage astonPage = new AstonPage();
    @Step("Получение логов браузера")
    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    public static void browserLogs() {
        attachAsText(
                "Browser console log",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }

    @Attachment(value = "Скриншот", type = "image/png", fileExtension = "png")
    public static byte[] attachScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
    @Step("Получение записи видео теста")
    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src ='"
                + getVideoUrl()
                + "' type='video/mp4'></video></body></html>";

    }

    public static URL getVideoUrl() {
        String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId() + ".mp4";
        try{
            return new URL(videoUrl);
        }   catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Step("Page Source")
    @Attachment(value = "Page Source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Step("Открытие сайта")
    public AstonPage openPage() {
        Selenide.open("/");
        return null;
    }
    @Step("Наведение мыши на раздел Карьера")
    public void careerAston(){
        astonPage.careerAston().hover().click();
    }
    @Step("Открытие вкладки Карьера")
    public void secondCareerAston(){
        astonPage.secondCareerAston().click();
    }
    @Step("Закрытие куки")
    public void closeCookie(){
        astonPage.closeCookie().click();
    }
    @Step("Переход на страницу вакансий")
    public void vacations(){
        astonPage.vacations().click();
        switchTo().window(1);
    }
    @Step("Нажатие на кнопку Вакансии")
    public void buttonVacations(){
        astonPage.buttonVacations().click();
    }
    @Step("Проверка наличия вакансии Тестировщик")
    public void checkVacationQA(){
        $(".Filters_wrapper__xmdf6 > div:nth-of-type(3) > div > div > input").setValue("QA");
        $(".Filters_wrapper__xmdf6 > div:nth-of-type(3) > div > ul > li > button > span").shouldBe(visible);
        Selenide.closeWindow();
        switchTo().window(0);
    }
    @Step("Открытие верхнего меню")
    public void searchByParam(String param) {
        astonPage.searchByParam(param).hover();
    }
    @Step("Открытие вкладки")
    public void openTitle(String expectedText) {
        astonPage.openTitle(expectedText).click();
    }
    @Step("Проверка страницы по ожидаемому тексту")
    public void checkTitle(String expectedText){
        astonPage.checkTitle().shouldBe(text(expectedText));
    }
    @Step("Открытие раздела Технологии")
    public void openTechnologies(){
        astonPage.openTechnologies().hover();
    }
    @Step("Открытие страницы React")
    public void openReact(){
        astonPage.openReact().click();
    }
    @Step("Проверка страницы React")
    public void checkReact(){
        astonPage.checkReact().shouldBe(text("React-разработка"));
    }
    @Step("Открытие чата")
    public void chatWindow(){
        astonPage.chatWindow().click();
    }
    @Step("Отправка сообщения autotest")
    public void setValueChat(){
        astonPage.setValueChat().setValue("autotest").pressEnter();
    }
    @Step("Проверка ответа чата на сообщение")
    public void checkChatResponse(){
        astonPage.checkChatResponse().shouldBe(text("Укажите ваши контакты, чтобы мы смогли ответить вам"));
    }
    @Step("Нажатие на кнопку Узнать стоимость")
    public void buttonPrice(){
        astonPage.buttonPrice().click();
    }
    @Step("Проставление отметки в чек-бокс Desktop")
    public void checkBoxDesktop(){
        astonPage.checkBoxDesktop().click();
    }
    @Step("Нажатие на кнопку Узнать стоимость внизу страницы")
    public void lowerButtonPrice(){
        astonPage.lowerButtonPrice().click();
    }
    @Step("Проверка наличия параметра Desktop")
    public void checkDesktopParam(){
        astonPage.checkDesktopParam().shouldBe(visible);
    }
}
