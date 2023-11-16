/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.data;

/**
 *
 * @author 01689
 */
public class XeMay extends Vehicle  {
    private int dungTichDongCo;

    @Override
    public String toString() {
        return "XeMay{" +
                "dungTichDongCo=" + dungTichDongCo +
                ", name='" + name + '\'' +
                ", hangSanXuat='" + hangSanXuat + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", giaTien=" + giaTien +
                ", thueTruocBa=" + thueTruocBa +
                '}';
    }

    public XeMay(String name, String hangSanXuat, int namSanXuat, double giaTien, float thueTruocBa) {
        super(name, hangSanXuat, namSanXuat, giaTien, thueTruocBa);
    }

    public int getDungTichDongCo() {
        return dungTichDongCo;
    }

    public void setDungTichDongCo(int dungTichDongCo) {
        this.dungTichDongCo = dungTichDongCo;
    }
    
}
