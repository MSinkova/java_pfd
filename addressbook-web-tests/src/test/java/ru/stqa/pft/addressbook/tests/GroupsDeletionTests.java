package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupsDeletionTests extends TestBase{

  @Test
  public void testGroupsDeletionTests() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test4", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1); //что-бы сравнить списки необходимо лишний элемент удалить, который мы удалили в тестируемом приложении
    //проверить совпадение элементов с использованием цикла
    for (int i = 0; i < before.size() - 1; i++) {
      Assert.assertEquals(before.get(i), after.get(i)); //сравниваем два элемента с одинаковыми индексами
    }
  }
}
