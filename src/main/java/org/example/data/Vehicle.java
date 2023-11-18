/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author 01689
 */
public abstract class Vehicle {
    public String loaiXe ="";
    protected String tenPhuongTien;
    protected String hangSanXuat;
    protected int namSanXuat;
    protected double giaTien;
    protected float lePhiTruocBa;
//    đây là % nên nhập 1 2% thôi
    protected String maSoThue;
    protected String tenNguoiKhaiThue;
    public double TinhThueTruocBa(double giaTien, float lePhiTruocBa){
        double Thue = giaTien*lePhiTruocBa;
        return Thue;
    }

    public String getTenPhuongTien() {
        return tenPhuongTien;
    }

    public void setTenPhuongTien(String tenPhuongTien) {
        this.tenPhuongTien = tenPhuongTien;
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

    public float getLePhiTruocBa() {
        return lePhiTruocBa;
    }

    public void setLePhiTruocBa(float lePhiTruocBa) {
        this.lePhiTruocBa = lePhiTruocBa;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getTenNguoiKhaiThue() {
        return tenNguoiKhaiThue;
    }

    public void setTenNguoiKhaiThue(String tenNguoiKhaiThue) {
        this.tenNguoiKhaiThue = tenNguoiKhaiThue;
    }

    public double TinhLePhiDangKyXeMoi(double giaTien){
        double LePhiDangKyXe = 0;
        if (giaTien <= 15000000){
            LePhiDangKyXe = 500000;
        } else if (giaTien>15000000 || giaTien<=40000000 ) {
            LePhiDangKyXe = 1000000;
        }else {
            LePhiDangKyXe = 2000000;
        }
        return LePhiDangKyXe;
    }
    public double TinhThueGiaTriGiaTang(double giaTien){
        double thueGiaTriGiaTang = giaTien*10/100;
        return thueGiaTriGiaTang;
    }

    public Vehicle(String tenPhuongTien, String hangSanXuat, int namSanXuat, double giaTien, float lePhiTruocBa, String maSoThue, String tenNguoiKhaiThue) {
        this.tenPhuongTien = tenPhuongTien;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.giaTien = giaTien;
        this.lePhiTruocBa = lePhiTruocBa;
        this.maSoThue = maSoThue;
        this.tenNguoiKhaiThue = tenNguoiKhaiThue;
    }
}
