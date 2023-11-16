/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.data;

/**
 *
 * @author 01689
 */
public class XeDap extends Vehicle{
    @Override
    public String toString() {
        return "XeDap{" +
                "name='" + name + '\'' +
                ", hangSanXuat='" + hangSanXuat + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", giaTien=" + giaTien +
                ", thueTruocBa=" + thueTruocBa +
                '}';
    }

    public XeDap(String name, String hangSanXuat, int namSanXuat, double giaTien, float thueTruocBa) {
        super(name, hangSanXuat, namSanXuat, giaTien, thueTruocBa);
    }

}
