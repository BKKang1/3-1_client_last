package persistence.dto;


import java.io.Serializable;


public class TableData implements Serializable {
    private static final long serialVersionUID = 2L;
    String type = ""; //분석종류
    String figure = ""; //수치
    String analysis = ""; //분석점수

    public TableData(String type, String figure, String analysis) {
        this.type = type;
        this.figure = figure;
        this.analysis = analysis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
}
