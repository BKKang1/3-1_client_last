package persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class ReqSearchDTO implements Serializable {
    private static final long serialVersionUID = 2L;
    private String dateInput;
    private String forex;
}