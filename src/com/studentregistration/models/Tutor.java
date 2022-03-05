/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentregistration.models;

/**
 *
 * @author Rajindu
 */
public class Tutor {
    private String id;
    private String name;
    private String tutorId;
    private String subject;
    private int grade;
    private String dob;
    private int phoneNumber;
    private int fee;
    private String accNo;

    public Tutor(String id, String name, String tutorId, String subject, int grade, String dob, int phoneNumber, int fee, String accNo) {
        this.id = id;
        this.name = name;
        this.tutorId = tutorId;
        this.subject = subject;
        this.grade = grade;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.fee = fee;
        this.accNo = accNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }
}
