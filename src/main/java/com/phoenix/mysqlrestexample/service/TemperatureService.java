package com.phoenix.mysqlrestexample.service;

import com.phoenix.mysqlrestexample.domain.dto.TemperatureDto;
import com.phoenix.mysqlrestexample.domain.mapper.TemperatureMapper;
import com.phoenix.mysqlrestexample.exception.BadRequestException;
import com.phoenix.mysqlrestexample.persistance.TemperatureEntity;
import com.phoenix.mysqlrestexample.persistance.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class TemperatureService {

    private final TemperatureRepository temperatureRepository;
    private final TemperatureMapper temperatureMapper;

    @Autowired
    public TemperatureService(TemperatureRepository temperatureRepository,
                              TemperatureMapper temperatureMapper) {
        this.temperatureRepository = temperatureRepository;
        this.temperatureMapper = temperatureMapper;
    }

    public TemperatureDto getTemperature(String dateTime) {
        ZonedDateTime zonedDateTime;
        try {
            zonedDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME).atZone(ZoneId.systemDefault());
        } catch (DateTimeParseException e) {
            throw new BadRequestException("Invalid date time format");
        }

        TemperatureEntity temperatureEntity = temperatureRepository.findByDateTime(zonedDateTime);
        return temperatureMapper.temperatureEntityToTemperatureDto(temperatureEntity);
    }

    public void saveTemperature(TemperatureDto temperatureDto) {
        TemperatureEntity temperatureEntity = temperatureMapper.temperatureDtoToTemperatureEntity(temperatureDto);
        temperatureRepository.save(temperatureEntity);
    }

    public void deleteTemperature(int id) {
        temperatureRepository.deleteById(id);
    }

}
