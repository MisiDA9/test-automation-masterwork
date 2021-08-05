import Pages.Login;
import Pages.MyAccount;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LoginTests extends BaseTest {
  @Test
  @DisplayName("TC03 - Successful attempt")
  @Feature("Login")
  @Description("After a successful login attempt with valid inputs, assert that the \"Sign out\" button is displayed in the header.")
  public void loginToTheWebshop_Success() {
    successfulLogin();

    MyAccount myAccount = new MyAccount(driver);
    Assertions.assertTrue(myAccount.getSignOut().isDisplayed());
    myAccount.getSignOut().click();
  }

  @Test
  @DisplayName("TC04 - Unsuccessful attempt")
  @Feature("Login")
  @Description("After an unsuccessful login attempt with invalid password, assert that the error message is correct.")
  public void loginToTheWebshop_Failed() {
    unSuccessfulLogin();

    Login loginPage = new Login(driver);
    Assertions.assertEquals(loginPage.getLoginFailedMessage().getText(),"Authentication failed.");
  }

  @Step ("Successful login")
  public void successfulLogin(){
    Login loginPage = new Login(driver);
    loginPage.open();
    loginPage.login("michael@test.com", "pass123");
  }

  @Step ("Unsuccessful login")
  public void unSuccessfulLogin(){
    Login loginPage = new Login(driver);
    loginPage.open();
    loginPage.login("michael@test.com", "Not existing password");
  }
}