package TC;
import base.loader;
import io.qameta.allure.*;
import pages.product;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class tc9 extends basictc {
	 static String search;

	    static {
	        try {
	            search = loader.loadProperty("search.product.input");
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    @Test(description = "tc 9: Search Product")
	    @Severity(SeverityLevel.CRITICAL)
	    @Story("Search Product")
	    @Description("""
	            1. Launch browser
	            2. Navigate to url 'http://automationexercise.com'
	            3. Verify that home page is visible successfully
	            4. Click on 'Products' button
	            5. Verify user is navigated to ALL PRODUCTS page successfully
	            6. Enter product name in search input and click search button
	            7. Verify 'SEARCHED PRODUCTS' is visible
	            8. Verify all the products related to search are visible""")
	    public void searchProduct() {
	        tc1.verifyThatHomePageIsVisibleSuccessfully();
	        tc8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
	        verifySearchedProductsIsVisible();
	        verifyAllTheProductsRelatedToSearchAreVisible();
	    }

	    @Step("Verify 'SEARCHED PRODUCTS' is visible")
	    public static void verifySearchedProductsIsVisible() {
	        String searchedProductsText = new product(getDriver())
	                .fillSearchProductInput(search)
	                .getTitleTextCenter()
	                .getText();
	        Assert.assertEquals(searchedProductsText, "SEARCHED PRODUCTS", "Verify 'SEARCHED PRODUCTS' is visible");
	    }

	    @Step("Verify all the products related to search are visible")
	    public static List<String> verifyAllTheProductsRelatedToSearchAreVisible() {
	        List<String> productsNames = new product(getDriver()).getProductsSearchNames();

	        for (int i = 0; i < productsNames.size(); i++) {
	            Assert.assertTrue(productsNames.get(i).toLowerCase().contains(search.toLowerCase()));
	            System.out.println(i + ". " + productsNames.get(i) + " - contain: " + search);
	        }
	        return productsNames;
	    }
}
