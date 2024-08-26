package org.example.system;


import org.example.crudController.crudCtrlImpl.crudWarehouse;

import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    static crudWarehouse crudWarehouse = new crudWarehouse();

    // Main Menu
    public void menuMain() {
        System.out.println("|======= System Menu =======|");
        System.out.println("|1. Manage ware house       |");
        System.out.println("|2. Manage locators         |");
        System.out.println("|3. Manage product          |");
        System.out.println("|5. Exit                    |");
        System.out.println("|===========================|");
        System.out.print("Select a function: ");
    }

    // Menu Ware House
    public void menuWareHouse() {
        System.out.println("|======= Menu Ware House =======|");
        System.out.println("|1. View all Ware House records |");
        System.out.println("|2. Add a Ware House            |");
        System.out.println("|3. Update ware house           |");
        System.out.println("|4. Delete ware house           |");
        System.out.println("|5. Exit                        |");
        System.out.println("|===============================|");
        System.out.print("Select a function: ");
    }

    public void runWareHouse() {
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
                    running = false;
                    System.out.println("You have returned to the main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    // Run the whole system
    public void run() {
        boolean running = true;
        while (running) {
            menuMain();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    runWareHouse();
                    break;
                case 2:
//                    runLocators();
                    break;
                case 3:
//                    runProduct();
                    break;
                case 5:
                    running = false;
                    System.out.println("You have exited the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
}