import Pages.Login;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LogoutTest extends BaseTest{
  @Test
  @DisplayName("TC_12 - Successful logout attempt")
  @Feature("Logout")
  @Description("After successful login, log out and assert that the \"Log in to your account\" is displayed")
  public void signOut() throws InterruptedException {
    signUp();
    signingOut();

    Login loginPage = new Login(driver);
    String exp = loginPage.getLoginToYourAccount();
    Assertions.assertEquals(exp,"Log in to your account");
  }
}