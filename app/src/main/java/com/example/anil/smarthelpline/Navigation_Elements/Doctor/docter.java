package com.example.anil.smarthelpline.Navigation_Elements.Doctor;

import java.sql.Blob;

/**
 * Created by anil on 27-01-2018.
 */

public class docter {
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    private String name,specialization,Address;
    private String number;
    private String image;


    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;

    }

    public String getNumber() {
        return number;
    }

    public String getImage() {
        return image;
    }
}
