package com.monitorsensors.dto;

import com.monitorsensors.model.SensorType;
import com.monitorsensors.model.UnitType;
import lombok.Data;

@Data
public class SensorResponseDTO {
    private Long id;
    private String name;
    private String model;
    private RangeDTO range;
    private SensorType type;
    private UnitType unit;
    private String location;
    private String description;
}