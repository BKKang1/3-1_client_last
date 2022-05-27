package com.example.javafx_practice;

import com.example.javafx_practice.item.StageStore;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.javafx_practice.item.WindowSize.*;

public class ChoiceForexControllerToAnalysis implements Initializable {
    @FXML
    public ListView lstNationalChange;

    public String currencytmp = null;
    String[] currencyArrayList = {"AED/USD", "AUD/USD", "BHD/USD", "CAD/USD", "CHF/USD",
            "CNH/USD", "DKK/USD", "EUR/USD", "GBP/USD", "HKD/USD", "IDR/USD", "JPY/USD", "KWD/USD",
            "MYR/USD", "NOK/USD", "NZD/USD", "SAR/USD", "SEK/USD", "SGD/USD", "THB/USD"};


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lstNationalChange.setItems(FXCollections.observableArrayList(currencyArrayList));
        lstNationalChange.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String strItem = (String) lstNationalChange.getSelectionModel().getSelectedItem();
                currencytmp = strItem;
            }
        });

    }

    public void moveMain(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), MAIN_X, MAIN_Y);
        StageStore.stage.setTitle("Main");
        StageStore.stage.setScene(scene);
        StageStore.stage.show();
    }

    public void moveToAnalysis(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Analysis.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), ANALYSIS_X, ANALYSIS_Y);
        StageStore.stage.setTitle(currencytmp);
        StageStore.stage.setScene(scene);
        StageStore.stage.show();
    }
}
