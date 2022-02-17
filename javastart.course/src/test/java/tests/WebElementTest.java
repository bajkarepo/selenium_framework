package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class WebElementTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    //@Test
    public void typingWebElementTest() {
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("Selenium");
        String typeUserNameValue = userNameField.getAttribute("value");
        assertEquals(typeUserNameValue, "Selenium");
        userNameField.clear();
    }

   // @Test
    public void checkRadioButtonTest() {
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='female']"));
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));

        femaleRadioButton.click();
        assertTrue(femaleRadioButton.isSelected());

        maleRadioButton.click();
        assertTrue(maleRadioButton.isSelected());

        assertFalse(femaleRadioButton.isSelected());
    }

    //@Test
    public void filePickingTest() {
        WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
        uploadFilePicker.sendKeys("C:\\installerLog.txt");
    }

    //@Test
    public void dropDownListingTest() {
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);
        List<WebElement> options = countryDropDown.getOptions();
        List<String> nameOfOptions = new ArrayList<>();

        for (WebElement option : options) {
            nameOfOptions.add(option.getText());
        }

        List<String> expectedNamesOfOptions = new ArrayList<>();
        expectedNamesOfOptions.add("Germany");
        expectedNamesOfOptions.add("Poland");
        expectedNamesOfOptions.add("UK");

        assertEquals(nameOfOptions, expectedNamesOfOptions);
    }

   // @Test
    public void checkIfElementsOnPageTest(){

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement emailLabel = driver.findElement(By.cssSelector("span[class='help-block']"));

        System.out.println("Is usernameField displayed: " + usernameField.isDisplayed());
        System.out.println("Is usernameField enabled: " + usernameField.isEnabled());

        System.out.println("Is passwordField displayed: " + passwordField.isDisplayed());
        System.out.println("Is passwordField enabled: " + passwordField.isEnabled());

        System.out.println("Is emailLabel displayed: " + emailLabel.isDisplayed());
        System.out.println("Is emailLabel enabled: " + emailLabel.isEnabled());
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
