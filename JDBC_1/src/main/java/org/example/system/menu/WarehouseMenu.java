package org.example.system.menu;import org.example.crudCtrl.crudCtrlImpl.crudWarehouse;import java.util.Scanner;public class WarehouseMenu {    private static Scanner sc = new Scanner(System.in);    private static crudWarehouse crudWarehouse = new crudWarehouse();    public static void displayMenu() {        System.out.println("┌------------ Warehouse ------------┐");        System.out.println("|1. Xem tất cả thông tin warehouse  |");        System.out.println("|2. Thêm mới warehouse              |");        System.out.println("|3. Cập nhật warehouse              |");        System.out.println("|4. Xóa warehouse                   |");        System.out.println("|5. Tìm warehouse                   |");        System.out.println("|0. Quay lại                        |");        System.out.println("└-----------------------------------┘");        System.out.print("Chọn chức năng cần sử dụng: ");    }    public static void runWarehouse() {        boolean running = true;        while (running) {            displayMenu();            int option = sc.nextInt();            switch (option) {                case 1:                    crudWarehouse.read();                    break;                case 2:                    crudWarehouse.insert();                    break;                case 3:                    crudWarehouse.update();                    break;                case 4:                    crudWarehouse.delete();                    break;                case 5:                    crudWarehouse.findByName();                    break;                case 0:                    running = false;                    break;                default:                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");            }        }    }}