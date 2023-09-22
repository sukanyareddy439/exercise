package TC;
import pages.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tc8 extends basictc {
	 @Test(description = "Test Case 8: Verify All Products and product detail page")
	    @Severity(SeverityLevel.CRITICAL)
	    @Story("Verify All Products and product detail page")
	    @Description("""
	            1. Launch browser
	            2. Navigate to url 'http://automationexercise.com'
	            3. Verify that home page is visible successfully
	            4. Click on 'Products' button
	            5. Verify user is navigated to ALL PRODUCTS page successfully
	            6. The products list is visible
	            7. Click on 'View Product' of first product
	            8. User is landed to product detail page
	            9. Verify that detail detail is visible: product name, category, price, availability, condition, brand""")
	    public void verifyAllProductsAndProductDetailPage() {
	        tc1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyUserIsNavigatedToAllProductsPageSuccessfully();
	        new product(getDriver()).viewProductOfFirstProductButtonClick();
	        verifyThatDetailDetailIsVisible();
	    }

	    @Step("Verify user is navigated to ALL PRODUCTS page successfully")
	    public static void verifyUserIsNavigatedToAllProductsPageSuccessfully() {
	        String allProductsText =  new HomePage(getDriver())
	                .productsButtonClick()
	                .getTitleTextCenter()
	                .getText();
	        Assert.assertEquals(allProductsText, "ALL PRODUCTS", "Verify user is navigated to ALL PRODUCTS page successfully");
	    }

	    @Step("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
	    private void verifyThatDetailDetailIsVisible() {
	        boolean name = new productdetial(getDriver()).getProductName().isDisplayed();
	        boolean category = new productdetial(getDriver()).getProductCategory().isDisplayed();
	        boolean price = new productdetial(getDriver()).getProductPrice().isDisplayed();
	        boolean availability = new productdetial(getDriver()).getProductAvailability().isDisplayed();
	        boolean condition = new productdetial(getDriver()).getProductCondition().isDisplayed();
	        boolean brand = new productdetial(getDriver()).getProductBrand().isDisplayed();

	        Assert.assertTrue(name, "Verify that detail detail is visible: name");
	        Assert.assertTrue(category, "Verify that detail detail is visible: category");
	        Assert.assertTrue(price, "Verify that detail detail is visible: price");
	        Assert.assertTrue(availability, "Verify that detail detail is visible: availability");
	        Assert.assertTrue(condition, "Verify that detail detail is visible: condition");
	        Assert.assertTrue(brand, "Verify that detail detail is visible: brand");
	    }
}
