package persistence.dto;


import java.io.Serializable;

public class ResAlertObject implements Serializable {
    private static final long serialVersionUID = 2L;
    private String currencytmp; //외화종류
    private String alertAmount; //알람설정한 값
    private boolean judgement; //도달했는디

    public ResAlertObject(String currencytmp, String alertAmount, boolean judgement) {
        this.currencytmp = currencytmp;
        this.alertAmount = alertAmount;
        this.judgement = judgement;
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

    public boolean isJudgement() {
        return judgement;
    }

    public void setJudgement(boolean judgement) {
        this.judgement = judgement;
    }
}
