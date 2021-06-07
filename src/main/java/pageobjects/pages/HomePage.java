package pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.BasePage;
import utils.WaitHelper;

public class HomePage extends BasePage {

    @FindBy(css = "[tg-dropdown-user='tg-dropdown-user']")
    private WebElement avatar;

    public HomePage() {
        open(BASE_URL);
        PageFactory.initElements(driver, this);
    }

    public boolean isAvatarDisplayed() {
        try {
            WaitHelper.getInstance().waitForElementToDisplayed(avatar);
            return true;
        } catch (Error error) {
            return false;
        }
    }

    @Override
    public String getURL() {
        return BASE_URL;
    }
}
