package com.monitorsensors.mapper;

import com.monitorsensors.dto.RangeDTO;
import com.monitorsensors.model.Range;
import org.springframework.stereotype.Component;

@Component
public class RangeMapper {

    public Range toEntity(RangeDTO dto) {
        if (dto == null) {
            return null;
        }

        Range range = new Range();
        range.setFromValue(dto.getFromValue());
        range.setToValue(dto.getToValue());

        return range;
    }

    public RangeDTO toDto(Range entity) {
        if (entity == null) {
            return null;
        }

        RangeDTO dto = new RangeDTO();
        dto.setFromValue(entity.getFromValue());
        dto.setToValue(entity.getToValue());

        return dto;
    }
}