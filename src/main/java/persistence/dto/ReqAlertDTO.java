package persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ReqAlertDTO implements Serializable {
    private static final long serialVersionUID = 2L;
    ArrayList<ReqAlertObject> reqList;
}