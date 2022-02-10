package com.phoenix.mysqlrestexample.domain.dto;

import java.time.ZonedDateTime;

public class TemperatureDto {
    private ZonedDateTime dateTime;
    private double temperature;

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
