package com.BridgeLabz.Interface;

import com.BridgeLabz.Model.Appointment;
import com.BridgeLabz.Model.Doctor;

import java.io.IOException;

public interface DoctorInterface
{
    void addDoctor(Doctor doctor, String filePath) throws IOException;

    void updateDoctor(Doctor doctor, String doctorFilePath) throws IOException;

    boolean listOfDoctors(String doctorFilePath) throws IOException;

    void searchDoctorByName(Doctor doctor, String doctorFilePath) throws IOException;

    void popularSpecialization(Doctor doctor1, String doctorFilePath) throws IOException;

    void popularDoctor(Doctor doctor4, String doctorFilePath) throws IOException;

    void searchDoctorById(Doctor doctor, String doctorFilePath) throws IOException;

    void searchDoctorBySpecialization(Doctor doctor, String doctorFilePath) throws IOException;

    void searchDoctorByAvailability(Doctor doctor, String doctorFilePath) throws IOException;

    void addAppointment(Appointment appointment, String appointmentFilePath) throws IOException;
}
