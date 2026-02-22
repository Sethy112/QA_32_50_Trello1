package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AtlassianProfilePage;
import pages.BoardsPage;
import pages.Homepage;
import pages.LoginPage;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ChangeProfilePhoto extends AppManager {
    BoardsPage boardsPage;

    @BeforeMethod
    public  void login(){
        User user = User.builder()
                .email("a0538037302@gmail.com")
                .password("Qwertyzx123QA@")
                .build();
        Homepage homepage= new Homepage(getDriver());
        homepage.clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());

    }
    @Test
    public void changeProfilePhoto(){
        boardsPage.openMyAccount();
        List<String> tabs =new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1));
        AtlassianProfilePage atlassianProfilePage =new AtlassianProfilePage
                (getDriver());
        atlassianProfilePage.changeMyProfilePhoto
                ("src/main/resources/image.jpg");
        Assert.assertTrue(atlassianProfilePage.validateMessage
                ("We've uploaded your new avatar. It may take a few minutes to display everywhere."));

    }
    @Test
    public  void changeProfilePhotoNegativeWrongFormatFile(Method method) {
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1));
        AtlassianProfilePage atlassianProfilePage = new AtlassianProfilePage
                (getDriver());
        atlassianProfilePage.changeMyProfilePhoto
                ("src/main/resources/Board1.csv");
        logger.info("upload file .csv -->" + method.getName());
        Assert.assertTrue(atlassianProfilePage.validateWrongFormatFileMessage
                ("Upload a photo or select from some default options"));
    }
}