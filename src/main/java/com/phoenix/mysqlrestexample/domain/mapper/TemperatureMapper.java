package com.phoenix.mysqlrestexample.domain.mapper;

import com.phoenix.mysqlrestexample.domain.dto.TemperatureDto;
import com.phoenix.mysqlrestexample.persistance.TemperatureEntity;
import com.phoenix.mysqlrestexample.service.TemperatureService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses= TemperatureService.class)
public interface TemperatureMapper {

    TemperatureDto temperatureEntityToTemperatureDto(TemperatureEntity temperatureEntity);

    TemperatureEntity temperatureDtoToTemperatureEntity(TemperatureDto temperatureDto);
}
