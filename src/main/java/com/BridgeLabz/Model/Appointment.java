package com.BridgeLabz.Model;

public class Appointment
{
    String doctorName;
    String patientName;
    String schedule;

    public Appointment() {
    }

    public Appointment(String doctorName, String patientName, String schedule) {
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.schedule = schedule;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "doctorName='" + doctorName + '\'' +
                ", patientName='" + patientName + '\'' +
                ", schedule='" + schedule + '\'' +
                '}';
    }
}
