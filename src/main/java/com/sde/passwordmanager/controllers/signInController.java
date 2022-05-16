package com.sde.passwordmanager.controllers;

import com.sde.passwordmanager.MainApp;
import com.sde.passwordmanager.myDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;

public class signInController {
    @FXML Label title;
    @FXML Label errmsg;
    @FXML
    private PasswordField signingPassword;
    @FXML
    private TextField UserNameIn;
    @FXML
    protected void menuSignUpClicked(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("signUp.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage signUpStage = (Stage) title.getScene().getWindow();
            signUpStage.setTitle("PswrdManager - Sign up");
            signUpStage.setScene(scene);
            signUpStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    @FXML

    protected void SubmitClicked() throws SQLException {
        String username = UserNameIn.getText();
        String Password = signingPassword.getText() ;
        //System.out.println(username+"\n"+Password);
        myDB mydb = new myDB();
        mydb.ConnectDb();
        int valid = mydb.Authinticate(username, Password);
        System.out.println(valid);

        if(valid >0){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("dashboard.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 600);
                Stage ManageStage = (Stage) title.getScene().getWindow();
                ManageStage.setTitle("PswrdManager - Dashboard User : " + valid );
                ManageStage.setScene(scene);
                ManageStage.show();
            } catch (IOException e) {
                e.printStackTrace();
                e.getCause();
            }
        }else if(valid == -1){
            errmsg.setText("Wrong Password!!");
            errmsg.setOpacity(1);
        }else{
            errmsg.setText("Enter A Valid Username and Password !");
            errmsg.setOpacity(1);
        }
    }

}