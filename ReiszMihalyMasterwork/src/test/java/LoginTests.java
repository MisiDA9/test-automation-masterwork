import Pages.Login;
import Pages.MyAccount;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;


class LoginTests extends BaseTest {
  @Test
  @DisplayName("TC03 - Successful attempt")
  @Feature("Login")
  @Description("After a successful login attempt with valid inputs, assert that the \"Sign out\" button is displayed in the header.")
  public void loginToTheWebshop_Success() {
    Login loginPage = new Login(driver);
    loginPage.open();
    loginPage.login("michael@test.com", "pass123");

    MyAccount myAccount = new MyAccount(driver);
    Assertions.assertTrue(myAccount.signOut().isDisplayed());
    myAccount.signOut().click();
  }

  @Test
  @DisplayName("TC04 - Unsuccessful attempt")
  @Feature("Login")
  @Description("After an unsuccessful login attempt with invalid password, assert that the error message is correct.")
  public void loginToTheWebshop_Failed() {
    Login loginPage = new Login(driver);
    loginPage.open();
    loginPage.login("michael@test.com", "Not existing password");

    Assertions.assertEquals(loginPage.getLoginFailedMessage().getText(),"Authentication failed.");
  }
}