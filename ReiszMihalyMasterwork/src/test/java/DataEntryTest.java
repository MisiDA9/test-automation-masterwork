import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import java.util.Random;


class DataEntryTest extends BaseTest {
  @Test
  @DisplayName("TC08 - Input of new data")
  @Feature("Addresses")
  @Description("After successfully adding a new address, assert that the success message is correct.")
  public void addNewAddress() throws InterruptedException {
   signUp();
   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    Thread.sleep(3000);
    NewAddresses newAddresses = new NewAddresses(driver);
    newAddresses.open();
    newAddresses.newAddressesInput("61652 Division Terrace", "Diego", "Texas", "11111");
    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    Thread.sleep(3000);
    Addresses addresses = new Addresses(driver);
    //String message = "Address successfully added!"; Nevre jobb megoldas vagy ez az assert is ok?
    Assertions.assertTrue(addresses.getSuccessfulNewAddressMessage2());
  }


}