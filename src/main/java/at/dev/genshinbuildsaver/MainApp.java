package at.dev.genshinbuildsaver;

import at.dev.genshinbuildsaver.Objects.UserStatic;
import at.dev.genshinbuildsaver.dao.ListDAO;
import at.dev.genshinbuildsaver.dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp {

    @FXML
    private Button loginBtt;

    @FXML
    private Label passwdCounter;

    @FXML
    private PasswordField pwdField;

    @FXML
    private Button registerBtt;

    @FXML
    private Label unameCounter;

    @FXML
    private TextField unameTField;

    @FXML
    void onLoginAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Failed to login");
        alert.setHeaderText(null);

        String uname = unameTField.getText();
        if(UserDAO.checkuname(uname)){
            String passwd = pwdField.getText();
            if (UserDAO.chechpasswd(uname, passwd)){
                UserStatic.uname = uname;
                UserStatic.passwd = passwd;
                UserStatic.user_lists = ListDAO.getLists(uname);
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Login successfully");
                alert.setContentText("Welcome back, " + uname);
                alert.showAndWait();
                loadNextWindow();
            } else {
                alert.setContentText("The provided password doesn't match with the assigned to this username.\nMake any necessary changes and try again later.");
                alert.showAndWait();
            }
        } else {
            alert.setContentText("The provided username doesn't exist in our database.\nMake any necessary changes and try again later.");
            alert.showAndWait();
        }
    }

    @FXML
    void onPasswdType(KeyEvent event) {
        int numChars = pwdField.getText().length();
        passwdCounter.setText(numChars + "/30");
        if (numChars>30){
            pwdField.setText("");
            passwdCounter.setText("0/30");
            passwdCounter.setTextFill(Color.WHITE);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Password Length Exceeded");
            alert.setContentText("In order for the server to work properly, passwords must have a maximum length of 30 characters.");
            alert.showAndWait();
        }else if (numChars==30){
            passwdCounter.setTextFill(Color.RED);
        } else {
            passwdCounter.setTextFill(Color.WHITE);
        }
    }

    @FXML
    void onRegisterAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Register error");
        alert.setHeaderText(null);

        String uname = unameTField.getText();
        if(!UserDAO.checkuname(uname)){
            String passwd = pwdField.getText();
            UserDAO.register(uname, passwd);
            UserStatic.uname = uname;
            UserStatic.passwd = passwd;
            UserStatic.user_lists = ListDAO.getLists(uname);
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("Registered successfully");
            alert.setContentText("Please enjoy our application and don't forget your password!");
            loadNextWindow();
        } else {
            alert.setContentText("There's another user with that username");
        }
        alert.showAndWait();
    }

    @FXML
    void onUnameType(KeyEvent event) {
        int numChars = unameTField.getText().length();
        unameCounter.setText(numChars + "/20");
        if (numChars>20){
            unameTField.setText(unameTField.getText().substring(0, 20));
            unameCounter.setText("20/20");
        } else if (numChars==20) {
            unameCounter.setTextFill(Color.RED);
        } else {
            unameCounter.setTextFill(Color.WHITE);
        }
    }

    void loadNextWindow(){
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("ListsWindow.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) this.loginBtt.getScene().getWindow();
            stage.setScene(scene);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

