import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage00 {
    private WebDriver driver;

    public CheckoutPage00(WebDriver driver) {
        this.driver = driver;
    }

    // Declaration
    // Page elements
    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");
    private By userNameInput = By.id("username");
    private By emailInput = By.id("email");
    private By addressInput = By.id("address");
    private By address2Input = By.id("address2");

    // Dropdowns
    private By countryDropdown = By.id("country");
    private By stateDropdown = By.id("state");
    private By ZipInput = By.id("zip");



    //Button
    private By sameAddressInput = By.id("same-address");
    private By sameInfoInput = By.id("save-info");
    private By DebitInput = By.id("debit");




    private By ccNameInput = By.id("cc-name");
    private By ccNumberInput = By.id("cc-number");
    private By ccExpirationInput = By.id("cc-expiration");
    private By ccCvvInputInput = By.id("cc-cvv");



    // New button for Continue to Checkout
    private By continueButton = By.cssSelector("button.btn.btn-primary.btn-lg");


    // Page actions
    public void enterFirstName(String firstName){
        driver.findElement(firstNameInput).sendKeys(firstName);
        waitForLoad();
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        waitForLoad();
    }

    public void enterUserName(String userName) {
        driver.findElement(userNameInput).sendKeys(userName);
        waitForLoad();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        waitForLoad();
    }

    public void enterAddress(String address){
        driver.findElement(addressInput).sendKeys(address);
        waitForLoad();
    }

    public void enterAddress2(String address2){
        driver.findElement(address2Input).sendKeys(address2);
        waitForLoad();
    }

    //Done



    public void selectCountryByIndex() throws InterruptedException {
        WebElement countryDropdownElement = driver.findElement(countryDropdown);
        Select dropdown = new Select(countryDropdownElement);
        dropdown.selectByIndex(1); // Selection value
        System.out.println(dropdown.getFirstSelectedOption().getText()); // Print selected option
        waitForLoad();
    }

    public void stateDropdown() throws InterruptedException {
        WebElement countryDropdownElement = driver.findElement(stateDropdown);
        Select dropdown = new Select(countryDropdownElement);
        dropdown.selectByIndex(1); // Selection value
        System.out.println(dropdown.getFirstSelectedOption().getText()); // Print selected option
        waitForLoad();
    }

    public void ZipInput(String zip){
        driver.findElement(ZipInput).sendKeys(zip);
        waitForLoad();
    }

    //Done



    public void clickSameAddressButton() {
        driver.findElement(sameAddressInput).click();
        waitForLoad();
    }

    public void clickSameInfoButton() {
        driver.findElement(sameInfoInput).click();
        waitForLoad();
    }

    public void clickdebitButton() {
        driver.findElement(DebitInput).click();
        waitForLoad();
    }

    //Done



    public void enterCcName(String ccName) {
        driver.findElement(ccNameInput).sendKeys(ccName);
        waitForLoad();
    }

    public void enterCcNumber(String ccNumber) {
        driver.findElement(ccNumberInput).sendKeys(ccNumber);
        waitForLoad();
    }

    public void enterCcExpiration(String ccExpiration) {
        driver.findElement(ccExpirationInput).sendKeys(ccExpiration);
        waitForLoad();
    }

    public void enterCcCvv(String ccCvv) {
        driver.findElement(ccCvvInputInput).sendKeys(ccCvv);
        waitForLoad();
    }

    //Done



    // New method to click the continue button
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
        waitForLoad();
    }





    public void waitForLoad() {
        try {
            Thread.sleep(1000); // Simulate delay for loading elements
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

//completed