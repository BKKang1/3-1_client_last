package persistence.dto;

import java.io.Serializable;


public class AnalysisDTO implements Serializable {
    private static final long serialVersionUID = 2L;
    String forex;
    double figure;

    public AnalysisDTO(String forex, double figure) {
        this.forex = forex;
        this.figure = figure;
    }

    public String getForex() {
        return forex;
    }

    public void setForex(String forex) {
        this.forex = forex;
    }

    public double getFigure() {
        return figure;
    }

    public void setFigure(double figure) {
        this.figure = figure;
    }
}
