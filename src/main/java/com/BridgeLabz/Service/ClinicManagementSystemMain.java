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
    public void updateDoctor(Doctor doctor, String doctorFilePath) throws IOException {
        ArrayList<Doctor> doctorArrayList = fileSystem.readFileDoctor(doctorFilePath);
        for (Doctor doctor1 : doctorArrayList) {
            if (doctor1.getId().equalsIgnoreCase(doctor.getId()))
                doctor1.setSchedule(doctor.getSchedule());
            fileSystem.writeFileDoctor(doctorArrayList, doctorFilePath);
        }
    }

    @Override
    public void addPatient(Patient patient, String filePath) throws IOException {
        ArrayList<Patient> data = fileSystem.readFilePatient(filePath);
        data.add(patient);
        fileSystem.writeFilePatient(data, filePath);
    }

    @Override
    public void updatePatient(Patient patient, String patientFilePath) throws IOException {
     ArrayList<Patient> data = fileSystem.readFilePatient(patientFilePath);
        for (Patient patient1 : data) {
            if (patient1.getId().equals(patient.getId()))
                patient1.setMobileNumber(patient.getMobileNumber());
            fileSystem.writeFilePatient(data, patientFilePath);
        }
    }
}
