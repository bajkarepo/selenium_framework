package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class TopMenuPage extends BasePage {

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    WebElement signonForm;

    public LoginPage clickOnSignInLink() {
        WaitForElement.waitUntilElementIsClickable(signonForm);
        signonForm.click();
        log().info("click on sign on Link");
        return new LoginPage();
    }
}
