package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.data.Vehicle;
import org.example.data.XeMay;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    public void addNewData(){
        XeMay xeMay = new XeMay("wave","honda",2015,1000000,1.2f,"SJ245646","Ta Tuan Anh",100);
        XeMay xeMay1 = new XeMay("wave","honda",2015,1000000,1.2f,"SJ245646","Ta Tuan Anh",100);

        XeMay xeMay2 = new XeMay("wave","honda",2015,1000000,1.2f,"SJ245646","Ta Tuan Anh",100);
        XeMay xeMay3 = new XeMay("wave","honda",2015,1000000,1.2f,"SJ245646","Ta Tuan Anh",100);
        XeMay xeMay4 = new XeMay("wave","honda",2015,1000000,1.2f,"SJ245646","Ta Tuan Anh",100);

        vehicles.add(xeMay);
        vehicles.add(xeMay1);
        vehicles.add(xeMay2);
        vehicles.add(xeMay3);
        vehicles.add(xeMay4);

    }
    public void saveData(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File saveData = new File("DataPTGT.txt");
            FileWriter myWriter = new FileWriter("DataPTGT.txt");

            if (saveData.createNewFile()) {
                System.out.println("File created: " + saveData.getName());
            } else {
                for (Vehicle vehicle : vehicles) {
                    String jsonString = objectMapper.writeValueAsString(vehicle);
                    myWriter.write(jsonString+";\n");
                }
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void readData(){
        try {
            File myObj = new File("DataPTGT.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("XeDap")){
//                    data
//                    XeDap xeDap = new XeDap();
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
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
