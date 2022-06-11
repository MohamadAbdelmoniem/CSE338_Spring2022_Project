package Controller;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class FullProgramTest {
    @Test
    public void IntegrateLoginRegister1() throws SQLException {
        SignUpController test1 = new SignUpController();
        test1.FirstName1="Isalm";
        test1.LastName1="El Maddah";
        test1.ID1="56472";
        test1.UserName1="DoctorIslam";
        test1.Pass1="123";
        test1.CPass1="123";
        assertEquals("User have successfully sign up!", test1.ValidateSignUp());
// We assume the value of the user in the bank is 1000L.E
        LoginController test2 = new LoginController();
        test2.Username="DoctorIslam";
        test2.Password="123";
        assertEquals("Welcome!", test2.LoginMessageOnAction());

        TransferMoneyController test3 = new TransferMoneyController();
        test3.FirstAccount1="56472";
        test3.Amount1=100;
        test3.Date1= String.valueOf(java.time.LocalDate.now());
        test3.SecondAccount1="123841";
        test3.Description1="Hello Try";
        assertEquals("Validate", test3.ValidateTransfer());

        PayBillController test4 = new PayBillController();
        test4.Account1="56472";
        test4.BillNumber1="583921";
        test4.Amount=200;
        assertEquals("Bill Paid", test4.PayBill());

        ShowBalanceController test5 = new ShowBalanceController();
        test5.AccountNumber="56472";
        assertEquals("700", test5.BalanceMessageOnAction());

        TransactionHistoryController test6 = new TransactionHistoryController();
        test6.AccountNumber1="56472";
        assertEquals("This Page show All your recent Transactions", test6.loadTables());
    }

}