package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToContactPage() {
        click(By.linkText("home"));
    }

    public void modify(List<ContactData> before, int index, ContactData contact) {
        selectContact(index);
        modify(before.size());
        fillContactForm(contact, false);
        submitContactModification();
        returnToContactPage();
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContacts();
        alert();
        returnToContactPage();
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void modify(int index) {
        click(By.xpath("(//img[@alt='Edit'])[" + index + "]"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void selectContact (int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void create(ContactData contact, boolean creation) {
        initContactCreation();
        fillContactForm(contact, creation);
        submitContactCreation();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String firstname = element.findElement(By.xpath(".//td[2]")).getText();
            String lastname = element.findElement(By.xpath(".//td[3]")).getText();
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return contacts;
    }

    //задублировал этот метод из ApplicationManager для метода delete(). Не знаю, как сослаться на него в другом классе
    public void alert() {
        wd.switchTo().alert().accept();
    }
}

