import Pages.Addresses;
import Pages.NewAddresses;
import Pages.Registration;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.util.Random;

public class DeletingDataTest extends BaseTest {

  @Test
  @DisplayName("TC_11 - delete an address")
  @Feature("Addresses: deleting address")
  @Description("After deleting an address, the validation message about the successful delete should be correct.")

  public void shouldDeleteAnAdress() {
      signUp();
      NewAddresses newAddresses = new NewAddresses(driver);
      newAddresses.open();
      newAddresses.newAddressesInput("Roxbury Alley 8", "San Jose", "California", "14136");
      Addresses addresses = new Addresses(driver);
      addresses.deleteFirst();
      Assertions.assertTrue(addresses.getFeedbackMessage().getText().equals("Address successfully deleted!"));
  }
}
