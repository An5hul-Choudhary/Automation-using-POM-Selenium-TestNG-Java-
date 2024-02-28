import BaseTest.BaseTest;
import org.Netcracker.pageObjects.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;


public class StandAloneTest extends BaseTest{

    @Test
    public void TriplePlay() throws InterruptedException {

        // CSR Login
        String userName = "csr";
        String userPassword = "netcracker";
        AddressCheckPage addressCheck = loginPage.loginApplication(userName, userPassword);

        // Address Check
        CustomerCreation customerIs = addressCheck.checkAddress(BaseTest.addressId);

        // Customer Creation
        String fName = "Ansh";
        SelectPage selectPage = customerIs.creationOfCustomer(fName);

        //Select Page
        Thread.sleep(18000);
        CustomizePage customizePage = selectPage.addPlans();
        Thread.sleep(7000);

        //customize page
        customizePage.hsiaCustomize();
        customizePage.tvCustomize();
        EquipmentPage equipmentPage = customizePage.hpCustomize();

        //equipment page
        equipmentPage.hsiaEquipmentPage();
        equipmentPage.tvEquipmentPage();
        AppointmentPage appointmentPage = equipmentPage.addOnEquipmentPage();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Appointment page
        ContactPage contactPage = appointmentPage.selectingAppointment();

        //Contact Page
        PickADate pickADate= contactPage.addingContact();

        // Pick a date page
        ReviewOrderPage reviewOrderPage = pickADate.appointmentSelection();

        // Review order
        TSSPage tssPage = reviewOrderPage.acceptTnC();

        //Checkout TSS page
       ShippingPage shippingPage = tssPage.tssNo();

        //Shipping Information page
        BillingInfoPage billingInfoPage = shippingPage.shipInfo();

        //Checkout Billing information page
        SubmittedOrder submittedOrder = billingInfoPage.billDetails();

        // Order submitted
        submittedOrder.orderSubmitCheck();

    }


}


