package tests;

import manager.ApplicationManager;
import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        TestBase.app.groups().createGroup(new GroupData("group name", "group header", "group footer"));

    }

    @Test
    public void canCreateGroupWithEmptyName() {
//        ApplicationManager.driver.findElement(By.linkText("groups")).click();
        TestBase.app.groups().createGroup(new GroupData());
    }

    @Test
    public void canCreateGroupWithName() {
//        ApplicationManager.driver.findElement(By.linkText("groups")).click();
        TestBase.app.groups().createGroup(new GroupData().withName("some name"));
    }
}
