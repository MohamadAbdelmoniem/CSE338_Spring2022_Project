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


    public void TransferMessageOnAction(ActionEvent e) throws SQLException {
        String FirstAccount = AccountOneText.getText();
        String SecondAccount = AccountTwoText.getText();
        String Amount = AmountText.getText();
        String Date = DateText.getText();
        String Description = DescriptionText.getText();
        if (FirstAccount.isBlank() == false || SecondAccount.isBlank() == false ||
                Amount.isBlank() == false || Date.isBlank() == false) {
            ValidateTransfer();
        } else {
            TransferMessage.setText("please make sure you entered all data fields");
        }
    }
    @FXML
    void TransferButtonOnAction(ActionEvent event) {

    }
    public void ValidateTransfer() {
        String FirstAccount = AccountOneText.getText();
        String SecondAccount = AccountTwoText.getText();
        String Amount = AmountText.getText();
        String Date = DateText.getText();
        String Description = DescriptionText.getText();
        Random rand = new Random();
        int maxNumber = 10000000;
        int randomNumber = rand.nextInt(maxNumber) + 1;
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String VertifyTransfer = "INSERT INTO world.transactions (`TransactionNumber`, `AccountNumber`, `FromToAccount`, `Amount`, `DebitCredit`, `Date`, `Description`) " +
                "VALUES ('"+randomNumber+"', '"+ FirstAccount+"','"+ SecondAccount+"','"+Amount+"','"+"D"+"','"+Date+"','"+Description+"')";
        //String GetBalance="SELECT Balance FROM `world`.`useraccount` where idUserAccount='"+FirstAccount+"'";

        try {
            Statement ss= connectDB.createStatement();
            ss.executeUpdate(VertifyTransfer);
            TransferMessage.setText("Validate");
            /*Statement statement= connectDB.createStatement();
            ResultSet queryResult= statement.executeQuery(GetBalance);
            while (queryResult.next()) {
                String UpdateBalance="UPDATE `world`.`useraccount` SET `Balance` = '"+(queryResult)+"' WHERE (`idUserAccount` = '"+FirstAccount+"')";
            }
             */
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

//world.useraccount