package persistence.dto;


import java.io.Serializable;
import java.util.ArrayList;


public class ResAlertDTO implements Serializable {
    private static final long serialVersionUID = 2L;
    ArrayList<ResAlertObject> resList;

    public ResAlertDTO(ArrayList<ResAlertObject> resList) {
        this.resList = resList;
    }

    public ArrayList<ResAlertObject> getResList() {
        return resList;
    }

    public void setResList(ArrayList<ResAlertObject> resList) {
        this.resList = resList;
    }
}
