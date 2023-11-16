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
    @Override
    public String toString() {
        return "XeOtoBanTai{" +
                "dungTichDongCo=" + dungTichDongCo +
                ", taiTrong=" + taiTrong +
                ", chieuDaiThungXe=" + chieuDaiThungXe +
                ", name='" + name + '\'' +
                ", hangSanXuat='" + hangSanXuat + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", giaTien=" + giaTien +
                ", thueTruocBa=" + thueTruocBa +
                '}';
    }

    private int dungTichDongCo;
    private int taiTrong;

    public XeOtoBanTai(String name, String hangSanXuat, int namSanXuat, double giaTien, float thueTruocBa) {
        super(name, hangSanXuat, namSanXuat, giaTien, thueTruocBa);
    }

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
    private int chieuDaiThungXe;
}
