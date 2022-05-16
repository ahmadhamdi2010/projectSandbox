package com.sde.passwordmanager.controllers;

import com.sde.passwordmanager.MainApp;
import com.sde.passwordmanager.Models.Password;
import com.sde.passwordmanager.Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class dashboardController {
    public User currentUser = new User();

    @FXML
    PasswordField PWRecord;
    @FXML
    TextField NowPassword;

    @FXML
    TextField AddPw;

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
    protected void testClicked() throws IOException {
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("PwView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage PWStage = (Stage) manuAdd.getScene().getWindow();
            PWStage.setTitle("PswrdManager - View");
            PWStage.setScene(scene);
            PWStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    @FXML
    protected void PWViewClicked(ActionEvent event){
        Password pswrd = new Password();
        PWRecord.setText(PWRecord.getText());
        System.out.println(PWRecord.getText());

    }

    @FXML
    protected void AddGenBtnClicked(ActionEvent event){
        Password pswrd = new Password();
        System.out.println(pswrd.generateRandomPassword(8));
        AddPw.setText(pswrd.generateRandomPassword(8));

    }
    @FXML
    protected void settingGenBtnClicked(ActionEvent event){
        Password pswrd = new Password();
        System.out.println(pswrd.generateRandomPassword(8));

        NowPassword.setText(pswrd.generateRandomPassword(8));

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