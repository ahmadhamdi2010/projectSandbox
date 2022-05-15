package com.sde.passwordmanager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class signInController {
    @FXML
    private Label title;

    @FXML
    protected void menuSignUpClicked() {
        title.setText("Welcome to JavaFX Application!");
    }
}