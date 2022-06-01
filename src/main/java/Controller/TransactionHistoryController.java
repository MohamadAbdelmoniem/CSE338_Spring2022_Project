package Controller;


import Classes.Transaction;
import com.example.cse338_spring2022_project.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

public class TransactionHistoryController {

    ObservableList<Transaction> list = FXCollections.observableArrayList();
    @FXML
    private TableView<Transaction> TransactionRecord;

    @FXML
    private TableColumn<Transaction, String> AccountNumber;

    @FXML
    private TableColumn<Transaction, String> Amount;

    @FXML
    private TableColumn<Transaction, String> Date;

    @FXML
    private TextField SearchNumber;

    @FXML
    private TableColumn<Transaction, String> DebitCredit;

    @FXML
    private TableColumn<Transaction, String> Description;

    @FXML
    private Label BalanceMessage;

    @FXML
    private TableColumn<Transaction, String> FromToAccount;

    @FXML
    private TableColumn<Transaction, String> TransactionNumber;
    @FXML
    void ViewTransactions(ActionEvent event) throws SQLException {
        loadTables();

    }

    private void loadTables() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        //String ShowHistory="SELECT * FROM world.transactions";
        if (SearchNumber.getText().equals(LoginController.Flag)) {
            String ShowHistory = "SELECT * FROM world.transactions WHERE AccountNumber='" + SearchNumber.getText() + "'";
            try {
                Statement s = connectDB.createStatement();
                ResultSet rs = s.executeQuery(ShowHistory);
                list.clear();
                while (rs.next()) {
                    String r1 = rs.getString("TransactionNumber");
                    String r2 = rs.getString("AccountNumber");
                    String r3 = rs.getString("FromToAccount");
                    String r4 = rs.getString("Amount");
                    String r5 = rs.getString("DebitCredit");
                    String r6 = rs.getString("Date");
                    String r7 = rs.getString("Description");
                    list.add(new Transaction(r1, r2, r3, r4, r5, r6, r7));
                }
                TransactionRecord.getItems().clear();
                TransactionRecord.getItems().addAll(list);
                connectDB.close();
                BalanceMessage.setText("This Page show All your recent Transactions");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                BalanceMessage.setText("Wrong ID");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    void initialize() throws Exception {
        DatabaseConnection connectNow= new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();
        Statement s = connectDB.createStatement();
        ResultSet rs = s.executeQuery("select * from world.transactions");
        ArrayList<String> Transactions = new ArrayList<>();
        initcol();
    }
    public void initcol() {
        TransactionNumber.setCellValueFactory(new PropertyValueFactory<>("TransactionNumber"));
        AccountNumber.setCellValueFactory(new PropertyValueFactory<>("UserAccount"));
        FromToAccount.setCellValueFactory(new PropertyValueFactory<>("TransferNumberAccount"));
        Amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        DebitCredit.setCellValueFactory(new PropertyValueFactory<>("type"));
        Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        Description.setCellValueFactory(new PropertyValueFactory<>("description"));
    }
}
