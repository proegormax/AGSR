package com.monitorsensors.service;

import com.monitorsensors.dto.SensorRequestDTO;
import com.monitorsensors.dto.SensorResponseDTO;
import com.monitorsensors.mapper.SensorMapper;
import com.monitorsensors.model.Sensor;
import com.monitorsensors.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class SensorDtoService {
    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;

    public List<SensorResponseDTO> getAllSensors() {
        return sensorRepository.findAll().stream()
                .map(sensorMapper::toDto)
                .collect(Collectors.toList());
    }

    public SensorResponseDTO getSensorById(Long id) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Датчик не найден"));
        return sensorMapper.toDto(sensor);
    }

    public SensorResponseDTO createSensor(SensorRequestDTO requestDTO) {
        Sensor sensor = sensorMapper.toEntity(requestDTO);
        sensor = sensorRepository.save(sensor);
        return sensorMapper.toDto(sensor);
    }

    public SensorResponseDTO updateSensor(Long id, SensorRequestDTO requestDTO) {
        if (!sensorRepository.existsById(id)) {
            throw new RuntimeException("Датчик не найден");
        }
        
        Sensor sensor = sensorRepository.findById(id).orElseThrow();
        sensorMapper.updateEntityFromDto(requestDTO, sensor);
        sensor = sensorRepository.save(sensor);
        return sensorMapper.toDto(sensor);
    }

    public void deleteSensor(Long id) {
        if (!sensorRepository.existsById(id)) {
            throw new RuntimeException("Датчик не найден");
        }
        sensorRepository.deleteById(id);
    }

    public List<SensorResponseDTO> searchSensors(String query) {
        return sensorRepository.searchByNameOrModel(query).stream()
                .map(sensorMapper::toDto)
                .collect(Collectors.toList());
    }
}