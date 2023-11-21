package org.example;

import java.util.Scanner;
import static java.lang.System.out;
import org.example.data.XeMay;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Manager manager = new Manager();
        // manager.add_vehicles();
        // // manager.saveData();
        // // manager.readData();
        // manager.showData();
                while (true) {
            out.print("\n+----------------------------------------------------------------------+");
            out.print("\n| CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN. (c) 2022.04.22 11h54                 |");
            out.print("\n+--------------------------------MENU----------------------------------+");
            out.print("\n| 1.Thêm | 2.Sửa | 3.Xoá | 4.Sắp Xếp | 5.Thống Kê | 6.MMA | 7.Tìm Kiếm |");
            out.print("\n| 8.Ghi File | 9. Đọc File | 0. Thoát                                  |");
            out.print("\n+----------------------------------------------------------------------+");

            out.print("\n Chọn menu: ");
            var scan = new Scanner(System.in);
            var menu = scan.nextInt();
            // scan.close();

            switch (menu) {
                case 1:
                    // làm việc 1
                    manager.add_vehicles();
                    break;
                case 2:
                    // làm việc 2
                    manager.showData();
                    break;
                case 3:
                    // làm việc 3
                    // manager.Xóa();
                    
                    break;
                case 4:
                    // làm việc 4
                    // manager.XếpGiảmDầnTheoĐiểm();
                    break;
                case 5:
                    // làm việc 5
                    // manager.PhânLoạiTheoNhómMáu();
                    break;
                case 6:
                    // làm việc 6
                    // manager.MMA();
                    break;
                case 7:
                    // làm việc 7
                    // manager.Tìm();
                    break;
                case 8:
                    // làm việc 8
                    // manager.gan_and_write();
                    break;
                case 9:
                    // làm việc 9
                    // manager.Doc();
                    break;
                case 0:
                    out.print("\n Đang thoát...");
                    // Thread.sleep(3000);
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    out.print("\n Hãy nhập menu hợp lệ !");
                    break;
            }

        } // kết thúc vòng lặp menu
    }
}