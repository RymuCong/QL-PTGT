package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.data.Vehicle;
import org.example.data.XeMay;

import java.io.*;
import com.google.gson.reflect.TypeToken;
import org.example.data.XeOtoCon;

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
                for (Vehicle vehicle : vehicles) {
                    if (vehicle instanceof XeMay ){
                        xeMay = (XeMay) vehicle;
                        System.out.println("\n+--------------------------------------------------------------------------------------------------------+");
                        System.out.println("\n+------------------------------------------------MENU----------------------------------------------------+");
                        System.out.println("\n| Mã số thuế | Loại xe | Tên | Hãng | Năm sản xuất | Giá Tiền | Lệ phí trước bạ(%) | Tên người khai thuế |");
                        System.out.println("\n+--------------------------------------------------------------------------------------------------------+");
                        System.out.println("\n| "+xeMay.getMaSoThue()+" | "+" | "+xeMay.loaiXe+" | "+xeMay.getTenPhuongTien()+" | "+xeMay.getHangSanXuat()+
                                " | "+xeMay.getNamSanXuat()+" | "+xeMay.getGiaTien()+" | "+xeMay.getLePhiTruocBa()+" | "+xeMay.getTenNguoiKhaiThue()+" |");
                    }
                }
                break;
            }
            case 2:{
                XeOtoCon xeOtoCon;
                for (Vehicle vehicle : vehicles) {
                    if (vehicle.loaiXe == "Oto"){
                        if (vehicle instanceof XeOtoCon){
                            xeOtoCon = (XeOtoCon) vehicle;
                            System.out.println("\n+------------------------------------------------------------------------------------------------------------------------+");
                            System.out.println("\n+----------------------------------------------------MENU----------------------------------------------------------------+");
                            System.out.println("\n| Mã số thuế | Loại xe | Tên | Hãng | Năm sản xuất | Giá Tiền | Lệ phí trước bạ(%) | Tên người khai thuế | Dung tích cốp |");
                            System.out.println("\n+------------------------------------------------------------------------------------------------------------------------+");
                            System.out.println("\n| "+xeOtoCon.getMaSoThue()+" | "+" | "+xeOtoCon.loaiXe+" | "+xeOtoCon.getTenPhuongTien()+" | "+xeOtoCon.getHangSanXuat()+
                                    " | "+xeOtoCon.getNamSanXuat()+" | "+xeOtoCon.getGiaTien()+" | "+xeOtoCon.getLePhiTruocBa()+" | "+xeOtoCon.getTenNguoiKhaiThue()+" | "+xeOtoCon.getDungTichCop()+ " | ");
                        }
                    }

                }
            }
            case 3:{

            }

            case 0:{

            }
            default:{

            }
        }
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.loaiXe);
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
    private boolean maSoThueChecker(ArrayList<Vehicle> list,String taxId){
        for (Vehicle vehicle : list) {
            if (vehicle.getMaSoThue().equals(taxId)){
                return true;
            }
        }
        return false;
    }
    private static ArrayList<Vehicle> readData() {
        ArrayList<Vehicle> dataFromFile = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Gson gson = new Gson();
            Vehicle vehicle = (Vehicle) new TypeToken<ArrayList<Vehicle>>() {}.getType();
            dataFromFile = gson.fromJson((Reader) reader, (Type) vehicle);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc tệp tin: " + e.getMessage());
        }
        return dataFromFile;
    }


    public String select_type(int select_type_vehicle){
        String loai_xe =  "";
        if(select_type_vehicle == 1)
        {
            loai_xe = "car";
        }
        if(select_type_vehicle == 2)
        {
            loai_xe = "motobike";
        }
        if(select_type_vehicle == 3)
        {
            loai_xe = "bycycle";
        }
        return loai_xe;
    }
    public void add_vehicles(int select_type_vehicle)
    {
        Scanner scanner = new Scanner(System.in);
        String tenxe;
        do {
            System.out.println("Nhập tên xe: ");
            tenxe = scanner.nextLine();
            // Kiểm tra đầu vào với biểu thức chính quy
            if (!tenxe.matches("[a-zA-Z0-9]+")) {
                System.out.println("Tên xe hợp lệ mời nhập lại.");
            }
        } while (!tenxe.matches("[a-zA-Z0-9]+"));




        String hang_san_xuat;
        do {
            System.out.println("nhập tên hãng sản xuất ");
            hang_san_xuat = scanner.nextLine();
            // Kiểm tra đầu vào với biểu thức chính quy
            if (!hang_san_xuat.matches("[a-zA-Z]+")) {
                System.out.println("Tên hãng sản xuất hợp lệ mời nhập lại.");
            }
        } while (!hang_san_xuat.matches("[a-zA-Z]+"));


        // System.out.println("nhập năm sản xuất ");
        int nam_san_xuat;
        do {
            System.out.println("Nhập năm sản xuất: ");
            if (scanner.hasNextInt()) {
                nam_san_xuat = scanner.nextInt();
                break;
            } else {
                System.out.println("Năm sản xuất không hợp lệ. Vui lòng nhập lại.");
                scanner.next(); // Đọc và loại bỏ giá trị không hợp lệ khỏi bộ đệm của scanner
            }
        } while (true);




        int dung_tich;
        do {
            System.out.println("Nhập dung tích xe: ");
            if (scanner.hasNextInt()) {
                dung_tich = scanner.nextInt();
                break;
            } else {
                System.out.println("dung tích xe không hợp lệ. Vui lòng nhập lại.");
                scanner.next(); // Đọc và loại bỏ giá trị không hợp lệ khỏi bộ đệm của scanner
            }
        } while (true);

        String loai_xe  = "";
        if(select_type_vehicle == 1)
        {
            loai_xe = "car";
        }
        if(select_type_vehicle == 2)
        {
            loai_xe = "motobike";
        }
        if(select_type_vehicle == 3)
        {
            loai_xe = "bycycle";
        }


        double gia_tien;
        do {
            System.out.println("Nhập giá tiền : ");
            if (scanner.hasNextInt()) {
                gia_tien = scanner.nextInt();
                break;
            } else {
                System.out.println("giá tiền không hợp lệ. Vui lòng nhập lại.");
                scanner.next(); // Đọc và loại bỏ giá trị không hợp lệ khỏi bộ đệm của scanner
            }
        } while (true);

        System.out.print("Nhập Lệ Phí Trước Ba: ");
        float le_phi_truoc_ba;
        do {
            System.out.println("Nhập Lệ Phí Trước Ba : ");
            if (scanner.hasNextInt()) {
                le_phi_truoc_ba = scanner.nextInt();
                break;
            } else {
                System.out.println("Lệ Phí Trước Ba không hợp lệ. Vui lòng nhập lại.");
                scanner.next(); // Đọc và loại bỏ giá trị không hợp lệ khỏi bộ đệm của scanner
            }
        } while (true);



        String ma_so_thue ;
        do {
            System.out.println("Nhập mã số thuế : ");
            ma_so_thue = scanner.nextLine();
            // Kiểm tra đầu vào với biểu thức chính quy
            if (!ma_so_thue.matches("[a-zA-Z0-9]+")) {
                System.out.println("Tên xe hợp lệ mời nhập lại.");
            }
        } while (!ma_so_thue.matches("[a-zA-Z0-9]+"));

        scanner.nextLine();

        System.out.print("Nhập tên người khai thuế: ");
        String ten_nguoi_khai_thue = scanner.nextLine();

        XeMay xeMay = new XeMay( loai_xe ,tenxe, hang_san_xuat, nam_san_xuat, gia_tien, le_phi_truoc_ba, ma_so_thue, ten_nguoi_khai_thue,dung_tich);

        // thêm đối tượng xe máy vào danh sach vehicles \
        vehicles.add(xeMay);
        //  lưu danh sách vehicles vào tệp tin


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
