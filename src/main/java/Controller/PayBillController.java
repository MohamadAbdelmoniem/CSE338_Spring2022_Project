package Controller;

import com.example.cse338_spring2022_project.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class PayBillController {
    String Account1;
    String BillNumber1;
    int Amount;
    String Message;

    @FXML
    private TextField AccountNumber;

    @FXML
    private Label BalanceMessage;
    @FXML
    private ChoiceBox<String> ChooseBox;

    @FXML
    private TextField BillNumber;

    @FXML
    private Button PayBill;

    @FXML
    private Label Status;

    @FXML
    void StatusMassageOnAction() throws SQLException {
        PayBill();
    }

    String PayBill() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        Random rand = new Random();
        int maxNumber = 10000000;
        int randomNumber = rand.nextInt(maxNumber) + 1;
        String PayBill = "SELECT Balance FROM `world`.`useraccount` where idUserAccount='"+Account1+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(PayBill);
            int TransferAccountNumber;
            if(Account1.equals(LoginController.Flag)) {
                /*if (ChooseBox.getValue() == "WE") {
                    TransferAccountNumber = 32421;
                }
                 */
                while (queryResult.next()) {
                    if (queryResult.getInt(1) > Amount) {
                        String InsertTransaction = "INSERT INTO `world`.`transactions` (`TransactionNumber`, `AccountNumber`, `FromToAccount`, `Amount`, `DebitCredit`, `Date`, `Description`, `BillNumber`) " +
                                "VALUES ('" + randomNumber + "','" + Account1+ "', '" + 356218 + "', '" + Amount + "', '" + "D" + "', '" + java.time.LocalDate.now() + "', 'Paying Bill', '" + BillNumber1 + "')";
                        Statement ss = connectDB.createStatement();
                        ss.executeUpdate(InsertTransaction);
                        Message=("Bill Paid");
                        String GetBalance="Select Balance FROM useraccount where idUserAccount='"+Account1+"'";
                        Statement s= connectDB.createStatement();
                        ResultSet r= s.executeQuery(GetBalance);
                        r.next();
                         int Balance=r.getInt(1);
                         Balance=Balance-Amount;
                        String UpBalance="UPDATE useraccount SET Balance='"+Balance+"'where idUserAccount='"+Account1+"'";
                        Statement s2 = connectDB.createStatement();
                        s2.executeUpdate(UpBalance);
                    } else {
                        Message=("No Balance ");
                    }
                }
            }
            else{
                Message=("Please enter correct ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Message;
    }
    @FXML
    void initialize() {
        ChooseBox.getItems().addAll("WE","Vodafone","Amazon","Orange");
    }
}
