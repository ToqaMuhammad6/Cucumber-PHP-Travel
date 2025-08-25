package travel.site.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import travel.site.factory.DriverFactory;
import travel.site.pages.RegistrationPage;

import java.time.Duration;

public class RegistrationSteps {
    WebDriver driver;
    RegistrationPage registrationPage;





    @Given("User is at the signup page")
    public void userIsAtTheSignUpPage(){
        //DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        registrationPage = new RegistrationPage(driver);
        registrationPage.load("https://phptravels.net/");
        registrationPage.goToSignUp();
    }

    @And("User handle the cookies banner")
    public void handleCookieBanner() {
        registrationPage.hideCookieBar();
    }

    @When("^User fill the first name \"(.*)\"$")
    public void userFillTheFirstName(String firstNameField){
        registrationPage.firstName(firstNameField);
    }
    @And("^User fill the last name \"(.*)\"$")
    public void userFillTheLastName( String lastNameField){
        registrationPage.lastName(lastNameField);
    }

    @And("^User select the country \"(.*)\"$")
    public void userSelectTheCountry(String countryEg){

        registrationPage.selectCountry(countryEg);
    }

    @And("^User fill the phone field \"(.*)\"$")
    public void userFillThePhoneField( String phoneNum){
        registrationPage.phoneNumber(phoneNum);
    }


    @And("^User add an email address \"(.*)\"$")
    public void userAddAnEmail(String emailInput){
        registrationPage.emailField(emailInput);
    }


    @And("^User add a password \"(.*)\"$")
    public void userAddPassword(String passwordInput){

        registrationPage.passwordField(passwordInput);
    }

    @And("User solve the captcha")
    public void userSolveTheCaptcha() {

        registrationPage.captchaFrame();
    }

    @Then("User click on the signup button")
    public void userClickTheSignupButton(){
        registrationPage.clickSignUp();
    }

    @Then("User can't click on the signup button")
    public void userCantProceed(){

        String activeElement= registrationPage.failSignUp();
        Assert.assertTrue(activeElement.contains("input") && activeElement.contains("email"),
                "Expected email field to be focused after invalid signup, but focus is on: " + activeElement);


    }




    @And("User is logged in")
    public void userIsLoggedIn() throws InterruptedException {
        String expectedUrl = "https://phptravels.net/signup_success";

        Thread.sleep(6000);



        String actualUrl = registrationPage.getURl();
        Assert.assertEquals(actualUrl, expectedUrl);



    }

    @And("User still in home page")
    public void userIsOnHomePAge() throws InterruptedException {
        String expectedUrl = "https://phptravels.net/signup";

        Thread.sleep(6000);



        String actualUrl = registrationPage.getURl();
        Assert.assertEquals(actualUrl, expectedUrl);



    }
}
