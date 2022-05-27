package persistence.dto;


import java.io.Serializable;

public class ResTableDTO implements Serializable {
    private static final long serialVersionUID = 2L;
    private TableData[] tableData = new TableData[3];

    public ResTableDTO(TableData[] tableData) {
        this.tableData = tableData;
    }

    public TableData[] getTableData() {
        return tableData;
    }

    public void setTableData(TableData[] tableData) {
        this.tableData = tableData;
    }
}
