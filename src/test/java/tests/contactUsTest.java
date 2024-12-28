package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class contactUsTest extends TestBase{
    HomePage homePage;
    ContactUsPage contactUsPage;

    String email ="karemali1@gmail.com";
    String fullName ="kareem Ali";
    String enquiry ="Hello every body....";

    @Test
    public void UserCanUseContactUs()
    {
        homePage =new HomePage(driver);
        homePage.openContactUsPage();
        contactUsPage =new ContactUsPage(driver);
        contactUsPage.contactUS(fullName,email,enquiry);
        Assert.assertTrue(contactUsPage.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));

    }

}
