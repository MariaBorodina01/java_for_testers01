import manager.ApplicationManager;
import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        app.openGroupsPage();
        app.createGroup(new GroupData("group name", "group header", "group footer"));

    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.openGroupsPage();
        ApplicationManager.driver.findElement(By.linkText("groups")).click();
        app.createGroup(new GroupData());
    }

    @Test
    public void canCreateGroupWithName() {
        app.openGroupsPage();
        ApplicationManager.driver.findElement(By.linkText("groups")).click();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        app.createGroup(groupWithName);
    }
}
