import Pages.Addresses;
import Pages.NewAddresses;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DeletingDataTest extends BaseTest {

  @Test
  @DisplayName("TC_11 - delete an address")
  @Feature("Addresses: deleting address")
  @Description("After deleting an address, the validation message about the successful delete should be correct.")
  public void shouldDeleteAnAddress() {
      signUp();
      NewAddresses newAddresses = new NewAddresses(driver);
      newAddresses.open();
      newAddresses.newAddressesInput("Roxbury Alley 8", "San Jose", "California", "14136");
      Addresses addresses = new Addresses(driver);
      addresses.deleteFirst();
      Assertions.assertTrue(addresses.getFeedbackMessage().getText().equals("Address successfully deleted!"));
  }
}
