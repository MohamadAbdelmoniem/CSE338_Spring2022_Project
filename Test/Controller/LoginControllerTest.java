package Controller;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {


    @Test
    public void test1() throws SQLException {
        LoginController test1 = new LoginController();
        test1.Username="Mohsen1234";
        test1.Password="1234";
        assertEquals("Welcome!",test1.LoginMessageOnAction());
    }
    @Test
    public void test2() throws SQLException {
        LoginController test2 = new LoginController();
        test2.Username="";
        test2.Password="";
        assertEquals("You cant login using blank data",test2.LoginMessageOnAction());
    }
    @Test
    public void test3() throws SQLException {
        LoginController test3 = new LoginController();
        test3.Username="aaa";
        test3.Password="aaa";
        assertEquals("Wrong Username Or password",test3.LoginMessageOnAction());
    }
    @Test
    public void test4() throws SQLException {
        LoginController test4 = new LoginController();
        test4.Username="";
        test4.Password="";
        assertEquals("You cant login using blank data",test4.LoginMessageOnAction());
        test4.Username="aaa";
        test4.Password="aaa";
        assertEquals("Wrong Username Or password",test4.LoginMessageOnAction());
    }


}