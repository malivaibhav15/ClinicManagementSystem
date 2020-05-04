package com.BridgeLabz.Model;

public class Patient
{
    private String name;
    private String id;
    private String mobileNumber;
    private String age;

    public Patient() {
    }

    public Patient(String name, String id, String mobileNumber, String age) {
        this.name = name;
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.age = age;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", age='" + age + '\'' +
                '}';
    }


}
