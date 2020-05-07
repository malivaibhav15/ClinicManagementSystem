package com.BridgeLabz.Interface;

import com.BridgeLabz.Model.Doctor;

import java.io.IOException;

public interface DoctorInterface
{
    void addDoctor(Doctor doctor, String filePath) throws IOException;

    void updateDoctor(Doctor doctor, String doctorFilePath) throws IOException;

    boolean listOfDoctors(String doctorFilePath) throws IOException;
}
