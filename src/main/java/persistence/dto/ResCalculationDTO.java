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
public class ResCalculationDTO implements Serializable {
    private static final long serialVersionUID = 2L;
    private double resultExchange;
}
