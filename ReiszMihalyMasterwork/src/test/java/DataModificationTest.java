import Pages.Addresses;
import Pages.NewAddresses;
import Pages.Registration;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Random;

public class DataModificationTest extends BaseTest {


  @Test
  @DisplayName("TC10 - ZIP code modification")
  @Feature("Addresses: updating information")
  @Description("After modifying the ZIP code, the validation message about the update should be correct.")
  public void modification() {
    signUp();
    saveANewAddress();
    modifyTheAddress();

    Addresses addresses = new Addresses(driver);
    wait.until(ExpectedConditions.visibilityOf(addresses.getFeedbackMessage()));
    Assertions.assertTrue(addresses.getFeedbackMessage().getText().equals("Address successfully updated!"));
    }

    @Step ("Saving a new valid address")
    public void saveANewAddress() {
      NewAddresses newAddresses = new NewAddresses(driver);
      newAddresses.open();
      newAddresses.newAddressesInput("23 Bunting Road", "Naples", "Florida", "11111");
    }

    @Step ("Modify the already exist address")
    public void modifyTheAddress() {
      NewAddresses newAddresses = new NewAddresses(driver);
      Addresses addresses = new Addresses(driver);
      addresses.updateFirst();
      newAddresses.getPostcode().sendKeys(Keys.DELETE);
      newAddresses.getPostcode().clear();
      newAddresses.getPostcode().sendKeys("12345");
      newAddresses.getSaveButton().click();
    }
}
