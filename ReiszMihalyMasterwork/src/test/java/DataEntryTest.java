import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

class DataEntryTest extends BaseTest {
  @Test
  @DisplayName("TC08 - Input of new data")
  @Feature("Addresses")
  @Description("After successfully adding a new address, assert that the success message is correct.")
  public void addNewAddress() {
   signUp();

   NewAddresses newAddresses = new NewAddresses(driver);
   newAddresses.open();
   newAddresses.newAddressesInput("61652 Division Terrace", "Diego", "Texas", "11111");

   Addresses addresses = new Addresses(driver);
   wait.until(ExpectedConditions.visibilityOf(addresses.getFeedbackMessageADDDADDRESSSS()));
   Assertions.assertTrue(addresses.getFeedbackMessageADDDADDRESSSS().getText().equals("Address successfully added!"));
  }
}