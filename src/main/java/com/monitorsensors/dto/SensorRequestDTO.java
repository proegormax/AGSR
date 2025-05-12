package com.monitorsensors.dto;

import com.monitorsensors.model.SensorType;
import com.monitorsensors.model.UnitType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SensorRequestDTO {
    @NotBlank(message = "Название датчика обязательно")
    @Size(min = 3, max = 30, message = "Название должно содержать от 3 до 30 символов")
    private String name;

    @NotBlank(message = "Модель датчика обязательна")
    @Size(max = 15, message = "Модель не должна превышать 15 символов")
    private String model;

    @NotNull(message = "Диапазон значений обязателен")
    private RangeDTO range;

    @NotNull(message = "Тип датчика обязателен")
    private SensorType type;

    private UnitType unit;

    @Size(max = 40, message = "Местоположение не должно превышать 40 символов")
    private String location;

    @Size(max = 200, message = "Описание не должно превышать 200 символов")
    private String description;
}