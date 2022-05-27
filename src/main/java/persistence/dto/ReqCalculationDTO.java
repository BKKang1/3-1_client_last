package persistence.dto;


import java.io.Serializable;


public class ReqCalculationDTO implements Serializable {
    private static final long serialVersionUID = 2L;
    private String currencytmp;
    private String exchangeOption;
    private long currentExchange;

    public ReqCalculationDTO(String currencytmp, String exchangeOption, long currentExchange) {
        this.currencytmp = currencytmp;
        this.exchangeOption = exchangeOption;
        this.currentExchange = currentExchange;
    }

    public String getCurrencytmp() {
        return currencytmp;
    }

    public void setCurrencytmp(String currencytmp) {
        this.currencytmp = currencytmp;
    }

    public String getExchangeOption() {
        return exchangeOption;
    }

    public void setExchangeOption(String exchangeOption) {
        this.exchangeOption = exchangeOption;
    }

    public long getCurrentExchange() {
        return currentExchange;
    }

    public void setCurrentExchange(long currentExchange) {
        this.currentExchange = currentExchange;
    }
}
