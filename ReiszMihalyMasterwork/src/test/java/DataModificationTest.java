import Pages.Addresses;
import Pages.NewAddresses;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;


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

  @Step ("Modify the already existing address, modify the Post code")
  public void modifyTheAddress() {
    NewAddresses newAddresses = new NewAddresses(driver);
    Addresses addresses = new Addresses(driver);
    addresses.updateFirst();
    newAddresses.getPostcode().clear();
    newAddresses.getPostcode().sendKeys("12345");
    newAddresses.getSaveButton().click();
  }
}
