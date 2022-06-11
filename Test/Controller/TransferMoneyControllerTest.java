package Controller;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TransferMoneyControllerTest {
    @Test
    public void test1() throws SQLException {
        TransferMoneyController test1 = new TransferMoneyController();
        test1.FirstAccount1="17112000";
        LoginController.Flag="17112000";
        test1.Amount1=100;
        test1.Date1= String.valueOf(java.time.LocalDate.now());
        test1.SecondAccount1="123841";
        test1.Description1="Hello Try";
        assertEquals("Validate",test1.ValidateTransfer());
    }
    @Test
    public void test2() throws SQLException {
        TransferMoneyController test2 = new TransferMoneyController();
        test2.FirstAccount1="17112000";
        LoginController.Flag="17112000";
        test2.Amount1=10000000;
        test2.Date1= String.valueOf(java.time.LocalDate.now());
        test2.SecondAccount1="123841";
        test2.Description1="Hello Try";
        assertEquals("No Balance",test2.ValidateTransfer());
    }
    @Test
    public void test3() throws SQLException {
        TransferMoneyController test3 = new TransferMoneyController();
        test3.FirstAccount1="2012931";
        LoginController.Flag="17112000";
        test3.Amount1=100;
        test3.Date1= String.valueOf(java.time.LocalDate.now());
        test3.SecondAccount1="123841";
        test3.Description1="Hello Try";
        assertEquals("Wrong ID",test3.ValidateTransfer());
    }
    @Test
    public void test4() throws SQLException {
        TransferMoneyController test4 = new TransferMoneyController();
        test4.FirstAccount1="";
        LoginController.Flag="17112000";
        test4.Amount1=100;
        test4.Date1= String.valueOf(java.time.LocalDate.now());
        test4.SecondAccount1="11111111";
        test4.Description1="Hello Try";
        assertEquals("Enter all data fields",test4.TransferMessageOnAction());
    }
    @Test
    public void test5() throws SQLException {
        TransferMoneyController test5 = new TransferMoneyController();
        test5.FirstAccount1="2012931";
        LoginController.Flag="17112000";
        test5.Amount1=100;
        test5.Date1= String.valueOf(java.time.LocalDate.now());
        test5.SecondAccount1="123841";
        test5.Description1="Hello Try";
        assertEquals("Wrong ID", test5.ValidateTransfer());
        test5.FirstAccount1="17112000";
        LoginController.Flag="17112000";
        test5.Amount1=100;
        test5.Date1= String.valueOf(java.time.LocalDate.now());
        test5.SecondAccount1="123841";
        test5.Description1="Hello Try";
        assertEquals("Validate",test5.ValidateTransfer());
    }
    @Test
    public void test6() throws SQLException {
        TransferMoneyController test6 = new TransferMoneyController();
        test6.FirstAccount1="17112000";
        LoginController.Flag="17112000";
        test6.Amount1=100;
        test6.Date1= String.valueOf(java.time.LocalDate.now());
        test6.SecondAccount1="123841";
        test6.Description1="Hello Try";
        assertEquals("Validate", test6.ValidateTransfer());
        test6.FirstAccount1="17112000";
        LoginController.Flag="17112000";
        test6.Amount1=10000000;
        test6.Date1= String.valueOf(java.time.LocalDate.now());
        test6.SecondAccount1="123841";
        test6.Description1="Hello Try";
        assertEquals("No Balance",test6.ValidateTransfer());
    }


}