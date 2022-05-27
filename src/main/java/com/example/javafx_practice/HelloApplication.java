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

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        StageStore.stage =stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),WindowSize.MAIN_X , WindowSize.MAIN_Y);
        stage.setTitle("MAIN");
        stage.setScene(scene);
        stage.show();
        try {
            Protocol.connect("localhost",8888);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AlertTask alertTask = new AlertTask();
        alertTask.run();
    }

    public static void main(String[] args) {
        launch();
    }

    static class AlertTask implements Runnable{

        @Override
        public void run() {
            try {
                    Protocol.connect("localhost",9000);
                    TimerAlert.run();
                } catch (IOException e) {
                    e.printStackTrace();
            }
        }
    }
}