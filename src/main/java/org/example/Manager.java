package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.data.Vehicle;
import org.example.data.XeMay;
import org.example.data.XeOtoBanTai;

import java.io.*;
import com.google.gson.reflect.TypeToken;
import org.example.data.XeOtoCon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    static String filePath = "DataPTGT.json";
    ArrayList<Vehicle> vehicles = readData();
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
        String loai_xe = "XeMay";

        System.out.print("Nhập giá tiền: ");
        double gia_tien = scanner.nextInt();

        System.out.print("Nhập Lệ Phí Trước Bạ(%): ");
        float le_phi_truoc_ba  = scanner.nextFloat();
        String ma_so_thue;
        while (true) {
            System.out.print("Nhập mã số thuế: ");
            ma_so_thue = scanner.nextLine();

            if (maSoThueChecker(vehicles, ma_so_thue)) {
                System.out.println("Mã số thuế đã tồn tại. Vui lòng nhập lại.");
            } else {
                System.out.println("Mã số thuế hợp lệ.");
                break;
            }
        }

        scanner.nextLine();

        System.out.print("Nhập tên người khai thuế: ");
        String ten_nguoi_khai_thue = scanner.nextLine();

        XeMay xeMay = new XeMay( loai_xe ,tenxe, hang_san_xuat, nam_san_xuat, gia_tien, le_phi_truoc_ba, ma_so_thue, ten_nguoi_khai_thue,dung_tich);

        // thêm đối tượng xe máy vào danh sach vehicles \
        vehicles.add(xeMay);
        //  lưu danh sách vehicles vào tệp tin
        saveData();

    }
    public void testData(){
        XeMay xeMay = new XeMay("XeMay","Wave","honda",2015,10007000,1.5F,"TN986876GV76","Ta Tuan Anh",100);
        XeMay xeMay1 = new XeMay("XeMay","Wave","honda",2015,10300000,1.5F,"TN9868764V56","Ta Tuan Anh",100);
        XeMay xeMay2 = new XeMay("XeMay","Wave","honda",2015,10800000,1.5F,"TN986873GV56","Ta Tuan Anh",100);
        XeMay xeMay3 = new XeMay("XeMay","Wave","honda",2015,10300000,1.5F,"TN986871GV56","Ta Tuan Anh",100);
        XeMay xeMay4 = new XeMay("XeMay","Wave","honda",2015,10008000,1.5F,"TN986879GV56","Ta Tuan Anh",100);
        XeOtoCon otoCon0 = new XeOtoCon("Oto","civic","honda",2019,190000800,2F,"BD98965896HY","Phung Ngoc Bao",1035,100);
        XeOtoCon otoCon1 = new XeOtoCon("Oto","civic","honda",2019,190400000,2F,"BD98795896HY","Phung Ngoc Bao",1035,100);
        XeOtoCon otoCon2 = new XeOtoCon("Oto","civic","honda",2019,190080000,2F,"BD98705896HY","Phung Ngoc Bao",1035,100);
        XeOtoCon otoCon3 = new XeOtoCon("Oto","civic","honda",2019,199000000,2F,"BD98715896HY","Phung Ngoc Bao",1035,100);
        XeOtoCon otoCon4 = new XeOtoCon("Oto","civic","honda",2019,190004000,2F,"BD987905896HY","Phung Ngoc Bao",1035,100);
        XeOtoCon otoCon5 = new XeOtoCon("Oto","civic","honda",2019,195000000,2F,"BD98764896HY","Phung Ngoc Bao",1035,100);

        vehicles.add(xeMay);
        vehicles.add(xeMay1);
        vehicles.add(xeMay2);
        vehicles.add(xeMay3);
        vehicles.add(xeMay4);
        vehicles.add(otoCon1);
        vehicles.add(otoCon2);
        vehicles.add(otoCon0);
        vehicles.add(otoCon3);
        vehicles.add(otoCon4);
        vehicles.add(otoCon5);
    }
    public void showData(){
        System.out.println("Hiển thị thông tin phương tiện");
        System.out.println("1,Xe máy");
        System.out.println("2,Xe ô tô");
        System.out.println("3,Xe ô tô bán tải");
        System.out.println("0,Exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:{
                XeMay xeMay;
                System.out.println("\n+--------------------------------------------------------------------------------------------------------+");
                System.out.println("\n+------------------------------------------------MENU----------------------------------------------------+");
                System.out.println("\n| Mã số thuế | Loại xe | Tên | Hãng | Năm sản xuất | Giá Tiền | Lệ phí trước bạ(%) | Tên người khai thuế | Dung tích động cơ |");
                System.out.println("\n+--------------------------------------------------------------------------------------------------------+");
                for (Vehicle vehicle : vehicles) {
                    if (vehicle instanceof XeMay ){
                        xeMay = (XeMay) vehicle;
                        System.out.println("\n| "+xeMay.getMaSoThue()+" | "+" | "+xeMay.loaiXe+" | "+xeMay.getTenPhuongTien()+" | "+xeMay.getHangSanXuat()+
                                " | "+xeMay.getNamSanXuat()+" | "+xeMay.getGiaTien()+" | "+xeMay.getLePhiTruocBa()+" | "+xeMay.getTenNguoiKhaiThue()+" | "+xeMay.getDungTichDongCo()+" | ");
                    }
                }
                break;
            }
            case 2:{
                XeOtoCon xeOtoCon;
                for (Vehicle vehicle : vehicles) {
                        if (vehicle instanceof XeOtoCon){
                            xeOtoCon = (XeOtoCon) vehicle;
                            System.out.println("\n+------------------------------------------------------------------------------------------------------------------------+");
                            System.out.println("\n+----------------------------------------------------MENU----------------------------------------------------------------+");
                            System.out.println("\n| Mã số thuế | Loại xe | Tên | Hãng | Năm sản xuất | Giá Tiền | Lệ phí trước bạ(%) | Tên người khai thuế | Dung tích động c | Dung tích cốp |");
                            System.out.println("\n+------------------------------------------------------------------------------------------------------------------------+");
                            System.out.println("\n| "+xeOtoCon.getMaSoThue()+" | "+" | "+xeOtoCon.loaiXe+" | "+xeOtoCon.getTenPhuongTien()+" | "+xeOtoCon.getHangSanXuat()+
                                    " | "+xeOtoCon.getNamSanXuat()+" | "+xeOtoCon.getGiaTien()+" | "+xeOtoCon.getLePhiTruocBa()+" | "+xeOtoCon.getTenNguoiKhaiThue()+" | "+xeOtoCon.getDungTichDongCo()+" | "+xeOtoCon.getDungTichCop()+ " | ");
                        }

                }
                break;
            }
            case 3:{

            }

            case 0:{

            }
            default:{

            }
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
    private boolean maSoThueChecker(ArrayList<Vehicle> list, String taxId){
        for (Vehicle vehicle : list) {
            if (vehicle.getMaSoThue().equals(taxId)){
                return true;
            }
        }
        return false;
    }
    private static ArrayList<Vehicle> readData() {
        ArrayList<Vehicle> dataFromFile = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filePath));

            for (Object jsonItem : jsonArray) {
                JSONObject jsonObject = (JSONObject) jsonItem;

                String loaiXe = (String) jsonObject.get("loaiXe");
                String maSoThue = (String) jsonObject.get("maSoThue");
                String tenPhuongTien = (String) jsonObject.get("tenPhuongTien");
                String hangSanXuat = (String) jsonObject.get("hangSanXuat");
                int namSanXuat = Math.toIntExact((long) jsonObject.get("namSanXuat"));
                double giaTien = (double) jsonObject.get("giaTien");
                float lePhiTruocBa = Float.parseFloat(jsonObject.get("lePhiTruocBa").toString());
                String tenNguoiKhaiThue = (String) jsonObject.get("tenNguoiKhaiThue");

                if ("XeMay".equals(loaiXe)) {
                    int dungTichDongCo = Math.toIntExact((long) jsonObject.get("dungTichDongCo"));
                    XeMay xeMay = new XeMay(loaiXe, tenPhuongTien, hangSanXuat, namSanXuat, giaTien, lePhiTruocBa, maSoThue, tenNguoiKhaiThue, dungTichDongCo);
                    dataFromFile.add(xeMay);
                } else if ("Oto".equals(loaiXe)) {
                    int dungTichDongCo = Math.toIntExact((long) jsonObject.get("dungTichDongCo"));
                    int dungTichCop = Math.toIntExact((long) jsonObject.get("dungTichCop"));
                    XeOtoCon xeOtoCon = new XeOtoCon(loaiXe, tenPhuongTien, hangSanXuat, namSanXuat, giaTien, lePhiTruocBa, maSoThue, tenNguoiKhaiThue, dungTichDongCo, dungTichCop);
                    dataFromFile.add(xeOtoCon);
                } else if ("XeOtoBanTai".equals(loaiXe)) {
                int dungTichDongCo = Math.toIntExact((long) jsonObject.get("dungTichDongCo"));
                int taiTrong = Math.toIntExact((long) jsonObject.get("taiTrong"));
                int chieuDaiThungXe = Math.toIntExact((long) jsonObject.get("chieuDaiThungXe"));
                XeOtoBanTai xeOtoBanTai = new XeOtoBanTai(loaiXe, tenPhuongTien, hangSanXuat, namSanXuat, giaTien, lePhiTruocBa, maSoThue, tenNguoiKhaiThue, dungTichDongCo, taiTrong, chieuDaiThungXe);
                dataFromFile.add(xeOtoBanTai);
            }
            }
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi khi đọc tệp tin: " + e.getMessage());
        }

        return dataFromFile;
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
