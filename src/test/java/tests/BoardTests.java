package tests;

import data_providers.BoardDP;
import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class BoardTests extends AppManager {

    @BeforeMethod(alwaysRun = true)
    public  void login(){
        User user = User.builder()
                .email("a0538037302@gmail.com")
                .password("Qwertyzx123QA@")
                .build();
        Homepage homepage= new Homepage(getDriver());
        homepage.clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }

    @Test
    public void createNewBoardPositiveTest(){
        Board board = Board.builder().boardTitle("2258").build();
        new BoardsPage(getDriver()).createNewBoard(board);
        new MyBoardPage(getDriver()).validateBoardName("2258",5);
    }

    @Test
    public void  chek(){
        new BoardsPage(getDriver()).openMyAccount();
    }



    @Test(dataProvider = "dataProviderBoards",dataProviderClass = BoardDP.class)
    public void createNewBoardPositiveTest_FromDP(Board board){
        new BoardsPage(getDriver()).createNewBoard(board);
    }
}
