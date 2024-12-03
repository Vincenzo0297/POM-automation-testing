import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class MySeleniumPOMProject01 {
    private WebDriver driver;
    private CheckoutPage01 checkoutPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        checkoutPage = new CheckoutPage01(driver);
    }

    @Test
    public void testDebitCard() throws InterruptedException {
        driver.get("https://getbootstrap.com/docs/5.3/examples/checkout/");

        // Use Page Object methods to interact with the page
        checkoutPage.enterFirstName("John");
        checkoutPage.enterLastName("Doe");
        checkoutPage.enterUserName("Johnnyboy");
        checkoutPage.enterEmail("john.doe@example.com");
        checkoutPage.enterAddress("123 Elm Street");
        checkoutPage.enterAddress2("Apt 4B");
        //Done

        checkoutPage.selectCountryByIndex();
        checkoutPage.stateDropdown();
        checkoutPage.enterzipInput("321");


// Interact with checkboxes
        checkoutPage.clickSameAddressButton();
        checkoutPage.clickSameInfoButton();
        checkoutPage.clickDebitButton();



        // Fill credit card details
        checkoutPage.enterCcName("John Doe");
        checkoutPage.enterCcNumber("4111111111111111");
        checkoutPage.enterCcExpiration("12/26");
        checkoutPage.enterCcCvv("321");
        // Click on the Continue to Checkout button
        checkoutPage.clickContinueButton();




        // Optional: Add waiting for page load if necessary
        checkoutPage.waitForLoad();

        // Check if any 'invalid-feedback' elements are visible
        assertFalse(checkoutPage.isInvalidFeedbackVisible());

        // Add more assertions or actions as required for your test
    }

    @Test
    public void testCreditCard() throws InterruptedException {
        driver.get("https://getbootstrap.com/docs/5.3/examples/checkout/");

        // Use Page Object methods to interact with the page
        checkoutPage.enterFirstName("John");
        checkoutPage.enterLastName("Doe");
        checkoutPage.enterUserName("Johnnyboy");
        checkoutPage.enterEmail("john.doe@example.com");
        checkoutPage.enterAddress("123 Elm Street");
        checkoutPage.enterAddress2("Apt 4B");


        checkoutPage.selectCountryByIndex();
        checkoutPage.stateDropdown();
        checkoutPage.enterzipInput("321");

        checkoutPage.clickSameAddressButton();
        checkoutPage.clickSameInfoButton();
        checkoutPage.clickDebitButton();


        checkoutPage.enterCcName("John Doe");
        checkoutPage.enterCcNumber("4111111111111111");
        checkoutPage.enterCcExpiration("12/26");
        checkoutPage.enterCcCvv("123");
        checkoutPage.clickContinueButton();




        // Optional: Add waiting for page load if necessary
        checkoutPage.waitForLoad();

        // Check if any 'invalid-feedback' elements are visible
        assertFalse(checkoutPage.isInvalidFeedbackVisible());

        // Add more assertions or actions as required for your test
    }

    @After
    public void tearDown() {

    }
}
//Completed