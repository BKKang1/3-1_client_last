package com.example.javafx_practice.item;

import com.example.javafx_practice.Protocol;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import persistence.dto.ReqTableDTO;
import persistence.dto.ResTableDTO;
import persistence.dto.TableData;

import java.io.IOException;

public class Analysis {
    private static  TextField txtResult;
    private static TableView<TableData> tableView1;
    private static String forex;
    public static void setAnalysis(TextField tf,TableView<TableData> tv){
        txtResult = tf;
        tableView1 = tv;
    }
    public static void setForex(String f){
        forex = f;
    }

    public static void reqTableData(){
        ReqTableDTO reqTableDTO = new ReqTableDTO(forex);
        try {
            Protocol.requestToServer(Protocol.TYPE_REQ_ANALYSIS,Protocol.CODE_REQ_ANALYSIS,reqTableDTO);
            Protocol.receiveData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void resTableData(byte[] data){
        try {
            int score=0;
            ResTableDTO resTableDTO = (ResTableDTO) Protocol.convertBytesToObject(data);
            TableData[] tableDataArr = resTableDTO.getTableData();

            TableColumn tableViewColumn1 = tableView1.getColumns().get(0);//테이블뷰의 첫번째 컬럼을 생성한다.
            tableViewColumn1.setCellValueFactory(new PropertyValueFactory("type"));

            TableColumn tableViewColumn2 = tableView1.getColumns().get(1);
            tableViewColumn2.setCellValueFactory(new PropertyValueFactory("figure"));

            TableColumn tableViewColumn3 = tableView1.getColumns().get(2);
            tableViewColumn3.setCellValueFactory(new PropertyValueFactory("analysis"));

            for(int i=0;i<3;i++){
                TableData tableData = new TableData(tableDataArr[i].getType(),tableDataArr[i].getFigure(),tableDataArr[i].getAnalysis());
                tableView1.getItems().add(tableData);
                score+=Integer.valueOf(tableDataArr[i].getAnalysis()) ;
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


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
