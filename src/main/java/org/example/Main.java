package org.example;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.data.Vehicle;
import org.example.data.XeMay;
import org.example.data.XeOtoCon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        while (true) {
            System.out.println("\n+-------------------------------------------------------------------------------------------------------+");
            System.out.println("\n| CHƯƠNG TRÌNH QUẢN LÝ THUẾ ĐĂNG KÝ PHƯƠNG TIỆN GIAO THÔNG.                                             |");
            System.out.println("\n+---------------------------------------------MENU------------------------------------------------------+");
            System.out.println("\n| 1.Thêm | 2.Hiển thị | 3.Sửa | 4.Xóa| 5.Sắp xếp | 6. Thống kê | 0. Thoát |                             |");
            System.out.println("\n+-------------------------------------------------------------------------------------------------------+");

            System.out.println("\n Chọn menu: ");
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
                    manager.edit_vehicle();
                    break;
                case 4:
                    // làm việc 4
                    manager.xoa();
                    break;
                case 5:
                    // làm việc 5
                    manager.sort();
                    break;
                case 6:
                    // làm việc 6
                    manager.thongKe();
                    break;
                case 0:
                    System.out.println("\n Đang thoát...");
                    // Thread.sleep(3000);
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n Hãy nhập menu hợp lệ !");
                    break;
            }

        }
    }
}