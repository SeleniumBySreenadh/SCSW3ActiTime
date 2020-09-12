package com.actiTime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actiTime.POM.HomePage;
import com.actiTime.POM.TaskListPage;
import com.actiTime.generics.BaseClass;

public class CreateCustomer extends BaseClass{
@Test
public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
 String customername = f.getExcelValue("CreateCustomer", 1, 0);
 String customerDescp = f.getExcelValue("CreateCustomer", 1, 1);
 HomePage h=new HomePage(driver);
 h.clickTaskTab();
 TaskListPage t=new TaskListPage(driver);
 t.getAddNewBtn().click();
 t.getNewCustomerMenu().click();
 t.getEnterNewCustomertbx().sendKeys(customername);
 t.getEnterCustomerdescriptionTbx().sendKeys(customerDescp);
 t.getProjectDropDown().click();
 t.getOurCompanyMenu().click();
 t.getCreateCustomerBtn().click();
 Thread.sleep(7000);//we have explict wait here
 String ActualText = t.getActualCustomerCreated().getText(); 
 Assert.assertEquals(ActualText, customername);
}
}
