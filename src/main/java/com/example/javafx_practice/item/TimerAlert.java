package com.example.javafx_practice.item;

import com.example.javafx_practice.Protocol;
import javafx.scene.control.Alert;
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

    public static void run() {
        try {
        while(Protocol.conn.isConnected()){
            reqAlert();
            Thread.sleep(600000);
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
//        여기서 서버로부터 ResAlertDTO 즉, ResAlertObject가 담긴 arraylist를 받게됨.
//        그러면 서버로부터 받은 arraylist를 for문을 돌려서 하나씩 까보는데 judgement가 true 값이면 Alert를 띄워서 사용자에게 알리는거지
            ResAlertDTO resAlertDTO = (ResAlertDTO) Protocol.convertBytesToObject(data);
            for(int i=0; i<resAlertDTO.getResList().size(); i++) {
                if(resAlertDTO.getResList().get(i).isJudgement() == true) {
                    String currency_Alert = resAlertDTO.getResList().get(i).getCurrencytmp();
                    String amount_Alert = resAlertDTO.getResList().get(i).getAlertAmount();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("CONFIRMATION");
                    alert.setHeaderText("Look, a CONFIRMATION");
                    alert.setContentText(currency_Alert + " " + amount_Alert + "  설정금액에 도달하였습니다.");
                    alert.showAndWait();
            return;
                }
            }
    }

}
