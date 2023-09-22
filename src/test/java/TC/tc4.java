package TC;
import base.Base;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import java.io.IOException;

public class tc4 extends basictc {
	 @Test(description = "tc 4: Logout User")
	    @Severity(SeverityLevel.CRITICAL)
	    @Story("Logout User")
	    @Description("""
	            1. Launch browser
	            2. Navigate to url 'http://automationexercise.com'
	            3. Verify that home page is visible successfully
	            4. Click on 'Signup / Login' button
	            5. Verify 'Login to your account' is visible
	            6. Enter correct email address and password
	            7. Click 'login' button
	            8. Verify that 'Logged in as username' is visible
	            9. Click 'Logout' button
	            10. Verify that user is navigated to login page""")
	    public void logoutUser() throws IOException, ParseException {
	        tc2.loginUserWithCorrectEmailAndPassword();
	        verifyThatUserIsNavigatedToLoginPage();
	    }

	    @Step("Verify that user is navigated to login page")
	    private void verifyThatUserIsNavigatedToLoginPage() {
	        String loginToYourAccountText = new LoggedHomePage(getDriver())
	                .logoutButtonClick()
	                .getLoginToYourAccount()
	                .getText();
	        Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify that user is navigated to login page");
	    }
}
