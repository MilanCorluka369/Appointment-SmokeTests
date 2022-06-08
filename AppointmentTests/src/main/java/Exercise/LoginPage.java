package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private By makeAppointment = By.id("btn-make-appointment");
    private By usernameInput = By.xpath
            ("//*[@id=\"login\"]/div/div/div[2]/form/div[1]/div[1]/div/div/input");
    private By passwordInput = By.xpath
            ("//*[@id=\"login\"]/div/div/div[2]/form/div[1]/div[2]/div/div/input");
    private By username = By.id("txt-username");
    private By password = By.id("txt-password");
    private By loginButton = By.id("btn-login");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    //////////////// CREDITENTIALS /////////////////
    public String takeDemoUsername () {
        return getDriver().findElement(usernameInput).getAttribute("value");
    }

    public String takeDemoPassword () {
        return getDriver().findElement(passwordInput).getAttribute("value");
    }

    public void enterDemoUsername () {
        getDriver().findElement(username).sendKeys(takeDemoUsername());
    }

    public void enterDemoPassword () {
        getDriver().findElement(password).sendKeys(takeDemoPassword());
    }

    ////////////////// CLICKS ///////////////////
    public void enterLoginPage() {
        getDriver().findElement(this.makeAppointment).click();
    }

    public boolean isLoginButtonEnabled(){
        return getDriver().findElement(loginButton).isEnabled();
    }

    public void clickLogin() {
        if(isLoginButtonEnabled())
            getDriver().findElement(loginButton).click();
    }

    ////////////// LOGIN ////////////////
    public void login () {
        enterLoginPage();
        clearField(this.username);
        enterDemoUsername();
        clearField(this.password);
        enterDemoPassword();
        clickLogin();
    }
}