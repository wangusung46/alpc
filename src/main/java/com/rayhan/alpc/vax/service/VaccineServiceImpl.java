package com.rayhan.alpc.vax.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rayhan.alpc.vax.model.Vaccine;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class VaccineServiceImpl implements VaccineService {

    @Override
    public List<Vaccine> getVaccines() throws JsonProcessingException, FileNotFoundException, IOException, ParseException {
        List<Vaccine> response = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("vax_state.csv"))) {
            String line;
            Long id = 1L;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (!line.equals("date,state,daily_partial,daily_full,daily_booster,daily,"
                        + "daily_partial_adol,daily_full_adol,daily_partial_child,daily_full_child,"
                        + "cumul_partial,cumul_full,cumul_booster,cumul,"
                        + "cumul_partial_adol,cumul_full_adol,cumul_partial_child,cumul_full_child,"
                        + "pfizer1,pfizer2,pfizer3,sinovac1,sinovac2,sinovac3,astra1,astra2,astra3,"
                        + "sinopharm1,sinopharm2,sinopharm3,cansino,cansino3,pending1,pending2,pending3")) {
                    Vaccine vaccine = new Vaccine();
                    vaccine.setId(id++);
                    vaccine.setDate(new SimpleDateFormat("yyyy-mm-dd").parse(values[0]));
                    vaccine.setState(values[1]);
                    vaccine.setDailyPartial(Integer.parseInt(values[2]));
                    vaccine.setDailyFull(Integer.parseInt(values[3]));
                    vaccine.setDailyBooster(Integer.parseInt(values[4]));
                    vaccine.setDaily(Integer.parseInt(values[5]));
                    vaccine.setDailyPartialAdol(Integer.parseInt(values[6]));
                    vaccine.setDailyFullAdol(Integer.parseInt(values[7]));
                    vaccine.setDailyPartialChild(Integer.parseInt(values[8]));
                    vaccine.setDailyFullChild(Integer.parseInt(values[9]));
                    vaccine.setCumulPartial(Integer.parseInt(values[10]));
                    vaccine.setCumulFull(Integer.parseInt(values[11]));
                    vaccine.setCumulBooster(Integer.parseInt(values[12]));
                    vaccine.setCumul(Integer.parseInt(values[13]));
                    vaccine.setCumulPartialAdol(Integer.parseInt(values[14]));
                    vaccine.setCumulFullAdol(Integer.parseInt(values[15]));
                    vaccine.setCumulPartialChild(Integer.parseInt(values[16]));
                    vaccine.setCumulFullChild(Integer.parseInt(values[17]));
                    vaccine.setPfizer1(Integer.parseInt(values[18]));
                    vaccine.setPfizer2(Integer.parseInt(values[19]));
                    vaccine.setPfizer3(Integer.parseInt(values[20]));
                    vaccine.setSinovac1(Integer.parseInt(values[21]));
                    vaccine.setSinovac2(Integer.parseInt(values[22]));
                    vaccine.setSinovac3(Integer.parseInt(values[23]));
                    vaccine.setAstra1(Integer.parseInt(values[24]));
                    vaccine.setAstra2(Integer.parseInt(values[25]));
                    vaccine.setAstra3(Integer.parseInt(values[26]));
                    vaccine.setSinopharm1(Integer.parseInt(values[27]));
                    vaccine.setSinopharm2(Integer.parseInt(values[28]));
                    vaccine.setSinopharm3(Integer.parseInt(values[29]));
                    vaccine.setCansino(Integer.parseInt(values[30]));
                    vaccine.setCansino3(Integer.parseInt(values[31]));
                    vaccine.setPending1(Integer.parseInt(values[32]));
                    vaccine.setPending2(Integer.parseInt(values[33]));
                    vaccine.setPending3(Integer.parseInt(values[34]));
                    response.add(vaccine);
                }
            }
        }
        return response;
    }

}
