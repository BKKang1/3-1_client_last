package persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ReqGraphDTO implements Serializable {
    private static final long serialVersionUID = 2L;
    private String startDate;
    private String endDate;
    private String forex;
}
