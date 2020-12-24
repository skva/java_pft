package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("test1").withMiddlename("test1").withLastname("test1").withNickname("test1").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactModification() throws Exception {
        app.goTo().contactPage();
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData()
                .withId(before.get(index).getId()).withFirstname("test1").withMiddlename("test1").withLastname("test1").withNickname("test1");
        app.contact().modify(before, index, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        //удаляем из списка последний элемент и добавляем тот, который добавили
        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}