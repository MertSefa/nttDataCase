package com.nttdata.com;

import static org.junit.Assert.assertTrue;

import com.nttdata.com.Enums.GenericInfo;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class AppTest 
{
WebDriver driver;
    @BeforeMethod
    public void testSetup() {
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void testFinish() {
        Driver.closeDriver();
    }

    public void driverStart() throws InterruptedException {
        driver.get(GenericInfo.WEB_BASE_URL.getValue());
        Thread.sleep(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demoqa.com/");
    }

    @Test
    public void goFormsAndSubmit() throws InterruptedException, CsvValidationException, IOException {
        driverStart();
        PracticeForm practiceForm = new PracticeForm();
        practiceForm.createPracticeForm();
    }

}


