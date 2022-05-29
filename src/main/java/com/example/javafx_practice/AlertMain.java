package com.example.javafx_practice;

import com.example.javafx_practice.item.StageStore;
import com.example.javafx_practice.item.TimerAlert;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.javafx_practice.item.WindowSize;
import java.io.IOException;
import java.net.Socket;

public class AlertMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AlertTask alertTask = new AlertTask();
        alertTask.run();


    }

    public static void main(String[] args) {
        launch();
    }



    static class AlertTask implements Runnable{

        @Override
        public void run() {
            Protocol.connect("localhost",10001);
            TimerAlert.run();
        }
    }

}