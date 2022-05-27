package com.example.javafx_practice.item;

import com.example.javafx_practice.Protocol;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import persistence.dto.ReqAlertDTO;
import persistence.dto.ReqAlertObject;
import persistence.dto.ResAlertDTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TimerAlert  {
    private static ArrayList<ReqAlertObject> timerArrList = new ArrayList<ReqAlertObject>();

    private static TextField textField;

    public static void setTextField(TextField tf){
        textField = tf;
        System.out.println(tf.toString());
    }
    public static void run() {
        try {
        while(Protocol.conn.isConnected()){
            Thread.sleep(10000);
            reqAlert();
            Thread.sleep(500000);
        }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }



    private static ReqAlertDTO read() {
        ArrayList<String> aLines = null;
        File alertFile = new File("C:\\fxfile\\Alert.txt");
        if (alertFile.exists()) {
            try {
                FileReader aReader = new FileReader(alertFile);
                BufferedReader aBufReader = new BufferedReader(aReader);
                aLines = new ArrayList<String>();
                String aLine = "";
                while ((aLine = aBufReader.readLine()) != null) {
                    aLines.add(aLine);
                }
                aBufReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < aLines.size(); i++) {
                String deleteAlertArr = aLines.get(i);
                String[] tmpArray = deleteAlertArr.split(" ");
                String currencytmp = tmpArray[0];
                String alertAmount = tmpArray[1];
                //여기까지 currencytmp는 AED, alertAmount는 1000나오고 있음
                ReqAlertObject alertObject = new ReqAlertObject(currencytmp, alertAmount);
                timerArrList.add(alertObject);

            }
        }
        return new ReqAlertDTO(timerArrList);
    }

    private static void reqAlert() throws IOException {
        ReqAlertDTO reqAlertObjectDTO = read();
        Protocol.requestToServer(Protocol.TYPE_REQ_ALERT,Protocol.CODE_REQ_ALERT,reqAlertObjectDTO);
        Protocol.receiveData();
    }
    public static void resAlert(byte[] data) throws IOException, ClassNotFoundException {

        ResAlertDTO resAlertDTO = (ResAlertDTO) Protocol.convertBytesToObject(data);
        for(int i=0; i<resAlertDTO.getResList().size(); i++) {
            if(resAlertDTO.getResList().get(i).isJudgement() == true) {
                String currency_Alert = resAlertDTO.getResList().get(i).getCurrencytmp();
                String amount_Alert = resAlertDTO.getResList().get(i).getAlertAmount();


                System.out.println("tb");

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Look, a Warning Dialog");
                alert.setContentText(currency_Alert+" "+amount_Alert+" 도달");

                alert.showAndWait();
            }
        }
    }

}
