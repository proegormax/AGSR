package com.monitorsensors.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sensors")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String model;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "fromValue", column = @Column(name = "from_value", nullable = false)),
            @AttributeOverride(name = "toValue", column = @Column(name = "to_value", nullable = false))
    })
    private Range range;

    @Enumerated(EnumType.STRING)
    private SensorType type;

    @Enumerated(EnumType.STRING)
    private UnitType unit;

    private String location;

    private String description;
}