package com.rayhan.alpc.vax.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rayhan.alpc.vax.model.MaxMin;
import com.rayhan.alpc.vax.model.Type;
import com.rayhan.alpc.vax.model.Vaccine;
import com.rayhan.alpc.vax.model.WeekMaxMin;
import com.rayhan.alpc.vax.service.VaccineService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VaccineController {

    private final VaccineService vaccineService;

    @GetMapping(value = "/vaccine", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doVaccines(@RequestParam String month, @RequestParam String state) throws JsonProcessingException, IOException, FileNotFoundException, ParseException {
        List<Vaccine> response = new ArrayList<>();
        response = vaccineService.getVaccines(month, state);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping(value = "/vaccine/max-min", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doVaccinesByMaxMin() throws JsonProcessingException, IOException, FileNotFoundException, ParseException {
        List<MaxMin> response = new ArrayList<>();
        response = vaccineService.getVaccinesByMaxMin();
        return ResponseEntity.ok(response);
    }
    
    @GetMapping(value = "/vaccine/type", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doVaccinesByType() throws JsonProcessingException, IOException, FileNotFoundException, ParseException {
        List<Type> response = new ArrayList<>();
        response = vaccineService.getVaccinesByType();
        return ResponseEntity.ok(response);
    }
    
    @GetMapping(value = "/vaccine/week", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doVaccinesByTypeWeek() throws JsonProcessingException, IOException, FileNotFoundException, ParseException {
        List<WeekMaxMin> response = new ArrayList<>();
        response = vaccineService.getVaccinesByTypeWeek();
        return ResponseEntity.ok(response);
    }

}
