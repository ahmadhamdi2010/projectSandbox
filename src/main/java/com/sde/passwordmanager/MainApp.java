package com.sde.passwordmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    int CurrentUserID = -1;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("signIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("PswrdManager - Sign in");
        stage.setScene(scene);
        stage.show();

    }

    public int getCurrentUserID(){
        return CurrentUserID;
    }

    public static void main(String[] args) {
        launch();
    }
}