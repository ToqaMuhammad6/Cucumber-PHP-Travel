package travel.site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import travel.site.base.BasePage;

import java.time.Duration;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    private final By customerNavBar = By.xpath("//a[.//span[normalize-space()='Customer']]");

    private final By signUpOption = By.cssSelector("a[href='https://phptravels.net/signup']");

    private final By cookieDisclaimer = By.id("cookie_disclaimer");

    private final By hideOption = By.id("cookie_stop");

    private final By firstNameInput = By.id("firstname");

    private final By lastNameInput = By.id("last_name");

    private final By countryMenu = By.cssSelector("button.dropdown-toggle");

    private final By searchOnCountry = By.cssSelector("input[aria-label='Search']");

    private final By countryEgypt = By.cssSelector("a.dropdown-item img[src*='eg.svg']");

    private final By phoneNumberInput = By.cssSelector("input#phone");

    private final By emailInput = By.id("user_email");

    private final By passwordInput = By.id("password");

    private final By frameOfCaptcha = By.xpath("//*[@id=\"signup\"]/div/div/div/div[6]/div/iframe");

    private final By checkBox = By.xpath("//*[@id=\"checkbox\"]");

    private final By signUpButton = By.id("submitBTN");

    public void goToSignUp(){
        driver.findElement(customerNavBar).click();
        driver.findElement(signUpOption).click();
    }

    public void hideCookieBar(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement cookieBanner = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(cookieDisclaimer)
            );
            WebElement hideBtn = cookieBanner.findElement(hideOption);
            hideBtn.click();
            wait.until(ExpectedConditions.invisibilityOf(cookieBanner));
        } catch (TimeoutException e) {
        }
    }

    public void firstName(String firstname){
        driver.findElement(firstNameInput).sendKeys(firstname);
    }

    public void lastName(String lastname){
        driver.findElement(lastNameInput).sendKeys(lastname);
    }

    public void selectCountry(String country){
        driver.findElement(countryMenu).click();
        driver.findElement(searchOnCountry).sendKeys(country);
        driver.findElement(countryEgypt).click();
    }

    public void phoneNumber(String phone){
        driver.findElement(phoneNumberInput).sendKeys(phone);
    }

    public void emailField(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void passwordField(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void captchaFrame(){
        WebElement captchaFrame= driver.findElement(frameOfCaptcha);
        driver.switchTo().frame(captchaFrame);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.attributeToBe(
                checkBox, "aria-checked", "true"
        ));
        driver.switchTo().defaultContent();
    }

    public void clickSignUp(){
        driver.findElement(signUpButton).click();
    }

    public String failSignUp(){
        driver.findElement(signUpButton).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(emailInput);
        return driver.switchTo().activeElement().getAttribute("outerHTML");
    }

    public String getURl(){
        return driver.getCurrentUrl();

    }




}
