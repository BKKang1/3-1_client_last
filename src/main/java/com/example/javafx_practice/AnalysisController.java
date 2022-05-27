package com.example.javafx_practice;

import com.example.javafx_practice.item.StageStore;

import com.example.javafx_practice.item.WindowSize;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import persistence.dto.TableData;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnalysisController implements Initializable {
    public TextField txtResult;

    @FXML
    private TableView<TableData> tableView1;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        TableData[] tableData = new TableData[4];
        reqTableData();
        resTableData(tableData);
    }

    void reqTableData() {
        String title= StageStore.stage.getTitle();
        String forex =title.substring(0,3);

        //send() forex;

    }

    //회색 버튼 의 핸들러 부분 여기를 누르면 테이블뷰의 리스트가 출력됩니다.
    @FXML
    void resTableData(TableData[] tableData) {
        int score=0;

        tableData[0] = new TableData("1","2","3");
        tableData[1] = new TableData("4","5","6");
        tableData[2] = new TableData("7","8","9");
        tableData[3] = new TableData("10","11","12");



        TableColumn tableViewColumn1 = tableView1.getColumns().get(0);//테이블뷰의 첫번째 컬럼을 생성한다.
        tableViewColumn1.setCellValueFactory(new PropertyValueFactory("type"));

        TableColumn tableViewColumn2 = tableView1.getColumns().get(1);
        tableViewColumn2.setCellValueFactory(new PropertyValueFactory("figure"));

        TableColumn tableViewColumn3 = tableView1.getColumns().get(2);
        tableViewColumn3.setCellValueFactory(new PropertyValueFactory("analysis"));

        for(int i=0;i<4;i++){
            TableData data = new TableData(tableData[i].getType(),tableData[i].getFigure(),tableData[i].getAnalysis());
            tableView1.getItems().add(data);
            score+=Integer.valueOf(tableData[i].getAnalysis()) ;
        }

        if (score>10){
            txtResult.setText("지표 분석 결과 : 매수 강력 권고");
        }else if (score>5){
            txtResult.setText("지표 분석 결과 : 매수 권고");
        }else if (score>0){
            txtResult.setText("지표 분석 결과 : 보통");
        }else if (score>-5){
            txtResult.setText("지표 분석 결과 : 매도 권고");
        }else{
            txtResult.setText("지표 분석 결과 : 매도 강력 권고");
        }

    }


    public void moveMain(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WindowSize.MAIN_X, WindowSize.MAIN_Y);
        StageStore.stage.setTitle("Main");
        StageStore.stage.setScene(scene);
        StageStore.stage.show();
    }
}


