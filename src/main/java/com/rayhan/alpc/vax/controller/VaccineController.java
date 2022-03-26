package com.rayhan.alpc.vax.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rayhan.alpc.vax.model.Vaccine;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VaccineController {

    private final VaccineService vaccineService;

    @GetMapping(value = "/vaccine", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doVaccines() throws JsonProcessingException, IOException, FileNotFoundException, ParseException {
        List<Vaccine> response = new ArrayList<>();
        response = vaccineService.getVaccines();
        return ResponseEntity.ok(response);
    }

}
