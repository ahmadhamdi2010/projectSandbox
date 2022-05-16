package com.sde.passwordmanager.controllers;

import com.dlsc.formsfx.model.structure.PasswordField;
import com.sde.passwordmanager.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;

import java.io.IOException;

public class signInController {

    @FXML
    private Button menuSignUpBtn;

    @FXML
    private TextField UserNamein;
    @FXML
    private PasswordField Passwordin;

    @FXML
    protected void menuSignUpClicked() throws IOException {
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("signUp.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage signUpStage = (Stage) menuSignUpBtn.getScene().getWindow();
            signUpStage.setTitle("PswrdManager - Sign up");
            signUpStage.setScene(scene);
            signUpStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    @FXML
    protected void SubmitClciked() throws IOException {

        String username = "ahmadhamdi";
        String Password = "password";

        if(UserNamein.getText().equals(username) && Passwordin.toString().equals(Password)){

            try{

                FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("dashboard.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 600);
                Stage signUpStage = (Stage) menuSignUpBtn.getScene().getWindow();
                signUpStage.setTitle("PswrdManager - dashboard");
                signUpStage.setScene(scene);
                signUpStage.show();

            } catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }

        }


    }

    @FXML
    protected void testClicked() throws IOException {
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage signUpStage = (Stage) menuSignUpBtn.getScene().getWindow();
            signUpStage.setTitle("PswrdManager - dashboard");
            signUpStage.setScene(scene);
            signUpStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
}