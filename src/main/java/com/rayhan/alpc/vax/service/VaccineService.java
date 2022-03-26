package com.rayhan.alpc.vax.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rayhan.alpc.vax.model.Vaccine;
import com.rayhan.alpc.vax.model.WeekMaxMin;
import com.rayhan.alpc.vax.model.WeekType;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * @author Khanza
 *
 */
public interface VaccineService {

    public List<Vaccine> getVaccines(String month, String state) throws JsonProcessingException, FileNotFoundException, IOException, ParseException;

    public List<WeekType> getVaccinesByType() throws JsonProcessingException, FileNotFoundException, IOException, ParseException;

    public List<WeekMaxMin> getVaccinesByMaxMin() throws JsonProcessingException, FileNotFoundException, IOException, ParseException;

}
