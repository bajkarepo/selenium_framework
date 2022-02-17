package page.objects;

import generic.assertions.AssertWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class FooterPage extends BasePage {

    @FindBy(css = "#Banner img[src*='dog']")
    WebElement bannerAfterLoginLogo;

    private WebDriver driver;

    public FooterPage isBannerAfterLoginDisplayed() {
        log().info("Checking if dog banner is displayed");
        WaitForElement.waitUntilElementIsVisible(bannerAfterLoginLogo);
        AssertWebElement.assertThat(bannerAfterLoginLogo).isDisplayed();
        return this;
    }

}
