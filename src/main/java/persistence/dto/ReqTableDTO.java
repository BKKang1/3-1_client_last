package persistence.dto;


import java.io.Serializable;


public class ReqTableDTO implements Serializable {
    private static final long serialVersionUID = 2L;
    private String forex; //외화종류

    public ReqTableDTO(String forex) {
        this.forex = forex;
    }

    public String getForex() {
        return forex;
    }

    public void setForex(String forex) {
        this.forex = forex;
    }
}
