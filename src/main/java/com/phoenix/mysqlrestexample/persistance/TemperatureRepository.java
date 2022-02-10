package com.phoenix.mysqlrestexample.persistance;

import org.springframework.data.repository.CrudRepository;

import java.time.ZonedDateTime;

public interface TemperatureRepository extends CrudRepository<TemperatureEntity, Integer> {
    TemperatureEntity findByDateTime(ZonedDateTime dateTime);
}
