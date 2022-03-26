package com.rayhan.alpc.vaxreg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rayhan.alpc.vaxreg.model.Registration;
import com.rayhan.alpc.vaxreg.service.RegistrationService;
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
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doRegistrations() throws JsonProcessingException, IOException, FileNotFoundException, ParseException {
        List<Registration> response = new ArrayList<>();
        response = registrationService.getRegistrations();
        return ResponseEntity.ok(response);
    }

}
