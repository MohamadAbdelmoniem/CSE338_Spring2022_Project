package Controller;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class Login_ShowTransactions_Test {
    @Test
    public void test1() throws SQLException {
        LoginController test1 = new LoginController();
        test1.Username="Man3om__";
        test1.Password="1234";
        assertEquals("Welcome!",test1.LoginMessageOnAction());
        TransactionHistoryController test2 = new TransactionHistoryController();
        test2.AccountNumber1="17112000";
        assertEquals("This Page show All your recent Transactions", test2.loadTables());
    }
    @Test
    public void test2() throws SQLException {
        LoginController test1 = new LoginController();
        test1.Username="Man3om__";
        test1.Password="1234";
        assertEquals("Welcome!",test1.LoginMessageOnAction());
        TransactionHistoryController test2 = new TransactionHistoryController();
        test2.AccountNumber1="126713";
        assertEquals("Wrong ID", test2.loadTables());
    }
}