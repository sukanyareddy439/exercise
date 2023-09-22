package TC;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
public class tc7 extends basictc {
	 @Test(description = "tc 7: Verify Test Cases Page")
	    @Severity(SeverityLevel.TRIVIAL)
	    @Story("Verify Test Cases Page")
	    @Description("""
	            1. Launch browser
	            2. Navigate to url 'http://automationexercise.com'
	            3. Verify that home page is visible successfully
	            4. Click on 'Test Cases' button
	            5. Verify user is navigated to test cases page successfully""")
	    public void verifyTestCasesPage() {
	        tc1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyUserIsNavigatedToTestCasesPageSuccessfully();
	    }

	    @Step("Verify user is navigated to test cases page successfully")
	    private void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
	        String testCasesText = new HomePage(getDriver())
	                .testCasesButtonClick()
	                .getTestCases()
	                .getText();
	        Assert.assertEquals(testCasesText, "TEST CASES", "Verify user is navigated to test cases page successfully");
	    }
}
