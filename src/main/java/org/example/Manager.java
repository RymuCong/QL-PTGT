package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.data.Vehicle;
import org.example.data.XeMay;

import java.io.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
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

    public void add_vehicles()
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("nhập tên xe ");
        String tenxe = scanner.nextLine();
        
        System.out.println("nhập tên hãng sản xuất ");
        String hang_san_xuat = scanner.nextLine();
        
        System.out.println("nhập năm sản xuất ");
        int nam_san_xuat = scanner.nextInt();

        System.out.println("nhập dung tích ");
        int dung_tich = scanner.nextInt();
        
        scanner.nextLine();
        System.out.println("nhập loại xe ");
        String loai_xe = scanner.nextLine();

        System.out.print("Nhập giá tiền: ");
        double gia_tien = scanner.nextInt();

        System.out.print("Nhập Lệ Phí Trước Ba: ");
        float le_phi_truoc_ba  = scanner.nextFloat();

        System.out.print("Nhập mã số thuế: ");
        String ma_so_thue = scanner.nextLine();

        scanner.nextLine();

        System.out.print("Nhập tên người khai thuế: ");
        String ten_nguoi_khai_thue = scanner.nextLine();

        XeMay xeMay = new XeMay( loai_xe ,tenxe, hang_san_xuat, nam_san_xuat, gia_tien, le_phi_truoc_ba, ma_so_thue, ten_nguoi_khai_thue,dung_tich);
        
        // thêm đối tượng xe máy vào danh sach vehicles \   
        vehicles.add(xeMay);
        //  lưu danh sách vehicles vào tệp tin 
       

    }
    
    public void showData(){
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
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
                writer.close(); // Đóng Writer sau khi ghi dữ liệu vào tệp tin
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void readData(){
        Gson gson = new Gson();
        try {
            String jsonString = readFile(filePath);
            
            Type listType = new TypeToken<ArrayList<Vehicle>>() {}.getType();
            ArrayList<Vehicle> vehicleList = gson.fromJson(jsonString, listType);
//            vehicles.addAll(vehicleList);
            vehicleList.addAll(vehicles);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
    private  String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }
    public void editData(){
//        nhớ ép kiểu từ vehical sang loại phương tiện tương ứng để sử dụng get set của class tương ứng

    }
    public void sort(){
//        nhớ ép kiểu từ vehical sang loại phương tiện tương ứng để sử dụng get set của class tương ứng

    }
    public void search(){
//        nhớ ép kiểu từ vehical sang loại phương tiện tương ứng để sử dụng get set của class tương ứng

    }
    public void thongKe(){
//        nhớ ép kiểu từ vehical sang loại phương tiện tương ứng để sử dụng get set của class tương ứng

    }

}
