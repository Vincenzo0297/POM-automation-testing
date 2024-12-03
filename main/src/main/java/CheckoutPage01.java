import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage01 {
    private WebDriver driver;

    public CheckoutPage01(WebDriver driver) {
        this.driver = driver;
    }

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
    private By debitInput = By.id("debit");




    private By ccNameInput = By.id("cc-name");
    private By ccNumberInput = By.id("cc-number");
    private By ccExpirationInput = By.id("cc-expiration");
    private By ccCvvInputInput = By.id("cc-cvv");


    // New button for Continue to Checkout
    private By continueButton = By.cssSelector("button.btn.btn-primary.btn-lg");

    // Page actions
    public void enterFirstName(String firstName) {
        WebElement firstNameInputField = driver.findElement(firstNameInput);
        firstNameInputField.clear();
        firstNameInputField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameInputField = driver.findElement(lastNameInput);
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lastName);
    }

    public void enterUserName(String userName) {
        WebElement userNameInputField = driver.findElement(userNameInput);
        userNameInputField.clear();
        userNameInputField.sendKeys(userName);
    }

    public void enterEmail(String email) {
        WebElement emailInputField = driver.findElement(emailInput);
        emailInputField.clear();
        emailInputField.sendKeys(email);
    }

    public void enterAddress(String address) {
        WebElement addressInputField = driver.findElement(addressInput);
        addressInputField.clear();
        addressInputField.sendKeys(address);
    }

    public void enterAddress2(String address2) {
        WebElement address2InputField = driver.findElement(address2Input);
        address2InputField.clear();
        address2InputField.sendKeys(address2);
    }//Done




    // Select country by index
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

    public void enterzipInput(String zip) {
        WebElement zipInputField = driver.findElement(ZipInput);
        zipInputField.clear();
        zipInputField.sendKeys(zip);
    }




    // Click same address button
    public void clickSameAddressButton() {
        WebElement sameAddressButton = driver.findElement(sameAddressInput);
        sameAddressButton.click();
    }

    // Click same info button
    public void clickSameInfoButton() {
        WebElement sameInfoButton = driver.findElement(sameInfoInput);
        sameInfoButton.click();
    }

    // Click debit card button
    public void clickDebitButton() {
        WebElement debitButton = driver.findElement(debitInput);
        debitButton.click();
    }

    // Enter credit card name
    public void enterCcName(String ccName) {
        WebElement ccNameInputField = driver.findElement(ccNameInput);
        ccNameInputField.clear();
        ccNameInputField.sendKeys(ccName);
    }

    // Enter credit card number
    public void enterCcNumber(String ccNumber) {
        WebElement ccNumberInputField = driver.findElement(ccNumberInput);
        ccNumberInputField.clear();
        ccNumberInputField.sendKeys(ccNumber);
    }

    // Enter credit card expiration date
    public void enterCcExpiration(String ccExpiration) {
        WebElement ccExpirationInputField = driver.findElement(ccExpirationInput);
        ccExpirationInputField.clear();
        ccExpirationInputField.sendKeys(ccExpiration);
    }

    // Enter credit card CVV
    public void enterCcCvv(String ccCvv) {
        WebElement ccCvvInputField = driver.findElement(ccCvvInputInput);
        ccCvvInputField.clear();
        ccCvvInputField.sendKeys(ccCvv);
    }


    public void clickContinueButton() {
        WebElement submitButton = driver.findElement(continueButton);
        try {
            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
            // Wait for the button to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(submitButton));
            // Click
            submitButton.click();
        } catch (Exception e) {
            // Fall back to JavaScript click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
        }
    }

    // Check if invalid feedback is visible
    public boolean isInvalidFeedbackVisible() {
        List<WebElement> invalidFeedbackElements = driver.findElements(By.className("invalid-feedback"));
        boolean isVisible = false;
        for (WebElement element : invalidFeedbackElements) {
            if (element.isDisplayed()) {
                isVisible = true;
                break;
            }
        }
        if (!isVisible) {
            System.out.println("Checkpoint Passed: No visible 'invalid-feedback' elements found on the page.");
        } else {
            System.out.println("Checkpoint Failed: Visible 'invalid-feedback' elements found on the page.");
        }
        return isVisible;
    }

    // Wait for page load
    public void waitForLoad() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
//Completed