package Controller;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class Register_Login_Integration {
    @Test
    public void IntegrateLoginRegister1() throws SQLException {
        SignUpController test1 = new SignUpController();
        test1.FirstName1="Isalm";
        test1.LastName1="ElMaddah";
        test1.ID1="3321134";
        test1.UserName1="Islam332";
        test1.Pass1="123";
        test1.CPass1="123";
        assertEquals("User have successfully sign up!", test1.ValidateSignUp());
        LoginController test2 = new LoginController();
        test2.Username="Islam332";
        test2.Password="123";
        assertEquals("Welcome!", test2.LoginMessageOnAction());
    }
    @Test
    public void IntegrateLoginRegister2() throws SQLException {
        SignUpController test1 = new SignUpController();
        test1.FirstName1="Mohamad";
        test1.LastName1="Ahmed";
        test1.ID1="17112000";
        test1.UserName1="Man3om__";
        test1.Pass1="123";
        test1.CPass1="123";
        assertEquals("This ID is already used",test1.ValidateSignUp());
        LoginController test2 = new LoginController();
        test2.Username="Man3om__";
        test2.Password="1234";
        assertEquals("Welcome!", test2.LoginMessageOnAction());
    }
    @Test
    public void IntegrateLoginRegister3() throws SQLException {
        SignUpController test1 = new SignUpController();
        test1.FirstName1="Mohamad";
        test1.LastName1="Ahmed";
        test1.ID1="17112000";
        test1.UserName1="Man3om__";
        test1.Pass1="123";
        test1.CPass1="123";
        assertEquals("This ID is already used",test1.ValidateSignUp());
        LoginController test2 = new LoginController();
        test2.Username="Man3om__";
        test2.Password="123";
        assertEquals("Wrong Username Or password", test2.LoginMessageOnAction());
        test2.Username="Man3om__";
        test2.Password="1234";
        assertEquals("Welcome!", test2.LoginMessageOnAction());
    }

}