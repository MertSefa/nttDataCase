package com.nttdata.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;

public class Driver {
    public static WebDriver driver = null;

    public static String getDriverName() {
        String name = "chromedriver";  // if we make gecko driver firefox browser will open.
        String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            name += ".exe";
        }
        return name;
    }
    // I tried singleton design pattern.  I have windows 10 and mac, I adjusted the drivers for mac and windows 10.
    public static WebDriver getDriver() {
        if (driver == null) {
            String name = getDriverName();
            String dir = System.getProperty("user.dir");
            String driverLocation = dir + "/drivers/"+ name;
            switch (name){
                case "chromedriver" :
                    System.setProperty("webdriver.chrome.driver", driverLocation);
                    ChromeOptions options = new ChromeOptions().setHeadless(true);
                    options.addArguments(Arrays.asList("--window-position=0,0","--window-size=1840,1080"));
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    driver = new ChromeDriver();  // options verirsek headless çalışır.
                    break;
                case "geckodriver":
                    System.setProperty("webdriver.gecko.driver", driverLocation);
                    driver = new FirefoxDriver();
                    break;
            }
            System.out.println("Driver Class: Set Up");
            driver.manage().window().maximize();

        }
        return driver;
    }

    public static void closeDriver() {
        try {
            getDriver().quit();
            System.out.println("Driver quit");
            driver=null;
        } catch (Exception e) {
            System.out.println("Hata!");
        }
    }
}