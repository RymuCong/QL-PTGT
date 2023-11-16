/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.data;

/**
 *
 * @author 01689
 */
public abstract class Vehicle {
    protected String name;
    protected String hangSanXuat;
    protected int namSanXuat;
    protected double giaTien;
    protected float thueTruocBa;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public float getThueTruocBa() {
        return thueTruocBa;
    }

    public void setThueTruocBa(float thueTruocBa) {
        this.thueTruocBa = thueTruocBa;
    }

    public double TinhThueTruocBa(double giaTien, float thueTruocBa){
        double Thue = giaTien*thueTruocBa;
        return Thue;
    }

    public Vehicle(String name, String hangSanXuat, int namSanXuat, double giaTien, float thueTruocBa) {
        this.name = name;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.giaTien = giaTien;
        this.thueTruocBa = thueTruocBa;
    }
}
