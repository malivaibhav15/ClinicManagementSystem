package com.BridgeLabz.Service;

import com.BridgeLabz.Model.Doctor;
import com.BridgeLabz.Model.Patient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileSystem {
    ObjectMapper objectMapper = new ObjectMapper();

    public ArrayList<Doctor> readFileDoctor(String filePath) throws IOException {
        ArrayList<Doctor> data = objectMapper.readValue(new File(filePath), new TypeReference<ArrayList<Doctor>>() {});
        return data;
    }

    public void writeFileDoctor(ArrayList<Doctor> list, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), list);
    }

    public ArrayList<Patient> readFilePatient(String filePath) throws IOException {
        ArrayList<Patient> data = objectMapper.readValue(new File(filePath), new TypeReference<ArrayList<Patient>>() {});
        return data;
    }

    public void writeFilePatient(ArrayList<Patient> list, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), list);
    }


}
