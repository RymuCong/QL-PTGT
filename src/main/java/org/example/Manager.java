package org.example;

import org.example.data.Vehicle;
import org.example.data.XeDap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    public void addNewData(){

    }
    public void test(){
        XeDap xd;
        for (int i =0;i<10;i++){
            xd = new XeDap("esh"+i,"adsfdg"+i,2023,2000000,10000);
            vehicles.add(xd);
        }
    }
    public void saveData(){

        try {
            File saveData = new File("DataPTGT.txt");
            FileWriter myWriter = new FileWriter("DataPTGT.txt");

            if (saveData.createNewFile()) {
                System.out.println("File created: " + saveData.getName());
            } else {
                for (Vehicle vehicle : vehicles) {
                    myWriter.write(vehicle.toString()+";\n");

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

}
