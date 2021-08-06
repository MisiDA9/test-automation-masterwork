import Pages.MyAccount;
import Pages.NewAddresses;
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
import java.time.Duration;
import java.util.Properties;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
  WebDriver driver;
  WebDriverWait wait;

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

    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    driver.manage().window().maximize();
  }

  @Step ("Signing out")
  public void signingOut() {
    MyAccount myAccount = new MyAccount(driver);
    myAccount.open();
    myAccount.getSignOut().click();
  }

  @Step ("Registration with a brand new random email")
  public void signUp() {
    Registration signUpPage = new Registration(driver);
    signUpPage.open();
    signUpPage.signUp("Michael", "Test", System.currentTimeMillis() + "michael@test.com", "pass123");
  }

  @Step ("Saving a new valid address")
  public void saveANewAddress() {
    NewAddresses newAddresses = new NewAddresses(driver);
    newAddresses.open();
    newAddresses.newAddressesInput("23 Bunting Road", "Naples", "Florida", "11111");
  }

  @Attachment("Screenshot")
  public byte[] makeScreenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  @AfterAll
  public void teardown() {
    driver.quit();
  }
}