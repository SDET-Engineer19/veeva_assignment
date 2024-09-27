package com.veeva.assignment.ApplicationManager;

import com.veeva.assignment.ui.pageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DriverManager {


    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    protected static FactoryManager factoryManager = null;
    protected static HomePage homePage = null;

    public static WebDriver driver() {

        return driver.get();
    }

    public static void openBrowser() {

        String browserName = factoryManager.getInputProperty("browser");
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver(factoryManager.getChromeOptions()));
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver(factoryManager.getEdgeOptions()));
                break;
            default:
                break;
        }
    }


    public static void deleteAllCookies() {

        driver().manage().deleteAllCookies();
    }

    public static void maximizeWindow() {

        driver().manage().window().maximize();
    }

    public static void pageLoadTimeOut(long seconds) {

        driver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
    }

    public static void launchApp() {

        driver().get(factoryManager.getInputProperty("url"));
        //utils.sleep(2000);
    }

    public static void pageObjectInitialization() {

        factoryManager = new FactoryManager();
        homePage = new HomePage();

    }

    public static void destroyPageObjects() {


    }

    public WebElement getWebElement(By locator){

        return driver().findElement(locator);
    }

    public static String getScreenshot(String methodName) {

        File srcFile = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" + System.currentTimeMillis()
                + ".png";
        File destination = new File(path);

        try {
            FileHandler.copy(srcFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}

