package com.BridgeLabz.Model;

public class Doctor
{
    private String name;
    private String id;
    private String specialization;
     private  String schedule;

    public Doctor() {
    }

    public Doctor(String name, String id, String specialization, String schedule) {
        this.name = name;
        this.id = id;
        this.specialization = specialization;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
