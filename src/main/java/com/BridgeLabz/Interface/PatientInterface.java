package com.BridgeLabz.Interface;

import com.BridgeLabz.Model.Patient;

import java.io.IOException;

public interface PatientInterface
{
    void addPatient(Patient patient, String filePath) throws IOException;

    void updatePatient(Patient patient, String patientFilePath) throws IOException;

    boolean listOfPatient(String patientFilePath);

    void searchPatientByName(Patient patient, String patientFilePath) throws IOException;

    void searchPatientByMobile(Patient patient, String patientFilePath) throws IOException;

    void searchPatientById(Patient patient, String patientFilePath) throws IOException;
}
