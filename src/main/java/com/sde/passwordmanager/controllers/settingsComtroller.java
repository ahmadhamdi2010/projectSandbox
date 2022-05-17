package com.sde.passwordmanager.controllers;

import com.sde.passwordmanager.myDB;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class settingsComtroller {
    @FXML
    private PasswordField NowPassword;
    @FXML
    private TextField NowUsername;
    @FXML
    private PasswordField NowPin;

    @FXML
    public void AddPassword() throws SQLException {
        myDB mydb = new myDB();
        mydb.ConnectDb();
        mydb.update(NowUsername.getText(), NowPassword.getText(),NowPin.getText());
    }



}
