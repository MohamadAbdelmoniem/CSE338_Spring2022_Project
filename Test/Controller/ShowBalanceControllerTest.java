package Controller;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ShowBalanceControllerTest {
    @Test
    public void test1() throws SQLException {
        ShowBalanceController test1 = new ShowBalanceController();
        test1.AccountNumber="17112000";
        LoginController.Flag="17112000";
        assertEquals("5700",test1.BalanceMessageOnAction());
    }
    @Test
    public void test2() throws SQLException {
        ShowBalanceController test2 = new ShowBalanceController();
        test2.AccountNumber="1111111";
        LoginController.Flag="17112000";
        assertEquals("Please enter correct ID", test2.BalanceMessageOnAction());
    }
    @Test
    public void test3() throws SQLException {
        ShowBalanceController test3 = new ShowBalanceController();
        test3.AccountNumber="";
        LoginController.Flag="17112000";
        assertEquals("please make sure you entered all data fields", test3.BalanceMessageOnAction());
    }
    @Test
    public void test4() throws SQLException {
        ShowBalanceController test1 = new ShowBalanceController();
        test1.AccountNumber="1111111";
        LoginController.Flag="17112000";
        assertEquals("Please enter correct ID", test1.BalanceMessageOnAction());
        ShowBalanceController test2 = new ShowBalanceController();
        test2.AccountNumber="17112000";
        LoginController.Flag="17112000";
        assertEquals("5700",test2.BalanceMessageOnAction());

    }

}