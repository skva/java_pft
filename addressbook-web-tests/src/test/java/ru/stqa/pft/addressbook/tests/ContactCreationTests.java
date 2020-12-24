package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;


public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().contactPage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("test1").withMiddlename("test1").withLastname("test1").withNickname("test1").withGroup("test1");
    app.contact().create(contact, true);
    app.goTo().contactPage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
