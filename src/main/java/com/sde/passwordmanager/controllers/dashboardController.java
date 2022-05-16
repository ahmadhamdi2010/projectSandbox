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
            Stage AddStage = (Stage) manuAdd.getScene().getWindow();
            AddStage.setTitle("PswrdManager - Add");
            AddStage.setScene(scene);
            AddStage.show();

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
            Stage ManageStage = (Stage) manuAdd.getScene().getWindow();
            ManageStage.setTitle("PswrdManager - Dashboard");
            ManageStage.setScene(scene);
            ManageStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }


    @FXML
    protected void ExitBtnClicked() throws IOException {
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("signIn.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage exitStage = (Stage) manuAdd.getScene().getWindow();
            exitStage.setTitle("PswrdManager - Settings");
            exitStage.setScene(scene);
            exitStage.show();

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
            Stage SettingsStage = (Stage) manuAdd.getScene().getWindow();
            SettingsStage.setTitle("PswrdManager - Settings");
            SettingsStage.setScene(scene);
            SettingsStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
}