package com.monitorsensors.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.monitorsensors.validation.ValidRange;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@ValidRange
public class RangeDTO {
    @Min(value = 0, message = "Значение 'from' должно быть положительным")
    @JsonProperty("from")
    private Integer fromValue;

    @Min(value = 0, message = "Значение 'to' должно быть положительным")
    @JsonProperty("to")
    private Integer toValue;
}