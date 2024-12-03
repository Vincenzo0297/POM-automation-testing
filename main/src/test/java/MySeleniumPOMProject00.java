import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class MySeleniumPOMProject00 {
    private WebDriver driver;
    private CheckoutPage00 checkoutPage00;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        checkoutPage00 = new CheckoutPage00(driver);
    }

    @Test
    public void testFormFilling() throws InterruptedException {
        driver.get("https://getbootstrap.com/docs/5.3/examples/checkout/");

        // Use Page Object methods to interact with the page
        // Fill form fields
        checkoutPage00.enterFirstName("John");
        checkoutPage00.enterLastName("Doe");
        checkoutPage00.enterUserName("Johnnyboy");
        checkoutPage00.enterEmail("john.doe@example.com");
        checkoutPage00.enterAddress("123 Elm Street");
        checkoutPage00.enterAddress2("Apt 4B");
        //Done



        //Drop Down Interaction
        checkoutPage00.selectCountryByIndex();
        checkoutPage00.stateDropdown();
        checkoutPage00.ZipInput("369");


        // Interact with checkboxes
        checkoutPage00.clickSameAddressButton();
        checkoutPage00.clickSameInfoButton();
        checkoutPage00.clickdebitButton();




        // Fill credit card details
        checkoutPage00.enterCcName("John Doe");
        checkoutPage00.enterCcNumber("4111111111111111");
        checkoutPage00.enterCcExpiration("12/16");
        checkoutPage00.enterCcCvv("123");



        // Click on the Continue to Checkout button
        checkoutPage00.clickContinueButton();


        assertEquals("Checkout example · Bootstrap v5.3", driver.getTitle());

        // Optional: Add waiting for page load if necessary
        checkoutPage00.waitForLoad();


        // You can add more assertions or actions as required for your test
    }

    @After
    public void tearDown() {

    }
}
//completed