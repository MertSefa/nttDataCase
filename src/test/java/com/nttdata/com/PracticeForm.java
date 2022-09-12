package com.nttdata.com;

import com.nttdata.com.Enums.UserInfo;
import com.nttdata.com.Locators.PracticeFormElements;
import com.opencsv.CSVReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class PracticeForm {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    String[] csvCell;

    public static String clickHomePageForms = PracticeFormElements.CLICK_HOMEPAGE_FORMS_ELEMENT.getValue();
    public static String clickPracticeForm = PracticeFormElements.CLICK_PRACTICE_FORM_ELEMENT.getValue();
    public static String firstName = PracticeFormElements.FIRST_NAME_ELEMENT.getValue();
    public static String lastName = PracticeFormElements.LAST_NAME_ELEMENT.getValue();
    public static String email = PracticeFormElements.EMAIL_ELEMENT.getValue();
    public static String genderMale = PracticeFormElements.GENDER_MALE_ELEMENT.getValue();
    public static String genderFemale = PracticeFormElements.GENDER_FEMALE_ELEMENT.getValue();
    public static String genderOther = PracticeFormElements.GENDER_OTHER_ELEMENT.getValue();
    public static String mobilePhone = PracticeFormElements.MOBILE_PHONE_ELEMENT.getValue();
    public static String dateClick = PracticeFormElements.DATE_CLICK_ELEMENT.getValue();
    public static String monthsSelect = PracticeFormElements.MONTHS_SELECT_ELEMENT.getValue();
    public static String yearsSelect = PracticeFormElements.YEARS_SELECT_ELEMENT.getValue();
    public static String daySelect = PracticeFormElements.DAY_SELECT_ELEMENT.getValue();
    public static String subjects = PracticeFormElements.SUBJECT_ELEMENT.getValue();
    public static String hobbiesSports = PracticeFormElements.HOBBIES_SPORTS_ELEMENT.getValue();
    public static String hobbiesReading = PracticeFormElements.HOBBIES_READING_ELEMENT.getValue();
    public static String hobbiesMusic = PracticeFormElements.HOBBIES_MUSIC_ELEMENT.getValue();
    public static String uploadPicture = PracticeFormElements.UPLOAD_PICTURES_ELEMENT.getValue();
    public static String currentAddress = PracticeFormElements.CURRENT_ADDRESS_ELEMENT.getValue();
    public static String states = PracticeFormElements.STATE_ELEMENT.getValue();
    public static String cities = PracticeFormElements.CITY_ELEMENT.getValue();
    public static String submitForm = PracticeFormElements.SUBMIT_ELEMENT.getValue();
    public static String closeModal = PracticeFormElements.CLOSE_MODAL_ELEMENT.getValue();


    final static Logger logger = Logger.getLogger(PracticeForm.class);

    public PracticeForm(){
        this.driver = Driver.getDriver();
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goDemoForm() throws InterruptedException {
        WebElement clickForms = driver.findElement(By.cssSelector(clickHomePageForms));
        clickForms.click();
        logger.info("forms are clicked");
        Thread.sleep(2000);
        WebElement practiceFormClick = driver.findElement(By.cssSelector(clickPracticeForm));
        practiceFormClick.click();
        logger.info("practice form are  clicked");
    }


    public void dataRead_CSV() throws IOException, CsvValidationException {
        String CSV_PATH;
        String dir = System.getProperty("user.dir");
        String name = "username.csv";
        CSV_PATH = dir + "/csv/" +name;
        CSVReader csvReader = new CSVReader(new FileReader(CSV_PATH));

        while ((csvCell = csvReader.readNext()) != null) {
            String costumerCurrentAddress = csvCell[0];
            String customerMail = csvCell[1];
            String customerFirstName = csvCell[2];
            String customerLastName = csvCell[3];
            driver.findElement(By.id(firstName)).sendKeys(customerFirstName);
            driver.findElement(By.id(lastName)).sendKeys(customerLastName);
            driver.findElement(By.id(email)).sendKeys(customerMail);
            driver.findElement(By.id(currentAddress)).sendKeys(costumerCurrentAddress);
            logger.info("first name, last name, email and currentaddress are entered ");
        }
    }

    public void genderAndMobilePhoneInput(){
        WebElement gender = driver.findElement(By.cssSelector(genderMale));
        gender.click();
        logger.info("gender selected");
        WebElement mobilePhoneInput = driver.findElement(By.id(mobilePhone));
        mobilePhoneInput.sendKeys(UserInfo.PHONE.getValue());
        logger.info("phone number entered");
    }

    public void selectDateOfBirth() {
        WebElement date = driver.findElement(By.id(dateClick));
        date.click();
        logger.info("calendar clicked");
        Select months = new Select(driver.findElement(By.cssSelector(monthsSelect)));
        months.selectByValue(String.valueOf(10));
        logger.info("month is selected");
        Select years = new Select(driver.findElement(By.cssSelector(yearsSelect)));
        years.selectByValue(String.valueOf(1998));
        logger.info("year is selected");
        WebElement day = driver.findElement(By.cssSelector(daySelect));
        day.click();
        logger.info("day is selected");
    }

    public void subjectsAndHobbiesInput() {
        WebElement subject = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(subjects)));
        subject.sendKeys(UserInfo.SUBJECT.getValue());
        subject.sendKeys(Keys.ENTER);
        logger.info("chooses subject");
        WebElement hobbies = driver.findElement(By.cssSelector(hobbiesMusic));
        hobbies.click();
        logger.info("hobby is chosen");
    }


    public void selectStateAndCity() {
        WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(states)));
        state.sendKeys(UserInfo.STATE.getValue());
        state.sendKeys(Keys.ARROW_DOWN);
        state.sendKeys(Keys.ENTER);
        logger.info("country is chosen");
        WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cities)));
        city.sendKeys(UserInfo.CITY.getValue());
        city.sendKeys(Keys.ARROW_DOWN);
        city.sendKeys(Keys.ENTER);
        logger.info("city is chosen");
    }

    public void submitForm() {
        js.executeScript(String.valueOf(submitForm));
        logger.info("submit clicked");
    }


    public void closeModal() {
        js.executeScript(closeModal);
        logger.info("close modal clicked");
    }
    public void screenShot() throws IOException {
        String screenShotPath;
        String dir = System.getProperty("user.dir");
        screenShotPath = dir + "/screenShots/" + "screen1.png" ;
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(scrFile, new File(screenShotPath));
        logger.info("screenshot is taken and saved");
    }

    public void uploadFile() {
        String dir = System.getProperty("user.dir");
        String filePath;
        filePath = dir + "/fileToBeUploaded" + "/u.png" ;
        driver.findElement(By.id(uploadPicture)).sendKeys(filePath);
    }
    public void createPracticeForm() throws InterruptedException, CsvValidationException, IOException {
       goDemoForm();
       dataRead_CSV();
       genderAndMobilePhoneInput();
       selectDateOfBirth();
       subjectsAndHobbiesInput();
       uploadFile();
       selectStateAndCity();
       Thread.sleep(1000);
       submitForm();
       Thread.sleep(5000);
       screenShot();
       Thread.sleep(1000);
       closeModal();
    }
}
