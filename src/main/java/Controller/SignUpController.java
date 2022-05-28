package Controller;

import com.example.cse338_spring2022_project.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

public class SignUpController {

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

    void ValidateSignUp() throws SQLException {
        if (!FirstName.getText().isEmpty() && !Pass.getText().isEmpty() && !CPass.getText().isEmpty() && !ID.getText().isEmpty() && !LastName.getText().isEmpty() && !UserName.getText().isEmpty()) {
            if (CPass.getText().equals(Pass.getText())) {
                boolean found = false;
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                try {
                    String sql = "SELECT count(1) FROM world.useraccount WHERE idUserAccount = '" + ID.getText() + "'";
                    Statement ss = connectDB.createStatement();
                    ResultSet queryResult= ss.executeQuery(sql);
                    while (queryResult.next()) {
                        if (queryResult.getInt(1) == 1) {
                            found=true;
                        }
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                if (!found) {
                    String AddUser = "INSERT INTO `world`.`useraccount` (`idUserAccount`, `Username`, `Password`, `FirstName`, `LastName`, `Balance`) " +
                            "VALUES ('" + ID.getText() + "', '" + UserName.getText() + "', '" + Pass.getText() + "', '" + FirstName.getText() + "', '" + LastName.getText() + "', '" + 0 + "')";
                    try {
                        Statement ss = connectDB.createStatement();
                        ss.executeUpdate(AddUser);
                        SignUpMesaage.setText("User have successfully sign up!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    SignUpMesaage.setText("This ID is already used");
                }
            } else {
                SignUpMesaage.setText("Password doesn't match");
            }
        } else {
            SignUpMesaage.setText("Please provide all info");
        }
    }
    }
