import com.opt.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 10/17/2017.
 */
public class CreateForumPostTest extends RegisterTest{
    @Test(priority=3)
    public void CreateForumPost() throws InterruptedException {
        CreateProgramPage programPage = new CreateProgramPage(driver);
        programPage.waitForForumButtonToLoad();
        ForumSetupPageObject forumPage = programPage.openForum();
        //Setup signature, nickname
        forumPage.waitForForumSetup();
        long Random = Math.round(Math.random() * 1357987.0D);
        String nickname = "Smokey Robot " + Random;
        forumPage.setupForumAccount(nickname, "Please ignore,\n Mr.Smokey");
        forumPage.submitAccountDetails();
        String actualMsg = forumPage.getMessage();
        String expectedMsg = "Forum profile was successfully saved!";
        Assert.assertTrue(actualMsg.equals(expectedMsg), "Messages do not match ! \nExpected: " + expectedMsg + "\nActual: " + actualMsg);
        System.out.println("Changes saved successfully !");
        ForumPageObject forum = forumPage.openForum();
        forum.waitForPageToLoad();
        forum.clickHelpTopic();
        forum.waitForPageToLoad();
        forum.clickNewTopic();
        forum.waitForNewTopicPageToLoad();
        forum.typeTitle("This is written by Mr Smokie your friendly robot");
        forum.typeDescription();
        forum.submitPost();
        forum.waitForPageToLoad();
        String expectedPost = "[Starting out with OPTIFAST® VLCD™]: This is written by Mr Smokie your friendly robot";
        String actualPost = forum.getPostHeaderText();
        Assert.assertTrue(expectedPost.equals(actualPost), "Post text doesn't match, \nExpected: " + expectedPost + "\nActual: " + actualPost);
        System.out.println("Post is correct ! \nExpected: " + expectedPost + "\nActual: " + actualPost);
    }
}
