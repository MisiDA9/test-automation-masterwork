import java.io.FileInputStream;

import Pages.MyAccount;
import Pages.Registration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
  int randomNumber;
  WebDriver driver;

  @BeforeAll
  public void setupOnce() throws IOException {
    String browser;

    Properties properties = new Properties();
    InputStream propertiesStream = this.getClass().getResourceAsStream("/test.properties");
    properties.load(propertiesStream);
    browser = properties.getProperty("browser");

    if (browser.equals("chrome")) {
      WebDriverManager.chromedriver().setup();
      this.driver = new ChromeDriver();
    } else if (browser.equals("firefox")) {
      WebDriverManager.firefoxdriver().setup();
      this.driver = new FirefoxDriver();
    } else  {
      WebDriverManager.edgedriver().setup();
      this.driver = new EdgeDriver();
    }
  }

  @Step ("Signing out")
  public void signingOut() {
    MyAccount myAccount = new MyAccount(driver);
    myAccount.signOut().click();
  }

  @Step ("Gives back a random number")
  public int randomNumberGenerator() {
    Random r = new Random();
    int low = 10;
    int high = 10000;
    return randomNumber = r.nextInt(high - low) + low;
  }

  @Step ("Registration with a brand new random email")
  public void signUp() {
    randomNumberGenerator();
    Registration signUpPage = new Registration(driver);
    signUpPage.open();

    signUpPage.signUp("Michael", "Test", randomNumber + "michael@test.com", "pass123");
  }

//  @BeforeEach
//  public void setup() {
//    driver.manage().window().maximize();
//  }

  @Attachment("Screenshot")
  public byte[] makeScreenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  @AfterAll
  public void teardown() {
    driver.quit();
  }

}