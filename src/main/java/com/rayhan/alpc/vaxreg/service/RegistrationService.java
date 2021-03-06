package com.rayhan.alpc.vaxreg.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rayhan.alpc.vaxreg.model.Registration;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * @author Raihan
 *
 */
public interface RegistrationService {

//    INTERFACE REGISTRATION SERVICE
    public List<Registration> getRegistrations() throws JsonProcessingException, FileNotFoundException, IOException, ParseException;

}
