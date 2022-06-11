package Controller;

import com.example.cse338_spring2022_project.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

public class SignUpController {
    boolean found1 = false;
    String FirstName1;
    String Pass1;
    String CPass1;
    String ID1;
    String LastName1;
    String UserName1;

    @FXML
    private TextField CPass;

    @FXML
    private TextField FirstName;

    @FXML
    private TextField ID;

    @FXML
    private Label SignUpMesaage;

    @FXML
    private TextField LastName;

    @FXML
    private TextField Pass;

    @FXML
    private TextField UserName;

    @FXML
    void Cancel(ActionEvent event) {

    }

    @FXML
    void SignmeUP(ActionEvent event) throws SQLException {
        ValidateSignUp();
    }

    String ValidateSignUp() throws SQLException {
        if (!FirstName1.isEmpty() && !Pass1.isEmpty() && !CPass1.isEmpty() && !ID1.isEmpty() && !LastName1.isEmpty() && !UserName1.isEmpty()) {
            if (CPass1.equals(Pass1)) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                try {
                    String sql = "SELECT count(1) FROM world.useraccount WHERE idUserAccount = '" + ID1 + "'";
                    Statement ss = connectDB.createStatement();
                    ResultSet queryResult= ss.executeQuery(sql);
                    while (queryResult.next()) {
                        if (queryResult.getInt(1) == 1) {
                            found1=true;
                        }
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                if (!found1) {
                    String AddUser = "INSERT INTO `world`.`useraccount` (`idUserAccount`, `Username`, `Password`, `FirstName`, `LastName`, `Balance`) " +
                            "VALUES ('" + ID1 + "', '" + UserName1 + "', '" + Pass1 + "', '" + FirstName1 + "', '" + LastName1 + "', '" + 1000 + "')";
                    try {
                        Statement ss = connectDB.createStatement();
                        ss.executeUpdate(AddUser);
                        //SignUpMesaage.setText("User have successfully sign up!");
                        return  ("User have successfully sign up!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    //SignUpMesaage.setText("This ID is already used");
                    return("This ID is already used");
                }
            } else {
                //SignUpMesaage.setText("Password doesn't match");
                return ("Password doesn't match");
            }
        } else {
            //SignUpMesaage.setText("Please provide all info");
            return ("Please provide all info");
        }
        return null;
    }
}
