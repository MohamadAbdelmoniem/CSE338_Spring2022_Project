package Controller;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PayBillControllerTest {
    @Test
    public void test1() throws SQLException {
        PayBillController test1 = new PayBillController();
        test1.Account1="17112000";
        LoginController.Flag="17112000";
        test1.BillNumber1="583921";
        test1.Amount=200;
        assertEquals("Bill Paid",test1.PayBill());
    }
    @Test
    public void test2() throws SQLException {
        PayBillController test2 = new PayBillController();
        test2.Account1="17112000";
        LoginController.Flag="17112000";
        test2.BillNumber1="755742";
        test2.Amount=2000000;
        assertEquals("No Balance ", test2.PayBill());
    }
    @Test
    public void test3() throws SQLException {
        PayBillController test3 = new PayBillController();
        test3.Account1="666532";
        LoginController.Flag="17112000";
        test3.BillNumber1="097425";
        test3.Amount=100;
        assertEquals("Please enter correct ID", test3.PayBill());
    }
    @Test
    public void test4() throws SQLException {
        PayBillController test4 = new PayBillController();
        test4.Account1="17112000";
        LoginController.Flag="17112000";
        test4.BillNumber1="583921";
        test4.Amount=400;
        PayBillController test5 = new PayBillController();
        test5.Account1="17112000";
        LoginController.Flag="17112000";
        test5.BillNumber1="4728124";
        test5.Amount=200;
        assertEquals("Bill Paid", test5.PayBill());
    }
    @Test
    public void test6() throws SQLException {
        PayBillController test1 = new PayBillController();
        test1.Account1="17112000";
        LoginController.Flag="17112000";
        test1.BillNumber1="58324921";
        test1.Amount=30;
        PayBillController test2 = new PayBillController();
        test2.Account1="17112000";
        LoginController.Flag="17112000";
        test2.BillNumber1="22221412";
        test2.Amount=20000000;
        assertEquals("No Balance ", test2.PayBill());
    }

}