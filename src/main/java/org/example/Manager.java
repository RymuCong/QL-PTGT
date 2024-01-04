package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.data.*;

import java.io.*;

import org.example.data.action.Crud;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.*;

// thư viện để tìm kiếm được chữ cái tiếng việt
import java.text.Normalizer;
import java.util.regex.Pattern;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Manager implements Crud{
    static String filePath = "DataPTGT.json";
    ArrayList<Vehicle> vehicles = readData();
    @Override
    public void add_vehicles() {
        System.out.println("Hiển thị thông tin phương tiện bạn muốn thêm");
        System.out.println("1,Xe máy");
        System.out.println("2,Xe ô tô");
        System.out.println("3,Xe ô tô bán tải");
        System.out.println("0,Exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:{
                // Scanner scanner = new Scanner(System.in);
                String tenxe;
                do {
                    System.out.println("Nhập tên xe: ");
                    tenxe = scanner.next();
                    // Kiểm tra đầu vào với biểu thức chính quy
                    if (!tenxe.matches("[a-zA-Z0-9]+")) {
                        System.out.println("Tên xe hợp lệ mời nhập lại.");
                    }
                } while (!tenxe.matches("[a-zA-Z0-9]+"));
                String hang_san_xuat;
                do {
                    System.out.println("nhập tên hãng sản xuất ");
                    hang_san_xuat = scanner.next();
                    // Kiểm tra đầu vào với biểu thức chính quy
                    if (!hang_san_xuat.matches("[a-zA-Z]+")) {
                        System.out.println("Tên hãng sản xuất hợp lệ mời nhập lại.");
                    }
                } while (!hang_san_xuat.matches("[a-zA-Z]+"));
                // System.out.println("nhập năm sản xuất ");

                int nam_hien_tai = java.time.Year.now().getValue();
                int nam_san_xuat = 0;

                do {
                    try {
                        System.out.println("Nhập năm sản xuất:");
                        nam_san_xuat = Integer.parseInt(scanner.nextLine());
                        if (nam_san_xuat > nam_hien_tai) {
                            System.out.println("Năm sản xuất không được vượt quá năm hiện tại.");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Năm sản xuất không hợp lệ. Vui lòng nhập lại.");
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
                    if (scanner.hasNextInt()) {
                        le_phi_truoc_ba = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("Lệ Phí Trước Ba không hợp lệ. Vui lòng nhập lại.");
                        scanner.next(); // Đọc và loại bỏ giá trị không hợp lệ khỏi bộ đệm của scanner
                    }
                } while (true);
                System.out.print("Nhập tên người khai thuế: ");
                String ten_nguoi_khai_thue = scanner.next();
                String ma_so_thue;
                do {
                    System.out.println("Nhập mã số thuế : ");
                    ma_so_thue = scanner.next();
                    if (maSoThueChecker(vehicles,ma_so_thue)){
                        System.out.println("Mã số thuế không hợp lệ");
                    }
                }while (maSoThueChecker(vehicles,ma_so_thue));

                XeMay xeMay = new XeMay("XeMay", tenxe, hang_san_xuat, nam_san_xuat, gia_tien, le_phi_truoc_ba, ma_so_thue, ten_nguoi_khai_thue, dung_tich);

                // thêm đối tượng xe máy vào danh sach vehicles
                vehicles.add(xeMay);
                System.out.print("Thêm vehicle thành công: ");
                //  lưu danh sách vehicles vào tệp tin
                saveData();
                break;
            }
            case 2:{

                String tenxe;
                do {
                    System.out.println("Nhập tên xe: ");
                    tenxe = scanner.next();
                    // Kiểm tra đầu vào với biểu thức chính quy
                    if (!tenxe.matches("[a-zA-Z0-9]+")) {
                        System.out.println("Tên xe hợp lệ mời nhập lại.");
                    }
                } while (!tenxe.matches("[a-zA-Z0-9]+"));
                String hang_san_xuat;
                do {
                    System.out.println("nhập tên hãng sản xuất ");
                    hang_san_xuat = scanner.next();
                    // Kiểm tra đầu vào với biểu thức chính quy
                    if (!hang_san_xuat.matches("[a-zA-Z]+")) {
                        System.out.println("Tên hãng sản xuất hợp lệ mời nhập lại.");
                    }
                } while (!hang_san_xuat.matches("[a-zA-Z]+"));
                // System.out.println("nhập năm sản xuất ");

                int nam_hien_tai = java.time.Year.now().getValue();
                int nam_san_xuat = 0;

                do {
                    try {
                        System.out.println("Nhập năm sản xuất:");
                        nam_san_xuat = Integer.parseInt(scanner.nextLine());
                        if (nam_san_xuat > nam_hien_tai) {
                            System.out.println("Năm sản xuất không được vượt quá năm hiện tại.");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Năm sản xuất không hợp lệ. Vui lòng nhập lại.");
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

                int dung_tich_cop;
                do {
                    System.out.println("Nhập dung tích cốp xe: ");
                    if (scanner.hasNextInt()) {
                        dung_tich_cop = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("dung tích xe không hợp lệ. Vui lòng nhập lại.");
                        scanner.next(); // Đọc và loại bỏ giá trị không hợp lệ khỏi bộ đệm của scanner
                    }
                } while (true);

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
                    if (scanner.hasNextInt()) {
                        le_phi_truoc_ba = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("Lệ Phí Trước Ba không hợp lệ. Vui lòng nhập lại.");
                        scanner.next(); // Đọc và loại bỏ giá trị không hợp lệ khỏi bộ đệm của scanner
                    }
                } while (true);
                System.out.print("Nhập tên người khai thuế: ");
                String ten_nguoi_khai_thue = scanner.next();
                String ma_so_thue;
                do {
                    System.out.println("Nhập mã số thuế : ");
                    ma_so_thue = scanner.next();
                    if (maSoThueChecker(vehicles,ma_so_thue)){
                        System.out.println("Mã số thuế không hợp lệ");
                    }
                }while (maSoThueChecker(vehicles,ma_so_thue));

                XeOtoCon xe_oto_con = new XeOtoCon("XeOtoCon", tenxe, hang_san_xuat, nam_san_xuat, gia_tien, le_phi_truoc_ba, ma_so_thue, ten_nguoi_khai_thue, dung_tich,dung_tich_cop );

                // thêm đối tượng xe máy vào danh sach vehicles \
                vehicles.add(xe_oto_con);
                System.out.print("Thêm vehicle thành công: ");
                //  lưu danh sách vehicles vào tệp tin
                saveData();
                break;
            }
            case 3:{
                // Scanner scanner = new Scanner(System.in);
                String tenxe;
                do {
                    System.out.println("Nhập tên xe: ");
                    tenxe = scanner.next();
                    // Kiểm tra đầu vào với biểu thức chính quy
                    if (!tenxe.matches("[a-zA-Z0-9]+")) {
                        System.out.println("Tên xe hợp lệ mời nhập lại.");
                    }
                } while (!tenxe.matches("[a-zA-Z0-9]+"));
                String hang_san_xuat;
                do {
                    System.out.println("nhập tên hãng sản xuất ");
                    hang_san_xuat = scanner.next();
                    // Kiểm tra đầu vào với biểu thức chính quy
                    if (!hang_san_xuat.matches("[a-zA-Z]+")) {
                        System.out.println("Tên hãng sản xuất hợp lệ mời nhập lại.");
                    }
                } while (!hang_san_xuat.matches("[a-zA-Z]+"));
                // System.out.println("nhập năm sản xuất ");


                // do {
                //     System.out.println("Nhập năm sản xuất: ");
                //     if (scanner.hasNextInt()) {
                //         nam_san_xuat = scanner.nextInt();
                //         break;
                //     }

                //     else {
                //         System.out.println("Năm sản xuất không hợp lệ. Vui lòng nhập lại.");
                //         scanner.next(); // Đọc và loại bỏ giá trị không hợp lệ khỏi bộ đệm của scanner
                //     }
                // } while (true);
                int nam_hien_tai = java.time.Year.now().getValue();
                int nam_san_xuat = 0;

                do {
                    try {
                        System.out.println("Nhập năm sản xuất:");
                        nam_san_xuat = Integer.parseInt(scanner.nextLine());
                        if (nam_san_xuat > nam_hien_tai) {
                            System.out.println("Năm sản xuất không được vượt quá năm hiện tại.");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Năm sản xuất không hợp lệ. Vui lòng nhập lại.");
                    }
                } while (true);

                int tai_trong;
                do {
                    System.out.println("Nhập Tải trọng xe: ");
                    if (scanner.hasNextInt()) {
                        tai_trong = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("trọng tải xe không hợp lệ. Vui lòng nhập lại.");
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

                int chieu_dai_thung_xe;
                do {
                    System.out.println("Nhập chiều dài thùng xe: ");
                    if (scanner.hasNextInt()) {
                        chieu_dai_thung_xe = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("chiều dài thùng xe không hợp lệ. Vui lòng nhập lại.");
                        scanner.next(); // Đọc và loại bỏ giá trị không hợp lệ khỏi bộ đệm của scanner
                    }
                } while (true);

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
                    if (scanner.hasNextInt()) {
                        le_phi_truoc_ba = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("Lệ Phí Trước Ba không hợp lệ. Vui lòng nhập lại.");
                        scanner.next(); // Đọc và loại bỏ giá trị không hợp lệ khỏi bộ đệm của scanner
                    }
                } while (true);
                System.out.print("Nhập tên người khai thuế: ");
                String ten_nguoi_khai_thue = scanner.next();
                String ma_so_thue;
                do {
                    System.out.println("Nhập mã số thuế : ");
                    ma_so_thue = scanner.next();
                    if (maSoThueChecker(vehicles,ma_so_thue)){
                        System.out.println("Mã số thuế không hợp lệ");
                    }
                }while (maSoThueChecker(vehicles,ma_so_thue));


                XeOtoBanTai xe_ban_tai = new XeOtoBanTai("XeOtoBanTai", tenxe, hang_san_xuat, nam_san_xuat, gia_tien, le_phi_truoc_ba, ma_so_thue, ten_nguoi_khai_thue,dung_tich,tai_trong,chieu_dai_thung_xe);

                // thêm đối tượng xe máy vào danh sach vehicles \
                vehicles.add(xe_ban_tai);
                System.out.print("Thêm vehicle thành công: ");
                //  lưu danh sách vehicles vào tệp tin
                saveData();
                break;
            }

            case 0:{

            }
            default:{

            }
        }

    }
    static void cot_xe_may() {
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| STT |     Mã số thuế    | Loại xe |     Tên     |   Hãng   | Năm sản xuất |   Giá Tiền   | Phí trước bạ(%) | Người khai thuế | Động cơ |");
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
    }
    static void Dong_xe_may(XeMay xeMay, int stt) {
        String formattedGiaTien = String.format("%,d", Math.round(xeMay.getGiaTien())).replace(",", ".");
        // format giá tiền thành dạng có dấu chấm cách hàng nghìn sau đó thay thế dấu phẩy thành dấu chấm thành
        System.out.printf("| %-3s | %-17s | %-7s | %-11s | %-8s | %-12s | %-12s | %-15s | %-15s | %-7s |",
                stt, xeMay.getMaSoThue(), xeMay.loaiXe, xeMay.getTenPhuongTien(), xeMay.getHangSanXuat(),
                xeMay.getNamSanXuat(), formattedGiaTien, xeMay.getLePhiTruocBa(), xeMay.getTenNguoiKhaiThue(),
                xeMay.getDungTichDongCo());
        // System.out.println(formattedRow);
        System.out.println("\n+----------------------------------------------------------------------------------------------------------------------------------------+");
    }
    static void cot_print_oto_con() {
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| STT | Mã số thuế    | Loại xe |  Tên  |  Hãng  | Năm sản xuất |    Giá Tiền   | Lệ phí trước bạ(%) | người khai thuế |  cc  | Dung tích cốp |");
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
    }
    static void Dong_print_oto_con(XeOtoCon xecon, int stt) {
        String formattedGiaTien = String.format("%,d", Math.round(xecon.getGiaTien())).replace(",", ".");
        // format giá tiền thành dạng có dấu chấm cách hàng nghìn sau đó thay thế dấu phẩy thành dấu chấm thành
        System.out.printf("| %-3s | %-13s | %-7s | %-5s | %-6s | %-12s | %-13s | %-18s | %-15s | %-4s | %-13s |",
                stt, xecon.getMaSoThue(), xecon.loaiXe, xecon.getTenPhuongTien(), xecon.getHangSanXuat(),
                xecon.getNamSanXuat(),formattedGiaTien, xecon.getLePhiTruocBa(), xecon.getTenNguoiKhaiThue(),
                xecon.getDungTichDongCo(),xecon.getDungTichCop(),xecon.getDungTichCop());
        // System.out.println(formattedRow);
        System.out.println("\n+---------------------------------------------------------------------------------------------------------------------------------------------+");
    }

    static void cot_print_oto_ban_tai() {
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| STT |   Mã số thuế   |   Loại xe   |    Tên    |   Hãng   | Năm sản xuất | Giá Tiền | Lệ phí trước bạ(%) | Người khai thuế |   CC   | Tải trọng | Chiều dài thùng xe |");
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
    }
    static void Dong_print_oto_ban_tai(XeOtoBanTai xe_ban_tai, int stt) {
        String formattedGiaTien = String.format("%,d", Math.round(xe_ban_tai.getGiaTien())).replace(",", ".");
        // format giá tiền thành dạng có dấu chấm cách hàng nghìn sau đó thay thế dấu phẩy thành dấu chấm thành
        System.out.printf("| %-3s | %-14s | %-11s | %-9s | %-8s | %-12s | %-8s | %-18s | %-15s | %-6s | %-9s | %-18s |",
                stt, xe_ban_tai.getMaSoThue(), xe_ban_tai.loaiXe, xe_ban_tai.getTenPhuongTien(), xe_ban_tai.getHangSanXuat(),
                xe_ban_tai.getNamSanXuat(), formattedGiaTien, xe_ban_tai.getLePhiTruocBa(), xe_ban_tai.getTenNguoiKhaiThue(),
                xe_ban_tai.getDungTichDongCo(),xe_ban_tai.getTaiTrong(),xe_ban_tai.getChieuDaiThungXe());
        // System.out.println(formattedRow);
        System.out.println("\n+----------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
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
    @Override
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

                cot_xe_may();
                int stt = 1;
                for (Vehicle vehicle : vehicles) {

                    if (vehicle instanceof XeMay) {
                        xeMay = (XeMay) vehicle;
                        Dong_xe_may(xeMay, stt);
                        stt++;
                    }

                }
                break;
            }
            case 2:{
                XeOtoCon xeOtoCon;

                cot_print_oto_con();
                int stt = 1;
                for (Vehicle vehicle : vehicles) {

                    if (vehicle instanceof XeOtoCon) {
                        xeOtoCon = (XeOtoCon) vehicle;
                        Dong_print_oto_con(xeOtoCon, stt);
                        stt++;
                    }

                }
                break;
            }
            case 3:{
                XeOtoBanTai xeOtoBanTai;

                cot_print_oto_ban_tai();
                int stt = 1;
                for (Vehicle vehicle : vehicles) {

                    if (vehicle instanceof XeOtoBanTai) {
                        xeOtoBanTai = (XeOtoBanTai) vehicle;
                        Dong_print_oto_ban_tai(xeOtoBanTai, stt);
                        stt++;
                    }

                }
                break;
            }

            case 0:{

            }
            default:{

            }
        }
        pause();
    }
    static void pause ()
    {
        System.out.println("\nNhấn enter để tiếp tục");
        new java.util.Scanner(System.in).nextLine();
    }
    static void cot() {
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| STT | Mã số thuế   | Loại xe | Tên    | Hãng  | Năm sản xuất | Giá Tiền | Lệ phí trước bạ(%) | Tên người khai thuế | Dung tích động cơ |");
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
    }
    static void Dong(XeMay xeMay, int stt) {
        System.out.printf("| %-3s | %-12s | %-7s | %-6s | %-6s | %-10s | %-8s | %-18s | %-20s | %-17s |",
                stt, xeMay.getMaSoThue(), xeMay.loaiXe, xeMay.getTenPhuongTien(), xeMay.getHangSanXuat(),
                xeMay.getNamSanXuat(), Math.round(xeMay.getGiaTien()), xeMay.getLePhiTruocBa(), xeMay.getTenNguoiKhaiThue(),
                xeMay.getDungTichDongCo());
        // System.out.println(formattedRow);
        System.out.println("\n+---------------------------------------------------------------------------------------------------------------------------------------+");
    }
    static void Xuất(List<Vehicle> vehicles) {
        // In cột
        cot();

        // In các Dong
        int stt = 1;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.loaiXe.equalsIgnoreCase("XeMay")){
                if (vehicle instanceof XeMay xeMay) {
                    Dong(xeMay, stt);
                    stt++;
                }
            }
        }
    }
    @Override
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
    @Override
    public ArrayList<Vehicle> readData() {
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
    @Override
    public void xoa()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã số thuế của bản ghi cần xóa: ");
        String maSoThueXoa = scanner.nextLine();
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMaSoThue().equals(maSoThueXoa)) {
                vehicles.remove(vehicle);
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Xóa thành công Vehicle có mã số thuế: " + maSoThueXoa);
        } else {
            System.out.println("Không tìm thấy Vehicle nào với mã số thuế: " + maSoThueXoa);
        }
    }
    @Override
    public void edit_vehicle() {
        System.out.println("Sửa thông tin phương tiện");
        System.out.println("1. Xe máy");
        System.out.println("2. Xe ô tô");
        System.out.println("3. Xe ô tô bán tải");
        System.out.println("0. Exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                // Làm việc 1
                System.out.println("Nhập mã số thuế cần sửa của phương tiện");
                String maSoThue = scanner.next();
                scanner.nextLine(); // Bỏ qua dòng trống
                boolean found = false;
                for (Vehicle vehicle : vehicles) {
                    if (vehicle instanceof XeMay xeMay && vehicle.getMaSoThue().equals(maSoThue)) {
                        found = true;
                        System.out.println("Nhập tên cần sửa");
                        String name = scanner.nextLine();
                        // Sử dụng các phương thức của lớp XeMay để sửa đổi thông tin
                        xeMay.setTenPhuongTien(name);

                        System.out.println("Nhập dung tích cần sửa");
                        int dung_tich = scanner.nextInt();
                        xeMay.setDungTichDongCo(dung_tich);

                        scanner.nextLine(); // Bỏ qua dòng trống

                        System.out.println("Nhập tên hãng cần sửa");
                        String ten_hang = scanner.nextLine();
                        xeMay.setHangSanXuat(ten_hang);

                        System.out.println("Nhập năm sản xuất cần sửa");
                        int nsx = scanner.nextInt();
                        xeMay.setNamSanXuat(nsx);

                        System.out.println("Nhập giá tiền cần sửa");
                        double gia = scanner.nextDouble();
                        xeMay.setGiaTien(gia);

                        System.out.println("Nhập lệ phí trước bạ cần sửa");
                        int le_phi_truoc_ba = scanner.nextInt();
                        xeMay.setLePhiTruocBa(le_phi_truoc_ba);

                        scanner.nextLine(); // Bỏ qua dòng trống

                        System.out.println("Nhập tên người khai thuế cần sửa");
                        String nguoikhaithue = scanner.next();
                        xeMay.setTenNguoiKhaiThue(nguoikhaithue);

                        // Thực hiện các thay đổi khác tùy theo yêu cầu

                        // Hiển thị thông tin xe máy sau khi sửa

                        break;
                    }
                }
                if(found)
                {
                    System.out.println("Đã sửa thông tin xe thành công");
                }
                else{
                    System.out.println("không tìm thấy mã số thuế ");
                }
                break;
            }
            case 2: {
                System.out.println("Nhập mã số thuế cần sửa của phương tiện");
                String maSoThue = scanner.next();
                scanner.nextLine(); // Bỏ qua dòng trống
                boolean found = false;
                for (Vehicle vehicle : vehicles) {
                    if (vehicle instanceof XeOtoCon xe_oto_con && vehicle.getMaSoThue().equals(maSoThue)) {
                        found = true;
                        System.out.println("Nhập tên cần sửa");
                        String name = scanner.next();
                        // Sử dụng các phương thức của lớp XeMay để sửa đổi thông tin
                        xe_oto_con.setTenPhuongTien(name);

                        System.out.println("Nhập dung tích cần sửa");
                        int dung_tich = scanner.nextInt();
                        xe_oto_con.setDungTichDongCo(dung_tich);

                        scanner.nextLine(); // Bỏ qua dòng trống

                        System.out.println("Nhập tên hãng cần sửa");
                        String ten_hang = scanner.next();
                        xe_oto_con.setHangSanXuat(ten_hang);

                        System.out.println("Nhập năm sản xuất cần sửa");
                        int nsx = scanner.nextInt();
                        xe_oto_con.setNamSanXuat(nsx);

                        System.out.println("Nhập giá tiền cần sửa");
                        double gia = scanner.nextDouble();
                        xe_oto_con.setGiaTien(gia);

                        System.out.println("Nhập dung tích cốp cần sửa");
                        int dung_tich_cop = scanner.nextInt();
                        xe_oto_con.setDungTichCop(dung_tich_cop);

                        System.out.println("Nhập lệ phí trước bạ cần sửa");
                        int le_phi_truoc_ba = scanner.nextInt();
                        xe_oto_con.setLePhiTruocBa(le_phi_truoc_ba);

                        scanner.nextLine(); // Bỏ qua dòng trống

                        System.out.println("Nhập tên người khai thuế cần sửa");
                        String nguoikhaithue = scanner.next();
                        xe_oto_con.setTenNguoiKhaiThue(nguoikhaithue);

                        // Thực hiện các thay đổi khác tùy theo yêu cầu

                        // Hiển thị thông tin xe máy sau khi sửa
                        System.out.println("Đã sửa thông tin xe thành công");
                        break;
                    }
                }
                if(found)
                {
                    System.out.println("Đã sửa thông tin xe thành công");
                }
                else{
                    System.out.println("không tìm thấy mã số thuế ");
                }
                // Làm việc 2
                break;
            }
            case 3: {
                System.out.println("Nhập mã số thuế cần sửa của phương tiện");
                String maSoThue = scanner.next();
                scanner.nextLine(); // Bỏ qua dòng trống
                boolean found = false;
                for (Vehicle vehicle : vehicles) {
                    if (vehicle instanceof XeOtoBanTai xe_oto_ban_tai && vehicle.getMaSoThue().equals(maSoThue)) {
                        found = true;
                        System.out.println("Nhập tên cần sửa");
                        String name = scanner.nextLine();
                        // Sử dụng các phương thức của lớp XeMay để sửa đổi thông tin
                        xe_oto_ban_tai.setTenPhuongTien(name);

                        System.out.println("Nhập dung tích cần sửa");
                        int dung_tich = scanner.nextInt();
                        xe_oto_ban_tai.setDungTichDongCo(dung_tich);

                        scanner.nextLine(); // Bỏ qua dòng trống

                        System.out.println("Nhập tên hãng cần sửa");
                        String ten_hang = scanner.next();
                        xe_oto_ban_tai.setHangSanXuat(ten_hang);

                        System.out.println("Nhập năm sản xuất cần sửa");
                        int nsx = scanner.nextInt();
                        xe_oto_ban_tai.setNamSanXuat(nsx);

                        System.out.println("Nhập giá tiền cần sửa");
                        double gia = scanner.nextDouble();
                        xe_oto_ban_tai.setGiaTien(gia);

                        System.out.println("Nhập tải trọng xe cần sửa");
                        int tai_trong = scanner.nextInt();
                        xe_oto_ban_tai.setTaiTrong(tai_trong);

                        System.out.println("Nhập chiều dài thùng xe cần sửa");
                        int chieu_dai_thung_xe = scanner.nextInt();
                        xe_oto_ban_tai.setChieuDaiThungXe(chieu_dai_thung_xe);

                        System.out.println("Nhập lệ phí trước bạ cần sửa");
                        int le_phi_truoc_ba = scanner.nextInt();
                        xe_oto_ban_tai.setLePhiTruocBa(le_phi_truoc_ba);

                        scanner.nextLine(); // Bỏ qua dòng trống

                        System.out.println("Nhập tên người khai thuế cần sửa");
                        String nguoikhaithue = scanner.next();
                        xe_oto_ban_tai.setTenNguoiKhaiThue(nguoikhaithue);

                        // Thực hiện các thay đổi khác tùy theo yêu cầu

                        // Hiển thị thông tin xe máy sau khi sửa
                        System.out.println("Đã sửa thông tin xe thành công");
                        break;
                    }
                }
                if(found)
                {
                    System.out.println("Đã sửa thông tin xe thành công");
                }
                else{
                    System.out.println("không tìm thấy mã số thuế ");
                }
                // Làm việc 2
                break;
            }
            case 0: {
                System.out.println("\nĐang thoát...");
                // Thread.sleep(3000);
                System.exit(0);
                break;
            }
            default:
                System.out.println("\nHãy nhập menu hợp lệ!");
                break;
        }
    }
    public void sort(){
//        nhớ ép kiểu từ vehical sang loại phương tiện tương ứng để sử dụng get set của class tương ứng
        System.out.println("--------- Sắp Xếp -----------");
        System.out.println("1. Giá tiền.");
        System.out.println("2. Năm sản xuất.");
        System.out.println("3. Lệ phí trước bạ.");
        System.out.println("0. Thoát.");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("1. Tăng dần.");
                System.out.println("2. Giảm dần.");
                int choice1 = scanner.nextInt();
                switch (choice1) {
                    case 1: {
                        sortGiaTienGiamDan();
                        break;
                    }
                    case 2: {
                        sortGiaTienTangDan();
                        break;
                    }
                    default:
                        break;
                }
                break;
            }
            case 2: {
                System.out.println("1. Tăng dần.");
                System.out.println("2. Giảm dần.");
                int choice2 = scanner.nextInt();
                switch (choice2) {
                    case 1: {
                        sortNamSanXuatGiamDan();
                        break;
                    }
                    case 2: {
                        sortNamSanXuatTangDan();
                        break;
                    }
                    default:
                        break;
                }
                break;
            }
            case 3: {
                System.out.println("1. Tăng dần.");
                System.out.println("2. Giảm dần.");
                int choice3 = scanner.nextInt();
                switch (choice3) {
                    case 1: {
                        sortLePhiTruocBaGiamDan();
                        break;
                    }
                    case 2: {
                        sortLePhiTruocBaTangDan();
                        break;
                    }
                    default:
                        break;
                }
                break;
            }
            case 0: {
                break;
            }
            default:
                break;
        }
        showData();
    }
    public void sortGiaTienGiamDan ()
    {
        vehicles.sort(Comparator.comparing(Vehicle::getGiaTien));
        Collections.reverse(vehicles);
    }

    public void sortGiaTienTangDan ()
    {
        vehicles.sort(Comparator.comparing(Vehicle::getGiaTien));
    }

    public void sortNamSanXuatGiamDan ()
    {
        vehicles.sort(Comparator.comparing(Vehicle::getNamSanXuat));
        Collections.reverse(vehicles);
    }

    public void sortNamSanXuatTangDan ()
    {
        vehicles.sort(Comparator.comparing(Vehicle::getNamSanXuat));
    }

    public void sortLePhiTruocBaGiamDan ()
    {
        vehicles.sort(Comparator.comparing(Vehicle::getLePhiTruocBa));
        Collections.reverse(vehicles);
    }

    public void sortLePhiTruocBaTangDan ()
    {
        vehicles.sort(Comparator.comparing(Vehicle::getLePhiTruocBa));

    }

    public void thongKe(){
//        nhớ ép kiểu từ vehical sang loại phương tiện tương ứng để sử dụng get set của class tương ứng
        System.out.println("Thông kê số lượng xe theo loại phương tiện giao thông"); // làm tạm thống kê loại xe
        System.out.println("1. Loại xe.");
        System.out.println("2. Hãng sản xuất.");
        System.out.println("3. Năm sản xuất.");
        System.out.println("4. Tính thuế");
        System.out.println("0. Thoát.");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                thongkeTheoLoaiXe();
                break;
            }
            case 2: {
                thongkeTheoHang();
                break;
            }
            case 3: {
                thongkeTheoNamSanXuat();
                break;
            }
            case 4:{
                tinhThue();
                break;
            }
            case 0: {
                break;
            }
            default: {
                System.out.println("Vui lòng nhập lại !");
            }
        }
        pause();
    }

    public void tinhThue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã số thuế xe: ");
        String maSoThue = scanner.next();
        for (Vehicle xe : vehicles) {
            if (xe.getMaSoThue().equals(maSoThue)) {
                if (xe instanceof XeMay xeMay) {
                    tinhThueTheoPhuongTien(xeMay);
                } else if (xe instanceof XeOtoCon xeOtoCon) {
                    tinhThueTheoPhuongTien(xeOtoCon);
                } else if (xe instanceof XeOtoBanTai xeOtoBanTai) {
                    tinhThueTheoPhuongTien(xeOtoBanTai);
                }
            }
        }
        System.out.println("Không tìm thấy xe với mã số thuế đã nhập.");
    }
    public void tinhThueTheoPhuongTien(Vehicle vehicle){
        double giaTriThue = vehicle.TinhThueGiaTriGiaTang(vehicle.getGiaTien());
        double lePhiDangKyXe = vehicle.TinhLePhiDangKyXeMoi(vehicle.getGiaTien());
        double thueTruocBa = vehicle.TinhThueTruocBa(vehicle.getGiaTien(), vehicle.getLePhiTruocBa());
        System.out.println("Giá xe là : "+vehicle.getGiaTien());
        System.out.println("Giá trị thuế là: " + String.format("%,d", Math.round(giaTriThue)).replace(",", "."));
        System.out.println("Lệ phí đăng ký xe mới là: " + String.format("%,d", Math.round(lePhiDangKyXe)).replace(",", "."));
        System.out.println("Thuế trước bạ là: " + String.format("%,d", Math.round(thueTruocBa)).replace(",", "."));

        double tongThue = giaTriThue + lePhiDangKyXe + thueTruocBa;
        System.out.println("Tổng các thuế cần đóng là: " + String.format("%,d", Math.round(tongThue)).replace(",", "."));
    }

    public void thongkeTheoLoaiXe() {
        Map<String, Long> stringMap = vehicles.stream().collect(Collectors.groupingBy(Vehicle::getLoaiXe,Collectors.counting()));
            for (Map.Entry<String, Long> stringListEntry : stringMap.entrySet()) {
                System.out.printf("\n Phương tiện giao thông %s có %d chiếc.", stringListEntry.getKey(), stringListEntry.getValue());
            }
    }
    public void thongkeTheoHang() {
        Map<String, Long> stringMap = vehicles.stream().collect(Collectors.groupingBy(Vehicle::getHangSanXuat,Collectors.counting()));
        for (Map.Entry<String, Long> stringListEntry : stringMap.entrySet()) {
            System.out.printf("\n Phương tiện giao thông hãng %s có %d chiếc.", stringListEntry.getKey(), stringListEntry.getValue());
        }
    }
    public void thongkeTheoNamSanXuat() {
        int[] sl = new int[vehicles.size()];
        Arrays.fill(sl, 1);

        for(int i = 0;i< vehicles.size();i++)
        {
            for(int j  = i+1 ;j< vehicles.size();j++)
            {
                var i_j_cungloai = (vehicles.get(i).getNamSanXuat() == vehicles.get(j).getNamSanXuat());
                if(i_j_cungloai && sl[j] != 0)
                {
                    sl[i]++;
                    sl[j]--;
                }
            }
        }
        // Tạo dataset cho biểu đồ
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i = 0;i< sl.length ;i++)
        {

            if (sl[i]!=0)
            {
                dataset.addValue(sl[i], "số lượng" , String.valueOf(vehicles.get(i).getNamSanXuat()));
            }
        }

        // Tạo biểu đồ cột từ dataset
        JFreeChart chart = ChartFactory.createBarChart(
                "Thống kê theo năm sản xuất", // Tiêu đề biểu đồ
                "Năm sản xuất", // Nhãn trục x
                "Số lượng", // Nhãn trục y
                dataset, // Dữ liệu
                PlotOrientation.VERTICAL, // Hướng biểu đồ
                true, // Có hiển thị chú thích không
                true, // Có hiển thị URL không
                false // Có tạo tooltips không
        );

        // Hiển thị biểu đồ trong cửa sổ
        ChartFrame frame = new ChartFrame("Biểu đồ thống kê", chart);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setVisible(true);
    }
    public static String xoaDauTV(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

    public void timKiem ()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bạn muốn tìm kiếm loại xe nào?");
        System.out.println("1,Xe máy");
        System.out.println("2,Xe ô tô");
        System.out.println("3,Xe ô tô bán tải");

        System.out.print("\n Nhập lựa chọn: ");
        var choice = scanner.nextInt();

        System.out.print("\n Nhập từ khóa cần tìm kiếm: ");
        var key = scanner.next();

        switch (choice){
            case 1:{
                XeMay xeMay;

                cot_xe_may();
                int stt = 1;
                for (Vehicle vehicle : vehicles) {

                    if ((vehicle instanceof XeMay) && (xoaDauTV(vehicle.getTenPhuongTien()).toLowerCase().contains(key.toLowerCase()))) {
                        xeMay = (XeMay) vehicle;
                        Dong_xe_may(xeMay, stt);
                        stt++;
                    }

                }
                if (stt == 1)
                    System.out.println("Không tìm thấy phương tiện phù hợp");
                break;
            }
            case 2:{
                XeOtoCon xeOtoCon;

                cot_print_oto_con();
                int stt = 1;
                for (Vehicle vehicle : vehicles) {

                    if ((vehicle instanceof XeOtoCon) && (xoaDauTV(vehicle.getTenPhuongTien()).toLowerCase().contains(key.toLowerCase()))) {
                        xeOtoCon = (XeOtoCon) vehicle;
                        Dong_print_oto_con(xeOtoCon, stt);
                        stt++;
                    }

                }
                if (stt == 1)
                    System.out.println("Không tìm thấy phương tiện phù hợp");
                break;
            }
            case 3:{
                XeOtoBanTai xeOtoBanTai;

                cot_print_oto_ban_tai();
                int stt = 1;
                for (Vehicle vehicle : vehicles) {

                    if ((vehicle instanceof XeOtoBanTai) && (xoaDauTV(vehicle.getTenPhuongTien()).toLowerCase().contains(key.toLowerCase()))) {
                        xeOtoBanTai = (XeOtoBanTai) vehicle;
                        Dong_print_oto_ban_tai(xeOtoBanTai, stt);
                        stt++;
                    }

                }
                if (stt == 1)
                    System.out.println("Không tìm thấy phương tiện phù hợp");
                break;
            }
            default:{
                System.out.print("Vui lòng nhập lại!");
            }
        }
        pause();
    }
}
