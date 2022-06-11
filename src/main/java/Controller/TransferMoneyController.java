package Controller;

import com.example.cse338_spring2022_project.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.Random;

public class TransferMoneyController {

    @FXML
    private TextField AccountOneText;

    @FXML
    private TextField AccountTwoText;

    @FXML
    private TextField AmountText;

    @FXML
    private TextField DateText;

    @FXML
    private TextField DescriptionText;

    @FXML
    private Button TransferButton;


    @FXML
    private Label TransferMessage;
    String FirstAccount1;
    String SecondAccount1;
    int Amount1;
    String Date1;
    String Description1;
    String Massage;

    public String TransferMessageOnAction() throws SQLException {

        if (FirstAccount1.isBlank() == false && SecondAccount1.isBlank() == false && Date1.isBlank() == false) {
            ValidateTransfer();
        } else {
            Massage=("Enter all data fields");
        }
        return Massage;
    }
    @FXML
    void TransferButtonOnAction(ActionEvent event) {

    }
    public String ValidateTransfer()throws SQLException {

        if (FirstAccount1.equals(LoginController.Flag)) {
            String GetBalance1="Select Balance FROM useraccount where idUserAccount='"+FirstAccount1+"'";
            Random rand = new Random();
            int maxNumber = 10000000;
            int randomNumber = rand.nextInt(maxNumber) + 1;
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            try {
                String VertifyTransfer = "INSERT INTO world.transactions (`TransactionNumber`, `AccountNumber`, `FromToAccount`, `Amount`, `DebitCredit`, `Date`, `Description`) " + "VALUES ('" + randomNumber + "', '" + FirstAccount1 + "','" + SecondAccount1 + "','" + Amount1 + "','" + "D" + "','" + Date1 + "','" + Description1 + "')";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(GetBalance1);
                while (queryResult.next()) {
                    if (queryResult.getInt(1) > Amount1) {
                        Statement ss = connectDB.createStatement();
                        ss.executeUpdate(VertifyTransfer);
                        Massage=("Validate");
                        int Balance = queryResult.getInt(1);
                        Balance -= Amount1;
                        String UpBalance = "UPDATE useraccount SET Balance='" + Balance + "'where idUserAccount='" + FirstAccount1 + "'";
                        Statement s2 = connectDB.createStatement();
                        s2.executeUpdate(UpBalance);
                        queryResult.next();
                    }
                    else{
                        Massage=("No Balance");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                Massage=("Wrong ID");
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        return Massage;
    }

}
