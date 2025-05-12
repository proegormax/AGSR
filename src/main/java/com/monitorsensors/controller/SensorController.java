package com.monitorsensors.controller;

import com.monitorsensors.dto.SensorRequestDTO;
import com.monitorsensors.dto.SensorResponseDTO;
import com.monitorsensors.service.SensorDtoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@RequiredArgsConstructor
@Tag(name = "Sensors", description = "API для работы с датчиками")
@SecurityRequirement(name = "basicAuth")
public class SensorController {

    private final SensorDtoService sensorService;

    @GetMapping
    @PreAuthorize("hasAnyRole('VIEWER', 'ADMINISTRATOR')")
    @Operation(summary = "Получить список всех датчиков")
    public List<SensorResponseDTO> getAllSensors() {
        return sensorService.getAllSensors();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('VIEWER', 'ADMINISTRATOR')")
    @Operation(summary = "Получить датчик по ID")
    public SensorResponseDTO getSensorById(@PathVariable Long id) {
        return sensorService.getSensorById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @Operation(summary = "Создать новый датчик")
    public SensorResponseDTO createSensor(@Valid @RequestBody SensorRequestDTO requestDTO) {
        return sensorService.createSensor(requestDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @Operation(summary = "Обновить существующий датчик")
    public SensorResponseDTO updateSensor(@PathVariable Long id, @Valid @RequestBody SensorRequestDTO requestDTO) {
        return sensorService.updateSensor(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @Operation(summary = "Удалить датчик")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id) {
        sensorService.deleteSensor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('VIEWER', 'ADMINISTRATOR')")
    @Operation(summary = "Поиск датчиков по названию или модели")
    public List<SensorResponseDTO> searchSensors(@RequestParam String query) {
        return sensorService.searchSensors(query);
    }
}
