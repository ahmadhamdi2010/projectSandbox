package com.sde.passwordmanager.controllers;

import com.sde.passwordmanager.MainApp;
import com.sde.passwordmanager.myDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

public class signUpController {

    @FXML
    private Button menuSignInBtn;

    @FXML
    protected void menuSignInClicked() throws IOException {
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("signIn.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage signUpStage = (Stage) menuSignInBtn.getScene().getWindow();
            signUpStage.setTitle("PswrdManager - Sign in");
            signUpStage.setScene(scene);
            signUpStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    @FXML
    TextField signUpUsername;
    @FXML
    PasswordField signUpPassword;
    @FXML
    PasswordField signUpPin;
    @FXML
    protected void registerButton(){
        boolean registered  = false;
        try {
            myDB mydb = new myDB();
            mydb.ConnectDb();
            registered = !mydb.Register(signUpUsername.getText(),signUpPassword.getText(), signUpPin.getText());
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            System.out.println("It looks like your username is already taken :(");
        }
        System.out.println(registered);
    }

}