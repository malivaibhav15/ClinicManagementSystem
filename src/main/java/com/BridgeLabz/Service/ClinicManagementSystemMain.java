package com.BridgeLabz.Service;

import com.BridgeLabz.Interface.DoctorInterface;
import com.BridgeLabz.Interface.PatientInterface;
import com.BridgeLabz.Model.Doctor;
import com.BridgeLabz.Model.Patient;

import java.io.IOException;
import java.util.ArrayList;

public class ClinicManagementSystemMain implements DoctorInterface, PatientInterface {

    FileSystem fileSystem = new FileSystem();

    @Override
    public void addDoctor(Doctor doctor, String filePath) throws IOException {
        ArrayList<Doctor> data = fileSystem.readFileDoctor(filePath);
        data.add(doctor);
        fileSystem.writeFileDoctor(data, filePath);
    }

    @Override
    public void addPatient(Patient patient, String filePath) throws IOException {
        ArrayList<Patient> data = fileSystem.readFilePatient(filePath);
        data.add(patient);
        fileSystem.writeFilePatient(data, filePath);
    }
}
