import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import base.BaseTest;
import org.testng.annotations.Test;
import pageobjects.pages.HomePage;
import pageobjects.pages.LoginPage;
import utils.ApiHelper;

import java.io.IOException;


public class LoginTest extends BaseTest {

    @Test
    public void loginSuccessfulWithLocalStorage() {
        HomePage homePage = new HomePage();
        homePage.setItemInLocalStorage("token", "eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjo0ODEwNDN9:1lqGbb:OuqiKtEFeZGonN9-uGGgQMu-PHA");
        homePage.setItemInLocalStorage("userInfo", "{\"id\":481043,\"username\":\"artyomtest\",\"full_name\":\"Artyom Tonoyan\",\"full_name_display\":\"Artyom Tonoyan\",\"color\":\"#7111c2\",\"bio\":\"\",\"lang\":\"\",\"theme\":\"\",\"timezone\":\"\",\"is_active\":true,\"photo\":null,\"big_photo\":null,\"gravatar_id\":\"36e706fb7d67dc38504709498205717c\",\"roles\":[],\"total_private_projects\":0,\"total_public_projects\":0,\"email\":\"artyom.tonoyan@picsart.com\",\"uuid\":\"e4904d3eca7240338c501ab8afe8937b\",\"date_joined\":\"2021-06-07T14:30:06.299Z\",\"read_new_terms\":true,\"accepted_terms\":true,\"max_private_projects\":1,\"max_public_projects\":null,\"max_memberships_private_projects\":3,\"max_memberships_public_projects\":null,\"verified_email\":false,\"auth_token\":\"eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjo0ODEwNDN9:1lqGbb:OuqiKtEFeZGonN9-uGGgQMu-PHA\"}");
        assertTrue(homePage.isAvatarDisplayed(), "Login unsuccessful!!!");
    }

    @Test
    public void loginUnsuccessfulWithLocalStorage() {
        HomePage homePage = new HomePage();
        homePage.setItemInLocalStorage("token", "eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjo0ODEwffNDN9:1lqGbb:OuqiKtEFeZGonN9-uGGgQMu-PHA");
        homePage.setItemInLocalStorage("userInfo", "{\"id\":4HH81043,\"username\":\"artyomtest\",\"full_name\":\"Artyom Tonoyan\",\"full_name_display\":\"Artyom Tonoyan\",\"color\":\"#7111c2\",\"bio\":\"\",\"lang\":\"\",\"theme\":\"\",\"timezone\":\"\",\"is_active\":true,\"photo\":null,\"big_photo\":null,\"gravatar_id\":\"36e706fb7d67dc38504709498205717c\",\"roles\":[],\"total_private_projects\":0,\"total_public_projects\":0,\"email\":\"artyom.tonoyan@picsart.com\",\"uuid\":\"e4904d3eca7240338c501ab8afe8937b\",\"date_joined\":\"2021-06-07T14:30:06.299Z\",\"read_new_terms\":true,\"accepted_terms\":true,\"max_private_projects\":1,\"max_public_projects\":null,\"max_memberships_private_projects\":3,\"max_memberships_public_projects\":null,\"verified_email\":false,\"auth_token\":\"eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjo0ODEwNDN9:1lqGbb:OuqiKtEFeZGonN9-uGGgQMu-PHA\"}");
        assertFalse(homePage.isAvatarDisplayed(), "Login successful, but should be unsuccessful!!!");
    }

    @Test
    public void loginWithRightCredentialsByUI() {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername("artyomtest");
        loginPage.typePassword("artyomtest");
        loginPage.clickOnSubmitButton();
        assertTrue(loginPage.isLoginSuccessful(), "Login Unsuccessful!!!");
    }

    @Test
    public void loginWithWringCredentialsByUI() {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername("artyomtesttt");
        loginPage.typePassword("artyomtest");
        loginPage.clickOnSubmitButton();
        assertFalse(loginPage.isLoginSuccessful(), "Login successful, but should be unsuccessful!!!");
    }

    @Test
    public void loginWithCorrectUsernameAndWrongPasswordByUI() {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername("artyomtest");
        loginPage.typePassword("artyomtestttt");
        loginPage.clickOnSubmitButton();
        assertFalse(loginPage.isLoginSuccessful(), "Login successful, but should be unsuccessful!!!");
    }

    @Test
    public void loginWithWrongUsernameAndCorrectPasswordByUI() {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername("artyomtestttt");
        loginPage.typePassword("artyomtest");
        loginPage.clickOnSubmitButton();
        assertFalse(loginPage.isLoginSuccessful(), "Login successful, but should be unsuccessful!!!");
    }

    @Test
    public void loginWithEmptyCredentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername("");
        loginPage.typePassword("");
        loginPage.clickOnSubmitButton();
        assertFalse(loginPage.isLoginSuccessful(), "Login successful, but should be unsuccessful!!!");
    }

    public void loginWithAPI() throws IOException {

    }
}
