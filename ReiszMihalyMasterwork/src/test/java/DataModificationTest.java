import Pages.Addresses;
import Pages.NewAddresses;
import Pages.Registration;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.Random;

public class DataModificationTest extends BaseTest {
  @Test
  @DisplayName("TC10 - ZIP code modification")
  @Feature("Addresses: updating information")
  @Description("After modifying the ZIP code, the validation message about the update should be correct.")
  public void modification() throws InterruptedException {
    signUp();
    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    NewAddresses newAddresses = new NewAddresses(driver);
    newAddresses.open();
    newAddresses.newAddressesInput("Alma utca 8", "Budapest", "Pest megye", "11111");

    Addresses addresses = new Addresses(driver);
    addresses.updateFirst();
    newAddresses.getPostcode().sendKeys(Keys.DELETE);
    newAddresses.getPostcode().clear();
    newAddresses.getPostcode().sendKeys("12345");
    newAddresses.getSaveButton().click();
    Thread.sleep(3000);
    Assertions.assertTrue(addresses.getFeedbackMessage().getText().equals("Address successfully updated!"));
    Thread.sleep(3000);


  }
}
