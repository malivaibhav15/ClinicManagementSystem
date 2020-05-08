package com.BridgeLabz;

import com.BridgeLabz.Interface.DoctorInterface;
import com.BridgeLabz.Interface.PatientInterface;
import com.BridgeLabz.Model.Doctor;
import com.BridgeLabz.Model.Patient;
import com.BridgeLabz.Service.ClinicManagementSystemMain;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TestCaseForClinicManagementSystem {

    String doctorFilePath = "src/main/resources/AddDoctor.json";
    String patientFilePath = "src/main/resources/AddPatient.json";
    ClinicManagementSystemMain clinicManagementSystemMain = new ClinicManagementSystemMain();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void givenAddDoctor_WhenProper_ShouldReturnTrue() throws IOException {
        Doctor doctor1 = new Doctor("Vaibhav","101","Surgery","10-11");
        Doctor doctor2 = new Doctor("Vishal","102","Gynaecologist","11-12");
        Doctor doctor3 = new Doctor("Shailesh","103","Dentist","12-1");
        Doctor doctor4 = new Doctor("Deepak","104","Psychiatrist","1-2");
        clinicManagementSystemMain.addDoctor(doctor1,doctorFilePath);
        clinicManagementSystemMain.addDoctor(doctor2,doctorFilePath);
        clinicManagementSystemMain.addDoctor(doctor3,doctorFilePath);
        clinicManagementSystemMain.addDoctor(doctor4,doctorFilePath);
        ArrayList<Doctor> data = objectMapper.readValue(new File(doctorFilePath), new TypeReference<ArrayList<Doctor>>(){});
        Assert.assertEquals(doctor1.getName(), data.get(0).getName());
        Assert.assertEquals(doctor2.getName(), data.get(1).getName());
        Assert.assertEquals(doctor3.getName(), data.get(2).getName());
        Assert.assertEquals(doctor4.getName(), data.get(3).getName());
    }

    @Test
    public void givenAddPatient_WhenProper_ShouldReturnTrue() throws IOException {
        Patient patient1 = new Patient("Abc", "1", "1213456798", "24");
        Patient patient2 = new Patient("Pqr", "2", "3216549876", "25");
        Patient patient3 = new Patient("Mno", "3", "7410258963", "26");
        Patient patient4 = new Patient("Xyz", "4", "9876541238", "27");
        clinicManagementSystemMain.addPatient(patient1, patientFilePath);
        clinicManagementSystemMain.addPatient(patient2, patientFilePath);
        clinicManagementSystemMain.addPatient(patient3, patientFilePath);
        clinicManagementSystemMain.addPatient(patient4, patientFilePath);
        ArrayList<Patient> data = objectMapper.readValue(new File(patientFilePath), new TypeReference<ArrayList<Patient>>(){});
        Assert.assertEquals(patient1.getName(), data.get(0).getName());
        Assert.assertEquals(patient2.getName(), data.get(1).getName());
        Assert.assertEquals(patient3.getName(), data.get(2).getName());
        Assert.assertEquals(patient4.getName(), data.get(3).getName());
    }

    @Test
    public void givenDoctor_WhenUpdate_ShouldReturnTrue() throws IOException {
        Doctor doctor = new Doctor("Deepak","104","Psychiatrist","5-6");
        clinicManagementSystemMain.updateDoctor(doctor, doctorFilePath);
        ArrayList<Doctor> data = objectMapper.readValue(new File(doctorFilePath), new TypeReference<ArrayList<Doctor>>(){});
        Assert.assertEquals(doctor.getSchedule(), data.get(3).getSchedule());
    }

    @Test
    public void givenPatient_WhenUpdate_ShouldReturnTrue() throws IOException {
        Patient patient = new Patient("Mno", "3", "3212301785", "26");
        clinicManagementSystemMain.updatePatient(patient, patientFilePath);
        ArrayList<Patient> data = objectMapper.readValue(new File(patientFilePath), new TypeReference<ArrayList<Patient>>(){});
        Assert.assertEquals(patient.getMobileNumber(), data.get(2).getMobileNumber());
    }

    @Test
    public void givenWhenUser_ChoosesToSeeDoctorList_ShouldReturnList() throws IOException {
        boolean doctorList = clinicManagementSystemMain.listOfDoctors(doctorFilePath);
        Assert.assertTrue(doctorList);
    }

    @Test
    public void givenWhenUser_ChoosesToSeePatientList_ShouldReturnList() {
        boolean patientList = clinicManagementSystemMain.listOfPatient(patientFilePath);
        Assert.assertTrue(patientList);
    }

    @Test
    public void givenWhenUserChooses_ToSearchDoctorByName_ShouldReturnSearchedResult() throws IOException {
        Doctor doctor = new Doctor("Vaibhav", "101", "Surgery", "10-11");
        clinicManagementSystemMain.searchDoctorByName(doctor, doctorFilePath);
        ArrayList<Doctor> data = objectMapper.readValue(new File(doctorFilePath), new TypeReference<ArrayList<Doctor>>(){});
        Assert.assertEquals(doctor.getName(), data.get(0).getName());
    }

    @Test
    public void givenWhenUserChooses_ToSearchDoctorById_ShouldReturnSearchedResult() throws IOException {
        Doctor doctor = new Doctor("Vishal","102","Gynaecologist","11-12");
        clinicManagementSystemMain.searchDoctorById(doctor, doctorFilePath);
        ArrayList<Doctor> data = objectMapper.readValue(new File(doctorFilePath), new TypeReference<ArrayList<Doctor>>(){});
        Assert.assertEquals(doctor.getId(), data.get(1).getId());
    }

    @Test
    public void givenWhenUserChooses_ToSearchPatientByName_ShouldReturnSearchedResult() throws IOException {
        Patient patient = new Patient("Mno", "3", "7410258963", "26");
        clinicManagementSystemMain.searchPatientByName(patient, patientFilePath);
        ArrayList<Patient> data = objectMapper.readValue(new File(patientFilePath), new TypeReference<ArrayList<Patient>>(){});
        Assert.assertEquals(patient.getName(), data.get(2).getName());
    }

    @Test
    public void givenWhenUserChooses_ToSeePopularSpecialization_ShouldReturnPopularSpecialization() throws IOException {
        Doctor doctor1 = new Doctor("Vaibhav","101","Surgery","10-11");
        Doctor doctor2 = new Doctor("Vishal","102","Gynaecologist","11-12");
        Doctor doctor3 = new Doctor("Shailesh","103","Dentist","12-1");
        Doctor doctor4 = new Doctor("Deepak","104","Psychiatrist","1-2");
        clinicManagementSystemMain.popularSpecialization(doctor1, doctorFilePath);
        ArrayList<Doctor> data = objectMapper.readValue(new File(doctorFilePath), new TypeReference<ArrayList<Doctor>>(){});
        Assert.assertEquals(doctor1.getSpecialization(), data.get(0).getSpecialization());
    }

    @Test
    public void givenWhenUserChooses_ToSeePopularDoctor_ShouldReturnPopularDoctor() throws IOException {
        Doctor doctor1 = new Doctor("Vaibhav","101","Surgery","10-11");
        Doctor doctor2 = new Doctor("Vishal","102","Gynaecologist","11-12");
        Doctor doctor3 = new Doctor("Shailesh","103","Dentist","12-1");
        Doctor doctor4 = new Doctor("Deepak","104","Psychiatrist","1-2");
        clinicManagementSystemMain.popularDoctor(doctor4, doctorFilePath);
        ArrayList<Doctor> data = objectMapper.readValue(new File(doctorFilePath), new TypeReference<ArrayList<Doctor>>(){});
        Assert.assertEquals(doctor4.getName(), data.get(3).getName());
    }

}
