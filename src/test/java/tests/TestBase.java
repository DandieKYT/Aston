package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import steps.AstonSteps;

import java.util.Map;

public class TestBase {

    AstonSteps astonSteps = new AstonSteps();
    @BeforeAll
    static void setUp() {
//        Configuration.browser = "chrome";
//        Configuration.browserVersion = "100.0";
//        Configuration.remote = "https://user1:1234@" + System.getProperty("selenoid_url", "selenoid.autotests.cloud/wd/hub");
        Configuration.baseUrl = "https://astondevs.ru";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true

        ));

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void attachments(){
        astonSteps.browserLogs();
        astonSteps.attachScreenshot();
        astonSteps.pageSource();
        astonSteps.addVideo();
    }
}
