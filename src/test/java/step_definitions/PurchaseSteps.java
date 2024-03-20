package step_definitions;

import hooks.Hooks;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.CheckoutPage;
import org.example.pageObject.InventoryPage;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.lang.annotation.Target;

public class PurchaseSteps {
    private final WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);


    @And("User click shopping cart badge")
    public void userClickShoppingButton(){
        checkoutPage.clickShopingButton();
    }


    @And("User remove Sauce Labs Bike Light from shopping cart")
    public void userRemoveFromShoppingCart() {
        checkoutPage.clickRemoveLabBikeLight();
    }


    @And("User click icon Checkout button")
    public void userClickIconCheckoutButton() {
        checkoutPage.clickCheckoutButton();
    }


    @Then("User redirected to checkout step on the page")
    public void userRedirectedToCheckoutStepOnThePage() {
        Assert.assertTrue(checkoutPage.verifyInfoCheckout());
    }


    @When("User input {string} as firstname {string} as lastname {string} as zipcode")
    public void userInputAsFirstnameAsLastnameAsZipcode(String firstName, String lastName, String zipCode) {
        checkoutPage.inputData(firstName, lastName, zipCode);
    }


    @And("User click continue button again")
    public void userClickContinueButtonAgain() {
        checkoutPage.clickContinueButton();
    }


    @Then("User will redirected to checkout overview next page")
    public void userWillRedirectedToCheckoutNextPage() {
        Assert.assertTrue(checkoutPage.verifyCheckoutOverview());
    }

    @When("User click again finish button")
    public void userClickAgainFinishButton() {
        checkoutPage.clickFinishButton();
    }


    @Then("User redirected to Checkout complete page")
    public void userRedirectedToCheckoutCompletePage() {
        Assert.assertTrue(checkoutPage.verifyThankYouForOrder());
    }

    @And("User can see summary total")
    public void userCanSeeSummaryTotal() { Assert.assertTrue(checkoutPage.verifySummaryTotal());
    }
}
