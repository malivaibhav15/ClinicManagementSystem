package com.BridgeLabz.Service;

import com.BridgeLabz.Interface.DoctorInterface;
import com.BridgeLabz.Interface.PatientInterface;
import com.BridgeLabz.Model.Appointment;
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

    @Override
    public boolean listOfPatient(String patientFilePath) {
        try {
            ArrayList<Patient> patientArrayList = fileSystem.readFilePatient(patientFilePath);
            patientArrayList.forEach((patientList) -> System.out.println(patientList));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean listOfDoctors(String doctorFilePath) {
        try {
            ArrayList<Doctor> doctorArrayList = fileSystem.readFileDoctor(doctorFilePath);
            doctorArrayList.forEach((doctorList) -> System.out.println(doctorList));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void searchDoctorByName(Doctor doctor, String doctorFilePath) throws IOException {
        ArrayList<Doctor> doctorArrayList = fileSystem.readFileDoctor(doctorFilePath);
        for (Doctor doctor1 : doctorArrayList) {
            if (doctor1.getName().equalsIgnoreCase(doctor.getName()))
                System.out.println("Entered name matched with the doctor : "+doctor1);
        }
    }

    @Override
    public void searchDoctorById(Doctor doctor, String doctorFilePath) throws IOException {
        ArrayList<Doctor> doctorArrayList = fileSystem.readFileDoctor(doctorFilePath);
        for (Doctor doctor1 : doctorArrayList) {
            if (doctor1.getId().equals(doctor.getId()))
                System.out.println("Entered id matched with the doctor : "+doctor1);
        }
    }

    @Override
    public void searchDoctorBySpecialization(Doctor doctor, String doctorFilePath) throws IOException {
        ArrayList<Doctor> doctorArrayList = fileSystem.readFileDoctor(doctorFilePath);
        for (Doctor doctor1 : doctorArrayList) {
            if (doctor1.getSpecialization().equalsIgnoreCase(doctor.getSpecialization()))
                System.out.println("Entered specialization matched with the doctor : "+doctor1);
        }
    }

    @Override
    public void searchDoctorByAvailability(Doctor doctor, String doctorFilePath) throws IOException {
        ArrayList<Doctor> doctorArrayList = fileSystem.readFileDoctor(doctorFilePath);
        for (Doctor doctor1 : doctorArrayList) {
            if (doctor1.getSchedule().equals(doctor.getSchedule()))
                System.out.println("Entered availability matched with the doctor : "+doctor1);
        }
    }

    @Override
    public void searchPatientByName(Patient patient, String patientFilePath) throws IOException {
        ArrayList<Patient> patientArrayList = fileSystem.readFilePatient(patientFilePath);
        for (Patient patient1 : patientArrayList) {
            if (patient1.getName().equalsIgnoreCase(patient.getName()))
                System.out.println("Entered name matched with patient : "+patient1);
        }

    }

    @Override
    public void searchPatientByMobile(Patient patient, String patientFilePath) throws IOException {
        ArrayList<Patient> patientArrayList = fileSystem.readFilePatient(patientFilePath);
        for (Patient patient1 : patientArrayList) {
            if (patient1.getMobileNumber().equals(patient.getMobileNumber()))
                System.out.println("Entered mobile number matched with patient : "+patient1);
        }
    }

    @Override
    public void searchPatientById(Patient patient, String patientFilePath) throws IOException {
        ArrayList<Patient> patientArrayList = fileSystem.readFilePatient(patientFilePath);
        for (Patient patient1 : patientArrayList) {
            if(patient1.getId().equals(patient.getId()))
                System.out.println("Entered id matched with patient : "+patient1);
        }
    }

    @Override
    public void popularSpecialization(Doctor doctor1, String doctorFilePath) throws IOException {
        ArrayList<Doctor> doctorArrayList = fileSystem.readFileDoctor(doctorFilePath);
        for (Doctor doctor : doctorArrayList) {
            if (doctor.getSpecialization().equalsIgnoreCase(doctor1.getSpecialization()))
                System.out.println("Popular specialization in this clinic is : " + doctor.getSpecialization());
        }
    }

    @Override
    public void popularDoctor(Doctor doctor4, String doctorFilePath) throws IOException {
        ArrayList<Doctor> doctorArrayList = fileSystem.readFileDoctor(doctorFilePath);
        for (Doctor doctor : doctorArrayList) {
            if (doctor.getName().equalsIgnoreCase(doctor4.getName()))
                System.out.println("Most popular doctor in this clinic is : Dr."+doctor.getName());
        }
    }

    @Override
    public void addAppointment(Appointment appointment, String appointmentFilePath) throws IOException {
        ArrayList<Appointment> data = fileSystem.readFileAppointment(appointmentFilePath);
        data.add(appointment);
        fileSystem.writeFileAppointment(data, appointmentFilePath);
    }
}
