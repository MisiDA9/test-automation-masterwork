import Pages.Addresses;
import Pages.Login;
import Pages.NewAddresses;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class DataEntryTestRepetitive_CSV extends BaseTest {

  @BeforeAll
  public void initEach() {
    Login loginPage = new Login(driver);
    loginPage.open();
    loginPage.login("michael@test.com", "pass123");
  }

  @ParameterizedTest(name = "Data entry: New address has been added with parameterized Test.")
  @CsvFileSource(resources = "/input.csv")
  @Feature("Addresses")
  @Description("After adding an address, the success message should be correct every time.")
  public void paramTest1(String address, String city, String state, String postcode) {
    NewAddresses newAddresses = new NewAddresses(driver);
    newAddresses.open();
    newAddresses.newAddressesInput(address, city, state, postcode);

    Addresses addresses = new Addresses(driver);
    Assertions.assertTrue(addresses.getSuccessfulNewAddressMessage2());
  }
}
