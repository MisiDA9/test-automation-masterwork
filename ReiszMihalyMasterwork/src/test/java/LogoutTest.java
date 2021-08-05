import Pages.Login;
import Pages.MyAccount;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

class LogoutTest extends BaseTest{
  @Test
  @DisplayName("TC_0X - Successful attempt")
  @Feature("Logout")
  @Description("After successful login, log out and assert that the \"Log in to your account\" is displayed")

  public void signOut() {
    Login loginPage = new Login(driver);
    loginPage.open();
    loginPage.login("michael@test.hu", "pass123");
    //.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    MyAccount myAccount = new MyAccount(driver);
    myAccount.signOut().click();

    String exp = loginPage.loginToYourAccount();
    Assertions.assertEquals(exp,"Log in to your account");
  }



}