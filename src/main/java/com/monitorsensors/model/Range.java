package com.monitorsensors.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Range {
    private Integer fromValue;
    private Integer toValue;
}