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

public class dashboardController {

    @FXML
    private Button manuAdd;

    @FXML
    protected void menuAddClicked() throws IOException {
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Add.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage signUpStage = (Stage) manuAdd.getScene().getWindow();
            signUpStage.setTitle("PswrdManager - Add");
            signUpStage.setScene(scene);
            signUpStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    @FXML
    protected void manuManageClicked() throws IOException {
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage signUpStage = (Stage) manuAdd.getScene().getWindow();
            signUpStage.setTitle("PswrdManager - Dashboard");
            signUpStage.setScene(scene);
            signUpStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
    @FXML
    protected void manuSettingsClicked() throws IOException {
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("settings.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage signUpStage = (Stage) manuAdd.getScene().getWindow();
            signUpStage.setTitle("PswrdManager - Settings");
            signUpStage.setScene(scene);
            signUpStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
}