package org.example.system;


import org.example.system.menu.*;

import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);
    WarehouseMenu warehouseMenu = new WarehouseMenu();
    LocatorMenu locatorMenu = new LocatorMenu();
    ProductMenu productMenu = new ProductMenu();

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

    // Run Main Menu
    public void runMainMenu() {
        boolean running = true;
        while (running) {
            menuMain();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    warehouseMenu.runWarehouse();
                    break;
                case 2:
                    locatorMenu.runLocator();
                    break;
                case 3:
                    productMenu.runProduct();
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