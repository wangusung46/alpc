package com.rayhan.alpc.vax.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rayhan.alpc.vax.model.MaxMin;
import com.rayhan.alpc.vax.model.Type;
import com.rayhan.alpc.vax.model.Vaccine;
import com.rayhan.alpc.vax.model.WeekMaxMin;
import com.rayhan.alpc.vax.model.WeekType;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
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
    public List<Vaccine> getVaccines(String month, String state) throws JsonProcessingException, FileNotFoundException, IOException, ParseException {
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
                    if (!values[1].matches(".*" + state + ".*") && !state.isEmpty()) {
                        continue;
                    }
                    if (!values[0].matches(month + ".*") && !month.isEmpty()) {
                        continue;
                    }
                    Vaccine vaccine = new Vaccine();
                    vaccine.setId(id++);
                    vaccine.setDate(values[0]);
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

    @Override
    public List<WeekType> getVaccinesByType() throws JsonProcessingException, FileNotFoundException, IOException, ParseException {
        List<WeekType> response = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("vax_state.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (!line.equals("date,state,daily_partial,daily_full,daily_booster,daily,"
                        + "daily_partial_adol,daily_full_adol,daily_partial_child,daily_full_child,"
                        + "cumul_partial,cumul_full,cumul_booster,cumul,"
                        + "cumul_partial_adol,cumul_full_adol,cumul_partial_child,cumul_full_child,"
                        + "pfizer1,pfizer2,pfizer3,sinovac1,sinovac2,sinovac3,astra1,astra2,astra3,"
                        + "sinopharm1,sinopharm2,sinopharm3,cansino,cansino3,pending1,pending2,pending3")) {

                    WeekType weekType = new WeekType();
                    List<Type> types = new ArrayList<>();
                    LocalDate tempDate = LocalDate.of(1999, 1, 1);
                    Integer i = 1;
                    Type type1 = new Type();
                    Type type2 = new Type();
                    Type type3 = new Type();
                    Type type4 = new Type();
                    Type type5 = new Type();
                    Type type6 = new Type();
                    Type type7 = new Type();
                    Type type8 = new Type();
                    Type type9 = new Type();
                    Type type10 = new Type();
                    Type type11 = new Type();
                    Type type12 = new Type();
                    Type type13 = new Type();
                    Type type14 = new Type();

                    type1.setId(1L);
                    type1.setType("pfizer1");
                    type1.setTotal(Integer.parseInt(values[18]) + type1.getTotal());

                    type2.setId(2L);
                    type2.setType("pfizer2");
                    type2.setTotal(Integer.parseInt(values[19]) + type2.getTotal());

                    type3.setId(3L);
                    type3.setType("pfizer3");
                    type3.setTotal(Integer.parseInt(values[20]) + type3.getTotal());

                    type4.setId(4L);
                    type4.setType("sinovac1");
                    type4.setTotal(Integer.parseInt(values[21]) + type4.getTotal());

                    type5.setId(5L);
                    type5.setType("sinovac2");
                    type5.setTotal(Integer.parseInt(values[22]) + type5.getTotal());

                    type6.setId(6L);
                    type6.setType("sinovac3");
                    type6.setTotal(Integer.parseInt(values[23]) + type6.getTotal());

                    type7.setId(7L);
                    type7.setType("astra1");
                    type7.setTotal(Integer.parseInt(values[24]) + type7.getTotal());

                    type8.setId(8L);
                    type8.setType("astra2");
                    type8.setTotal(Integer.parseInt(values[25]) + type8.getTotal());

                    type9.setId(9L);
                    type9.setType("astra3");
                    type9.setTotal(Integer.parseInt(values[26]) + type9.getTotal());

                    type10.setId(10L);
                    type10.setType("sinopharm1");
                    type10.setTotal(Integer.parseInt(values[27]) + type10.getTotal());

                    type11.setId(11L);
                    type11.setType("sinopharm2");
                    type11.setTotal(Integer.parseInt(values[28]) + type11.getTotal());

                    type12.setId(12L);
                    type12.setType("sinopharm3");
                    type12.setTotal(Integer.parseInt(values[29]) + type12.getTotal());

                    type13.setId(13L);
                    type13.setType("cansino");
                    type13.setTotal(Integer.parseInt(values[30]) + type13.getTotal());

                    type14.setId(14L);
                    type14.setType("cansino3");
                    type14.setTotal(Integer.parseInt(values[31]) + type14.getTotal());

                    if (isLocalDateInTheSameWeek(tempDate, LocalDate.parse(values[0])) == false) {

                        tempDate = LocalDate.parse(values[0]);

                        types.add(type1);
                        types.add(type2);
                        types.add(type3);
                        types.add(type4);
                        types.add(type5);
                        types.add(type6);
                        types.add(type7);
                        types.add(type8);
                        types.add(type9);
                        types.add(type10);
                        types.add(type11);
                        types.add(type12);
                        types.add(type13);
                        types.add(type14);
                        weekType.setWeek("Week " + values[0]);
                        weekType.setTypes(types);
                        response.add(weekType);
                        i++;
                    }
                }
            }

        }
        return response;
    }

    @Override
    public List<WeekMaxMin> getVaccinesByMaxMin() throws JsonProcessingException, FileNotFoundException, IOException, ParseException {
        List<WeekMaxMin> response = new ArrayList<>();

        Integer maxAdult = Integer.MIN_VALUE;
        Integer minAdult = Integer.MAX_VALUE;
        Integer maxChild = Integer.MIN_VALUE;
        Integer minChild = Integer.MAX_VALUE;
        MaxMin maxMin = new MaxMin();
        LocalDate temp = LocalDate.of(1999, 1, 1);

        try (BufferedReader br = new BufferedReader(new FileReader("vax_state.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");
                if (!line.equals("date,state,daily_partial,daily_full,daily_booster,daily,"
                        + "daily_partial_adol,daily_full_adol,daily_partial_child,daily_full_child,"
                        + "cumul_partial,cumul_full,cumul_booster,cumul,"
                        + "cumul_partial_adol,cumul_full_adol,cumul_partial_child,cumul_full_child,"
                        + "pfizer1,pfizer2,pfizer3,sinovac1,sinovac2,sinovac3,astra1,astra2,astra3,"
                        + "sinopharm1,sinopharm2,sinopharm3,cansino,cansino3,pending1,pending2,pending3")) {
                    WeekMaxMin weekMaxMin = new WeekMaxMin();
                    List<MaxMin> maxMins = new ArrayList<>();
                    if (maxAdult < Integer.parseInt(values[6])) {
                        maxAdult = Integer.parseInt(values[6]);
                        maxMin.setMaxAdult(maxAdult);
                    }
                    if (minAdult > Integer.parseInt(values[6])) {
                        minAdult = Integer.parseInt(values[6]);
                        maxMin.setMinAdult(minAdult);
                    }
                    if (maxChild < Integer.parseInt(values[8])) {
                        maxChild = Integer.parseInt(values[8]);
                        maxMin.setMaxChild(maxChild);
                    }
                    if (minChild > Integer.parseInt(values[8])) {
                        minChild = Integer.parseInt(values[8]);
                        maxMin.setMinChild(minChild);
                    }
                    if (isLocalDateInTheSameWeek(temp, LocalDate.parse(values[0])) == false) {

                        temp = LocalDate.parse(values[0]);
                        maxAdult = Integer.MIN_VALUE;
                        minAdult = Integer.MAX_VALUE;
                        maxChild = Integer.MIN_VALUE;
                        minChild = Integer.MAX_VALUE;

                        maxMins.add(maxMin);
                        weekMaxMin.setMaxMins(maxMins);
                        response.add(weekMaxMin);
                    }

                }
            }

        }
        return response;
    }

    private Boolean isLocalDateInTheSameWeek(LocalDate date1, LocalDate date2) {
        LocalDate sundayBeforeDate1 = date1.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate saturdayAfterDate1 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        return ((date2.isEqual(sundayBeforeDate1) || date2.isAfter(sundayBeforeDate1))
                && (date2.isEqual(saturdayAfterDate1) || date2.isBefore(saturdayAfterDate1)));
    }

}
