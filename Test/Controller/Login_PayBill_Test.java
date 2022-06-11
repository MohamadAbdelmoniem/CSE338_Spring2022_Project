package Controller;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class Login_PayBill_Test {
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
    }
    @Test
    public void test2() throws SQLException {
        LoginController test1 = new LoginController();
        test1.Username="Man3om__";
        test1.Password="1234";
        assertEquals("Welcome!",test1.LoginMessageOnAction());
        TransferMoneyController test2 = new TransferMoneyController();
        test2.FirstAccount1="17112000";
        test2.Amount1=10000000;
        test2.Date1= String.valueOf(java.time.LocalDate.now());
        test2.SecondAccount1="123841";
        test2.Description1="Hello Try";
        assertEquals("No Balance", test2.ValidateTransfer());
    }
    @Test
    public void test3() throws SQLException {
        LoginController test1 = new LoginController();
        test1.Username="Man3om__";
        test1.Password="1234";
        assertEquals("Welcome!",test1.LoginMessageOnAction());
        TransferMoneyController test2 = new TransferMoneyController();
        test2.FirstAccount1="111";
        test2.Amount1=400;
        test2.Date1= String.valueOf(java.time.LocalDate.now());
        test2.SecondAccount1="123841";
        test2.Description1="Hello Try";
        assertEquals("Wrong ID", test2.ValidateTransfer());
    }

}