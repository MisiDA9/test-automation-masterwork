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
   saveANewAddress();

   Addresses addresses = new Addresses(driver);
   wait.until(ExpectedConditions.visibilityOf(addresses.getFeedbackMessageAboutSuccessfulAddressAdding()));
   Assertions.assertTrue(addresses.getFeedbackMessageAboutSuccessfulAddressAdding().getText().equals("Address successfully added!"));
  }
}