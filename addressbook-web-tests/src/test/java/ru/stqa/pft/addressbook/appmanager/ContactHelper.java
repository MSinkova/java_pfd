package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
      super(wd);
    }

    public void submitContactCreation() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData) {
      type(By.name("firstname"),contactData.firstname());
      type(By.name("middlename"),contactData.middlename());
      type(By.name("lastname"),contactData.lastname());
      type(By.name("home"),contactData.home());
      type(By.name("mobile"),contactData.mobile());
      type(By.name("mobile"),contactData.mobile());
      type(By.name("email"),contactData.email());
      type(By.name("email2"),contactData.email2());
      click(By.name("bday"));
      click(By.name("bmonth"));
      type(By.name("byear"),contactData.byear());
      type(By.name("address2"),contactData.address2());
      type(By.name("phone2"),contactData.phone2());
    }

    public void initContactCreation() {
      click(By.linkText("add new"));
    }

    public void goToContactPage() {
      click(By.id("logo"));
    }

    public void deleteSelectedContacts() {
      click(By.xpath("//input[@value='Delete']"));
      wd.switchTo().alert().accept();
    }

    public void selectContact() {
      click(By.id("MassCB"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }
}
