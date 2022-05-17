package com.sde.passwordmanager.controllers;

import com.sde.passwordmanager.MainApp;
import com.sde.passwordmanager.Models.Password;
import com.sde.passwordmanager.Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class dashboardController {
    public User currentUser = User.get();

    @FXML
    PasswordField PWRecord;
    @FXML
    TextField NowPassword;

    @FXML
    ListView<Password> PasswordList;

    @FXML
    Label websiteName;

    @FXML
    TextField AddPw;

    @FXML
    private Button manuAdd;
    @FXML
    private Label titlenow;

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
    protected void getlistdata() throws IOException {

        Password pw1 = new Password(0,"facebook","ahmad@ahmad","secret");
        Password pw2 = new Password(1,"youtube","ahmad@youtube","secret2");
        Password pw3 = new Password(2,"Twitter","ahmad@Twitter","secret 3");

        ListView<Password> PsList = new ListView<>();
        PsList.getItems().add(pw1);
        PsList.getItems().add(pw2);
        PsList.getItems().add(pw3);

        currentUser.setUserPasswords(PsList);

        PsList.getItems().forEach(v-> PasswordList.getItems().add(v));


    }

    @FXML
    protected void PwItemClicked(ActionEvent event){

        currentUser.setIndexlist(PasswordList.getSelectionModel().getSelectedIndex());

        try{

            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("PwView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage PWStage = (Stage) manuAdd.getScene().getWindow();
            PWStage.setTitle("PswrdManager - View");
            PWStage.setScene(scene);
            PWStage.show();

            Password selectedPw = currentUser.getSinglePassword(currentUser.getIndexlist());
            websiteName.setText(selectedPw.getWebsite());

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

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