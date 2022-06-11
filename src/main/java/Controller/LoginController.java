package Controller;
import com.example.cse338_spring2022_project.DatabaseConnection;
import com.example.cse338_spring2022_project.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class LoginController {
    static String Flag;
    String Username;
    String Password;
    String Message;

    @FXML
    private Button CancelButton;
    public void CancelButtonOnAction(ActionEvent e){
        Stage stage =(Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Label LoginMessage;
    public String LoginMessageOnAction()throws SQLException {
        if (Username.isBlank()==false && Password.isBlank()==false){
            //LoginMessage.setText("please enter username and password");
            ValidateLogin();

        }
        else{
            Message=("You cant login using blank data");
        }
        return Message;
    }
    public String ValidateLogin()throws SQLException{
        DatabaseConnection connectNow= new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();
        String VertifyLogin="SELECT count(1) FROM world.useraccount WHERE Username='"+Username+
                "' AND Password='"+Password+"'";
        try{
            Statement statement= connectDB.createStatement();
            ResultSet queryResult= statement.executeQuery(VertifyLogin);
            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    String ID="SELECT idUserAccount FROM world.useraccount WHERE Username='"+Username+"'";
                    Statement ss= connectDB.createStatement();
                    ResultSet r= ss.executeQuery(ID);
                    r.next();
                    Flag=r.getString(1);
                    //GoDashbaord();
                    Message="Welcome!";
                }
                else{
                    Message="Wrong Username Or password";
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
return Message;
    }

    @FXML
    void GoRegisterOnAction(ActionEvent event) {
        GoRegister();
    }
    @FXML
    private Button LoginButton;

    @FXML
    private PasswordField PasswordTextField;

    @FXML
    private TextField UsernameTextField;

    public void GoDashbaord(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 697, 447);
            Stage stage=new Stage();
            stage.setTitle("Dashboard");
            stage.setScene(scene);
            stage.show();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void GoRegister(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignUp.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 520, 383);
            Stage stage=new Stage();
            stage.setTitle("Sign Up");
            stage.setScene(scene);
            stage.show();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
