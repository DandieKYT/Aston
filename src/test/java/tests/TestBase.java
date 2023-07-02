package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import help.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.util.Map;

import static io.qameta.allure.Allure.step;

public class TestBase extends help.Attachment {
    BasePage basePage = new BasePage();
    ChatPage chatPage = new ChatPage();
    ReactPage reactPage = new ReactPage();
    CareerPage careerPage = new CareerPage();
    StartTest startTest = new StartTest();
    VacationPage vacationPage = new VacationPage();
    ProjectPricePage projectPricePage = new ProjectPricePage();
    ServicesAndIndustriesPage servicesAndIndustriesPage = new ServicesAndIndustriesPage();
    Attachment attachment = new Attachment();

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        Configuration.remote = "https://user1:1234@" + System.getProperty("selenoid_url", "selenoid.autotests.cloud/wd/hub");
        Configuration.baseUrl = "https://astondevs.ru";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void attachemts() {
        attachment.browserLogs();
        attachment.attachScreenshot();
        attachment.pageSource();
        attachment.addVideo();
    }

    public static class StartTest extends BasePage {

        public StartTest closeCookie() {
            step("Закрытие куки", () -> {
                closeCookie.click();
            });
            return this;
        }

        public StartTest openPage() {
            step("Открытие главной страницы", () -> {
                Selenide.open("/");
            });
            return this;
        }
    }
}

