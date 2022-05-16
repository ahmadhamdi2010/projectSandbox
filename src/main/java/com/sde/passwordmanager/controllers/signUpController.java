package com.sde.passwordmanager.controllers;

import com.sde.passwordmanager.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;

import java.io.IOException;

public class signUpController {

    @FXML
    private Button menuSignInBtn;

    @FXML
    protected void menuSignInClicked() throws IOException {
        try{
//888
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
}