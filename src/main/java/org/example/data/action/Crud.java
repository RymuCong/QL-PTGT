package org.example.data.action;

import org.example.data.Vehicle;

import java.util.ArrayList;

public interface Crud {
    void add_vehicles();
    void showData();
    void xoa();
    void edit_vehicle();
    void saveData();
    ArrayList<Vehicle> readData();
}
