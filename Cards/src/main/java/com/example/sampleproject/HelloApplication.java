package com.example.sampleproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EntranceWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        stage.setTitle("Карты, нет денег, но шесть ноутбуков");
        stage.setScene(scene);
        stage.show();
    }
    static int AmountOfCardsFirstPlayer = 0;
    public static void main(String[] args) {
        launch();
    }
}