package persistence.dto;

import java.io.Serializable;
import java.util.ArrayList;


public class ReqAlertDTO implements Serializable {
    private static final long serialVersionUID = 2L;
    ArrayList<ReqAlertObject> reqList;

    public ReqAlertDTO(ArrayList<ReqAlertObject> reqList) {
        this.reqList = reqList;
    }

    public ArrayList<ReqAlertObject> getReqList() {
        return reqList;
    }

    public void setReqList(ArrayList<ReqAlertObject> reqList) {
        this.reqList = reqList;
    }
}