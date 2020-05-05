package com.BridgeLabz.Service;

import com.BridgeLabz.Model.Doctor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileSystem
{
    ObjectMapper objectMapper = new ObjectMapper();

    public ArrayList<Doctor> readFile(String filePath) throws IOException {
        ArrayList<Doctor> data = objectMapper.readValue(new File(filePath), new TypeReference<ArrayList<Doctor>>(){});
        return data;
    }

    public void writeFile(ArrayList<Doctor> list, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), list);
    }
}
