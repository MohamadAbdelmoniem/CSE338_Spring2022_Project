package Controller;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class Login_ShowBalance_Test {
    @Test
    public void test1() throws SQLException {
        LoginController test1 = new LoginController();
        test1.Username="Man3om__";
        test1.Password="1234";
        assertEquals("Welcome!",test1.LoginMessageOnAction());
        ShowBalanceController test2 = new ShowBalanceController();
        test2.AccountNumber="17112000";
        assertEquals("5500", test2.BalanceMessageOnAction());
    }
    @Test
    public void test2() throws SQLException {
        LoginController test1 = new LoginController();
        test1.Username="Man3om__";
        test1.Password="1234";
        assertEquals("Welcome!",test1.LoginMessageOnAction());
        ShowBalanceController test2 = new ShowBalanceController();
        test2.AccountNumber="1710";
        assertEquals("Please enter correct ID", test2.BalanceMessageOnAction());
    }

}