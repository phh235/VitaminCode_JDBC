package org.example.system;


import org.example.crudCtrl.crudCtrlImpl.crudLocator;
import org.example.crudCtrl.crudCtrlImpl.crudWarehouse;

import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);
    public static crudWarehouse crudWarehouse = new crudWarehouse();
    public static crudLocator crudLocator = new crudLocator();

    // Main Menu
    public void menuMain() {
        System.out.println("┌────────────────────────────┐");
        System.out.println("│          MAIN MENU         │");
        System.out.println("├────────────────────────────┤");
        System.out.println("│ 1. Quản lý Warehouse       │");
        System.out.println("│ 2. Quản lý Locator         │");
        System.out.println("│ 3. Quản lý sản phẩm        │");
        System.out.println("│ 0. Thoát                   │");
        System.out.println("└────────────────────────────┘");
        System.out.print("Chọn chức năng cần sử dụng: ");
    }


    // Menu Warehouse
    public void menuWareHouse() {
        System.out.println("┌------------ Warehouse ------------┐");
        System.out.println("|1. Xem tất cả thông tin warehouse  |");
        System.out.println("|2. Thêm mới warehouse              |");
        System.out.println("|3. Cập nhật warehouse              |");
        System.out.println("|4. Xóa warehouse                   |");
        System.out.println("|5. Tìm warehouse                   |");
        System.out.println("|0. Quay lại                        |");
        System.out.println("└-----------------------------------┘");
        System.out.print("Chọn chức năng cần sử dụng: ");
    }

    public void runWarehouse() {
        boolean running = true;
        while (running) {
            menuWareHouse();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    crudWarehouse.read();
                    break;
                case 2:
                    crudWarehouse.insert();
                    break;
                case 3:
                    crudWarehouse.update();
                    break;
                case 4:
                    crudWarehouse.delete();
                    break;
                case 5:
                    crudWarehouse.findByName();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    // Menu Locator
    public void menuLocator() {
        System.out.println("┌------------- Locator -------------┐");
        System.out.println("|1. Xem tất cả thông tin locator    |");
        System.out.println("|2. Thêm mới locator                |");
        System.out.println("|3. Cập nhật locator                |");
        System.out.println("|4. Xóa locator                     |");
        System.out.println("|5. Tìm locator                     |");
        System.out.println("|6. Sắp xếp locator tăng dần        |");
        System.out.println("|7. Sắp xếp locator giảm dần        |");
        System.out.println("|0. Quay lại                        |");
        System.out.println("└-----------------------------------┘");
        System.out.print("Chọn chức năng cần sử dụng: ");
    }

    public void runLocator() {
        boolean running = true;
        while (running) {
            menuLocator();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    crudLocator.read();
                    break;
                case 2:
                    crudLocator.insert();
                    break;
                case 3:
                    crudLocator.update();
                    break;
                case 4:
                    crudLocator.delete();
                    break;
                case 5:
                    crudLocator.findByName();
                    break;
                case 6:
                    crudLocator.sort("asc");
                    break;
                case 7:
                    crudLocator.sort("desc");
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }


    // Run Main Menu
    public void run() {
        boolean running = true;
        while (running) {
            menuMain();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    runWarehouse();
                    break;
                case 2:
                    runLocator();
                    break;
                case 3:
//                    runProduct();
                    break;
                case 0:
                    running = false;
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}