import Pages.Addresses;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
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
    saveANewAddress();
    deleteFirstAddress();

    Addresses addresses = new Addresses(driver);
    Assertions.assertTrue(addresses.getFeedbackMessage().getText().equals("Address successfully deleted!"));
  }

  @Step("Deleting the first address")
  public void deleteFirstAddress() {
    Addresses addresses = new Addresses(driver);
    addresses.deleteFirst();
  }
}
