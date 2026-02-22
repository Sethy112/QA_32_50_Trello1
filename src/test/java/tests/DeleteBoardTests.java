package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.Homepage;
import pages.LoginPage;
import pages.MyBoardPage;

public class DeleteBoardTests extends AppManager {
    @BeforeMethod(alwaysRun = true)
    public void loginCreateBoard() {
        User user = User.builder()
                .email("a0538037302@gmail.com")
                .password("Qwertyzx123QA@")
                .build();
        Homepage homepage = new Homepage(getDriver());
        homepage.clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Board board = Board.builder().boardTitle("1112").build();
        new BoardsPage(getDriver()).createNewBoard(board);

    }
    @Test
    public  void deleteBoardPositiveTest(){
        new MyBoardPage(getDriver()).validateBoardName("2258", 5);
        new MyBoardPage(getDriver()).deleteBoard();
    }
}
