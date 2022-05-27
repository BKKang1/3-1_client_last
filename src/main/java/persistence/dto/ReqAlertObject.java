package persistence.dto;

import java.io.Serializable;


public class ReqAlertObject implements Serializable {
    private static final long serialVersionUID = 2L;
    private String currencytmp; //
    private String alertAmount;

    public ReqAlertObject(String currencytmp, String alertAmount) {
        this.currencytmp = currencytmp;
        this.alertAmount = alertAmount;
    }

    public String getCurrencytmp() {
        return currencytmp;
    }

    public void setCurrencytmp(String currencytmp) {
        this.currencytmp = currencytmp;
    }

    public String getAlertAmount() {
        return alertAmount;
    }

    public void setAlertAmount(String alertAmount) {
        this.alertAmount = alertAmount;
    }
}
