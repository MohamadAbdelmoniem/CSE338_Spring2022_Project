package Controller;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TransactionHistoryControllerTest {
    @Test
    public void test1() throws SQLException {
        TransactionHistoryController test1 = new TransactionHistoryController();
        test1.AccountNumber1="17112000";
        LoginController.Flag="17112000";
        assertEquals("This Page show All your recent Transactions",test1.loadTables());
    }
    @Test
    public void test2() throws SQLException {
        TransactionHistoryController test1 = new TransactionHistoryController();
        test1.AccountNumber1="170";
        LoginController.Flag="17112000";
        assertEquals("Wrong ID",test1.loadTables());
    }
    @Test
    public void test3() throws SQLException {
        TransactionHistoryController test1 = new TransactionHistoryController();
        test1.AccountNumber1="170";
        LoginController.Flag="17112000";
        assertEquals("Wrong ID",test1.loadTables());
        TransactionHistoryController test2 = new TransactionHistoryController();
        test2.AccountNumber1="17112000";
        LoginController.Flag="17112000";
        assertEquals("This Page show All your recent Transactions", test2.loadTables());
    }

}