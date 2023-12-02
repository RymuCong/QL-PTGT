package org.example.data.action;

import org.example.data.Vehicle;

import java.util.ArrayList;

public interface IOJson {
    void saveData();
    ArrayList<Vehicle> readData();
}
