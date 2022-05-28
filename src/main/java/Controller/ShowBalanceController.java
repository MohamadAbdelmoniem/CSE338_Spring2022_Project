package Controller;

import com.example.cse338_spring2022_project.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowBalanceController {

    @FXML
    private TextField AccountNumberText;

    @FXML
    private Label BalanceMessage;

    @FXML
    private Button ShowBalanceButton;

    public void BalanceMessageOnAction(ActionEvent e){
        if (AccountNumberText.getText().isBlank()==false) {
            ShowBalance();
        } else {
            BalanceMessage.setText("please make sure you entered all data fields");
        }
    }
    public void ShowBalance(){
        DatabaseConnection connectNow= new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();
        String VertifyID="SELECT count(1) FROM world.useraccount WHERE idUserAccount='"+AccountNumberText.getText()+
                "'";
        try{
            Statement statement= connectDB.createStatement();
            ResultSet queryResult= statement.executeQuery(VertifyID);
            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    String Balance="SELECT Balance FROM world.useraccount WHERE idUserAccount='"+AccountNumberText.getText()+"'";
                    Statement ss= connectDB.createStatement();
                    ResultSet r= ss.executeQuery(Balance);
                    r.next();
                    BalanceMessage.setText(r.getString(1));
                }
                else{
                    BalanceMessage.setText("Wrong Account Number");

                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
