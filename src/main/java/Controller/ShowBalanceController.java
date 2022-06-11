package Controller;

import com.example.cse338_spring2022_project.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowBalanceController {
    String AccountNumber;
    String Message;

    @FXML
    private TextField AccountNumberText;

    @FXML
    private Label BalanceMessage;

    @FXML
    private Button ShowBalanceButton;

    public String BalanceMessageOnAction(){
        if (AccountNumber.isBlank()==false) {
            ShowBalance();
        } else {
            Message=("please make sure you entered all data fields");
        }
        return Message;
    }
    public String ShowBalance(){
        DatabaseConnection connectNow= new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();
        try{
            if(AccountNumber.equals(LoginController.Flag)) {
                        String Balance = "SELECT Balance FROM world.useraccount WHERE idUserAccount='" + AccountNumber+ "'";
                        Statement ss = connectDB.createStatement();
                        ResultSet r = ss.executeQuery(Balance);
                        r.next();
                Message=(r.getString(1));
                    }
            else{
                Message=("Please enter correct ID");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return Message;
    }
}
