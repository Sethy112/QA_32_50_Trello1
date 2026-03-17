package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.Homepage;
import pages.LoginPage;
import utils.TestNGListener;
@Listeners(TestNGListener.class)

public class LoginTest extends AppManager {

    @Test(groups = "smoke")
    public void loginPositiveTest(){
        User user = User.builder()
                .email("a0538037302@gmail.com")
                .password("Qwertyzx123QA@")
                .build();
        logger.info("LOgin test with User"+ user.getEmail()+"  "+ user.getPassword());
        Homepage homepage= new Homepage(getDriver());
        homepage.clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Assert.assertTrue(new BoardsPage(getDriver()).validateUrl("boards"));
    }
}
