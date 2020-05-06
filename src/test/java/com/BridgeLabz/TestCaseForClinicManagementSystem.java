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

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void givenAddDoctor_WhenProper_ShouldReturnTrue() throws IOException {
        Doctor doctor1 = new Doctor("Vaibhav","101","Surgery","10-11");
        Doctor doctor2 = new Doctor("Vishal","102","Gynaecologist","11-12");
        Doctor doctor3 = new Doctor("Shailesh","103","Dentist","12-1");
        Doctor doctor4 = new Doctor("Deepak","104","Psychiatrist","1-2");
        DoctorInterface doctorInterface = new ClinicManagementSystemMain();
        doctorInterface.addDoctor(doctor1,doctorFilePath);
        doctorInterface.addDoctor(doctor2,doctorFilePath);
        doctorInterface.addDoctor(doctor3,doctorFilePath);
        doctorInterface.addDoctor(doctor4,doctorFilePath);
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
        PatientInterface patientInterface = new ClinicManagementSystemMain();
        patientInterface.addPatient(patient1, patientFilePath);
        patientInterface.addPatient(patient2, patientFilePath);
        patientInterface.addPatient(patient3, patientFilePath);
        patientInterface.addPatient(patient4, patientFilePath);
        ArrayList<Patient> data = objectMapper.readValue(new File(patientFilePath), new TypeReference<ArrayList<Patient>>(){});
        Assert.assertEquals(patient1.getName(), data.get(0).getName());
        Assert.assertEquals(patient2.getName(), data.get(1).getName());
        Assert.assertEquals(patient3.getName(), data.get(2).getName());
        Assert.assertEquals(patient4.getName(), data.get(3).getName());


    }

}
