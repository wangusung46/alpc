package com.rayhan.alpc.vaxreg.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rayhan.alpc.vaxreg.model.Registration;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

//    FOR REGISTRATION SERVICE
    @Override
    public List<Registration> getRegistrations() throws JsonProcessingException, FileNotFoundException, IOException, ParseException {
        List<Registration> response = new ArrayList<>();
        Long id = 1L;
        try (BufferedReader br = new BufferedReader(new FileReader("vaxreg_state.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (!line.equals("date,state,total,phase2,mysj,call,web,children,children_solo,adolescents,elderly,comorb,oku")) {
                    Registration registration = new Registration();
                    registration.setId(id++);
                    registration.setDate(values[0]);
                    registration.setState(values[1]);
                    registration.setTotal(Integer.parseInt(values[2]));
                    registration.setPhase(Integer.parseInt(values[3]));
                    registration.setMysj(Integer.parseInt(values[4]));
                    registration.setCall(Integer.parseInt(values[5]));
                    registration.setWeb(Integer.parseInt(values[6]));
                    registration.setChildren(Integer.parseInt(values[7]));
                    registration.setChildrenSolo(Integer.parseInt(values[8]));
                    registration.setAdolescents(Integer.parseInt(values[9]));
                    registration.setElderly(Integer.parseInt(values[10]));
                    registration.setComorb(Integer.parseInt(values[11]));
                    registration.setOku(Integer.parseInt(values[12]));
                    response.add(registration);
                }
            }
        }
        return response;
    }

}
