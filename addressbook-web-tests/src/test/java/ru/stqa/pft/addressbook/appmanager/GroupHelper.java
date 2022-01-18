package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
     super(wd);
    }

    public void returnToGroupPage() {
      click(By.linkText("group page"));
    }

    public void fillGroupForm(GroupData groupData) {
      type(By.name("group_name"), groupData.getName());
      type(By.name("group_header"), groupData.getHeader());
      type(By.name("group_footer"), groupData.getFooter());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void initGroupCreation() {
      click(By.name("new"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click(); //находтм все элементы по локатору Selected[]
    }

    public void deleteSelectedGroups() {
       click(By.xpath("//div[@id='content']/form/input[5]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.xpath("//input[@name='update']"));
    }

    public void createGroup(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group")); // найти все элементы которые имею тег span и класс group
        for (WebElement element: elements) { //этот веб элемент пробигает по списку элементов
            String name = element.getText(); // и из каждого такого элемента мы получаем текст
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData(id,null, null, name);
            groups.add(group); // добавляем объект в список

        }
        return groups;
    }
}
