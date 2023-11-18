package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.data.Vehicle;
import org.example.data.XeMay;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    String filePath = "DataPTGT.json";
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    public void addNewData(){
        XeMay xeMay = new XeMay("XeMay","Wave","honda",2015,10000000,1.5F,"TN986876GV56","Ta Tuan Anh",100);
        XeMay xeMay1 = new XeMay("XeMay","Wave","honda",2015,10000000,1.5F,"TN986876GV56","Ta Tuan Anh",100);
        XeMay xeMay2 = new XeMay("XeMay","Wave","honda",2015,10000000,1.5F,"TN986876GV56","Ta Tuan Anh",100);
        XeMay xeMay3 = new XeMay("XeMay","Wave","honda",2015,10000000,1.5F,"TN986876GV56","Ta Tuan Anh",100);
        XeMay xeMay4 = new XeMay("XeMay","Wave","honda",2015,10000000,1.5F,"TN986876GV56","Ta Tuan Anh",100);

//với thuộc tính loại xe thì gán luôn tên ko cho người dùng nhập

        vehicles.add(xeMay);
        vehicles.add(xeMay1);
        vehicles.add(xeMay2);
        vehicles.add(xeMay3);
        vehicles.add(xeMay4);

    }
    public void saveData(){
        try {
            Writer writer = new FileWriter(filePath);
            File saveData = new File(filePath);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            if (saveData.createNewFile()) {
                System.out.println("File created: " + saveData.getName());
            } else {
                gson.toJson(vehicles,writer);

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void readData(){
        try {
            File myObj = new File("DataPTGT.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void editData(){

    }
    public void sort(){

    }
    public void search(){

    }
    public void thongKe(){

    }

}
