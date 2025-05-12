package com.monitorsensors.mapper;

import com.monitorsensors.dto.SensorRequestDTO;
import com.monitorsensors.dto.SensorResponseDTO;
import com.monitorsensors.model.Sensor;
import org.springframework.stereotype.Component;

@Component
public class SensorMapper {

    private final RangeMapper rangeMapper;

    public SensorMapper(RangeMapper rangeMapper) {
        this.rangeMapper = rangeMapper;
    }

    public Sensor toEntity(SensorRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Sensor sensor = new Sensor();
        sensor.setName(dto.getName());
        sensor.setModel(dto.getModel());
        sensor.setRange(rangeMapper.toEntity(dto.getRange()));
        sensor.setType(dto.getType());
        sensor.setUnit(dto.getUnit());
        sensor.setLocation(dto.getLocation());
        sensor.setDescription(dto.getDescription());

        return sensor;
    }

    public SensorResponseDTO toDto(Sensor entity) {
        if (entity == null) {
            return null;
        }

        SensorResponseDTO dto = new SensorResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setModel(entity.getModel());
        dto.setRange(rangeMapper.toDto(entity.getRange()));
        dto.setType(entity.getType());
        dto.setUnit(entity.getUnit());
        dto.setLocation(entity.getLocation());
        dto.setDescription(entity.getDescription());

        return dto;
    }

    public void updateEntityFromDto(SensorRequestDTO dto, Sensor entity) {
        if (dto == null) {
            return;
        }

        entity.setName(dto.getName());
        entity.setModel(dto.getModel());
        entity.setRange(rangeMapper.toEntity(dto.getRange()));
        entity.setType(dto.getType());
        entity.setUnit(dto.getUnit());
        entity.setLocation(dto.getLocation());
        entity.setDescription(dto.getDescription());
    }
}