package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData groupData) {
        type(By.name("firstname"), groupData.getFirstName());
        type(By.name("middlename"), groupData.getMiddleName());
        type(By.name("lastname"), groupData.getLastName());
        type(By.name("nickname"), groupData.getNickName());
    }
}
