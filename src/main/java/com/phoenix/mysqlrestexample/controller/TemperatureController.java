package com.phoenix.mysqlrestexample.controller;

import com.phoenix.mysqlrestexample.domain.dto.TemperatureDto;
import com.phoenix.mysqlrestexample.service.TemperatureService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/temperature")
public class TemperatureController {

    private final TemperatureService temperatureService;

    @Autowired
    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TemperatureDto>> getAllTemperatures() {

        return ResponseEntity.ok(temperatureService.getAllTemperatures());
    }

    @GetMapping("/datetime/{dateTime}")
    public ResponseEntity<TemperatureDto> getTemperature(@Parameter(description="1999-12-31T13:13:59") @PathVariable(value = "dateTime") String dateTime) {

        return ResponseEntity.ok(temperatureService.getTemperature(dateTime));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTemperature(@RequestBody TemperatureDto temperatureDto) {
        temperatureService.saveTemperature(temperatureDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTemperature(@PathVariable int id) {
        temperatureService.deleteTemperature(id);
    }

}
