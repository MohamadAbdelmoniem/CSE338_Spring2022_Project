package Controller;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class Login_PayBill_ShowBalance_Test {
    @Test
    public void test1() throws SQLException {
        LoginController test1 = new LoginController();
        test1.Username="Man3om__";
        test1.Password="1234";
        assertEquals("Welcome!",test1.LoginMessageOnAction());
        TransferMoneyController test2 = new TransferMoneyController();
        test2.FirstAccount1="17112000";
        test2.Amount1=100;
        test2.Date1= String.valueOf(java.time.LocalDate.now());
        test2.SecondAccount1="123841";
        test2.Description1="Hello Try";
        assertEquals("Validate", test2.ValidateTransfer());
        ShowBalanceController test3 = new ShowBalanceController();
        test3.AccountNumber="17112000";
        assertEquals("4400", test3.BalanceMessageOnAction());
    }
    @Test
    public void test2() throws SQLException {
        LoginController test1 = new LoginController();
        test1.Username="Man3om__";
        test1.Password="1234";
        assertEquals("Welcome!",test1.LoginMessageOnAction());
        TransferMoneyController test2 = new TransferMoneyController();
        test2.FirstAccount1="17112000";
        test2.Amount1=100;
        test2.Date1= String.valueOf(java.time.LocalDate.now());
        test2.SecondAccount1="123841";
        test2.Description1="Hello Try";
        assertEquals("Validate", test2.ValidateTransfer());
        ShowBalanceController test3 = new ShowBalanceController();
        test3.AccountNumber="17100";
        assertEquals("Please enter correct ID", test3.BalanceMessageOnAction());
    }

}