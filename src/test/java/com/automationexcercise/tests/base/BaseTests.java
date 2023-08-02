package com.automationexcercise.tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTests {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {

            try {
                // Directorio donde se guardarán los screenshots
                String screenshotsDir = "target/allure-results/screenshots/";

                // Capturar el screenshot
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // Copiar el archivo de screenshot al directorio de Allure
                FileUtils.copyFile(screenshotFile, new File(screenshotsDir + result.getName() + System.currentTimeMillis() + ".png"));

                // Adjuntar el screenshot al informe de Allure
                Allure.addAttachment(result.getName() + " - Screenshot", FileUtils.openInputStream(new File(screenshotsDir + result.getName() + System.currentTimeMillis() + ".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
