/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.data;

/**
 *
 * @author 01689
 */
public class XeOtoBanTai extends Vehicle{
    private int dungTichDongCo;
    private int taiTrong;
    private int chieuDaiThungXe;

    public int getDungTichDongCo() {
        return dungTichDongCo;
    }

    public void setDungTichDongCo(int dungTichDongCo) {
        this.dungTichDongCo = dungTichDongCo;
    }

    public int getTaiTrong() {
        return taiTrong;
    }

    public void setTaiTrong(int taiTrong) {
        this.taiTrong = taiTrong;
    }

    public int getChieuDaiThungXe() {
        return chieuDaiThungXe;
    }

    public void setChieuDaiThungXe(int chieuDaiThungXe) {
        this.chieuDaiThungXe = chieuDaiThungXe;
    }

    @Override
    public String toString() {
        return "XeOtoBanTai{" +
                "dungTichDongCo=" + dungTichDongCo +
                ", taiTrong=" + taiTrong +
                ", chieuDaiThungXe=" + chieuDaiThungXe +
                ", loaiXe='" + loaiXe + '\'' +
                ", tenPhuongTien='" + tenPhuongTien + '\'' +
                ", hangSanXuat='" + hangSanXuat + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", giaTien=" + giaTien +
                ", lePhiTruocBa=" + lePhiTruocBa +
                ", maSoThue='" + maSoThue + '\'' +
                ", tenNguoiKhaiThue='" + tenNguoiKhaiThue + '\'' +
                '}';
    }

    public XeOtoBanTai(String loaiXe, String tenPhuongTien, String hangSanXuat, int namSanXuat, double giaTien, float lePhiTruocBa, String maSoThue, String tenNguoiKhaiThue, int dungTichDongCo, int taiTrong, int chieuDaiThungXe) {
        super(loaiXe, tenPhuongTien, hangSanXuat, namSanXuat, giaTien, lePhiTruocBa, maSoThue, tenNguoiKhaiThue);
        this.dungTichDongCo = dungTichDongCo;
        this.taiTrong = taiTrong;
        this.chieuDaiThungXe = chieuDaiThungXe;
    }

    @Override
    public double TinhThueGiaTriGiaTang(double giaTien) {
        return giaTien*10/100;
    }
}
