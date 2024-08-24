package org.example;

import org.example.dao.daoImpl.LocatorDAO;
import org.example.dao.daoImpl.WarehouseDAO;
import org.example.entity.Locator;
import org.example.entity.Warehouse;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final WarehouseDAO warehouseDAO = new WarehouseDAO();
    private static final LocatorDAO locatorDAO = new LocatorDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("+-----------------------------------------------+");
            System.out.printf("| %-45s |\n", "Menu chính:");
            System.out.println("+-----------------------------------------------+");
            System.out.printf("| %-2s | %-40s |\n", "1", "Quản lý Warehouse");
            System.out.printf("| %-2s | %-40s |\n", "2", "Quản lý Locator");
            System.out.printf("| %-2s | %-40s |\n", "3", "Sắp xếp sản phẩm theo số lượng tồn kho");
            System.out.printf("| %-2s | %-40s |\n", "4", "Sắp xếp vị trí Locator");
            System.out.printf("| %-2s | %-40s |\n", "0", "Thoát");
            System.out.println("+-----------------------------------------------+");
            System.out.print("Chọn mục bạn cần dùng: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageWarehouse(scanner);
                    break;

                case 2:
                    manageLocator(scanner);
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void manageWarehouse(Scanner scanner) {
        int choice;
        do {
            System.out.println("+-------------------------------------+");
            System.out.printf("| %-35s |\n", "Quản lý Warehouse:");
            System.out.println("+-------------------------------------+");
            System.out.printf("| %-2s | %-30s |\n", "1", "Thêm Warehouse");
            System.out.printf("| %-2s | %-30s |\n", "2", "Xóa Warehouse");
            System.out.printf("| %-2s | %-30s |\n", "3", "Sửa Warehouse");
            System.out.printf("| %-2s | %-30s |\n", "4", "Xem toàn bộ Warehouse");
            System.out.printf("| %-2s | %-30s |\n", "5", "Tìm Warehouse theo tên tương đối");
            System.out.printf("| %-2s | %-30s |\n", "0", "Quay lại");
            System.out.println("+-------------------------------------+");
            System.out.print("Chọn chức năng bạn cần dùng: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên Warehouse: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập trạng thái (true/false): ");
                    boolean isActive = scanner.nextBoolean();
                    scanner.nextLine();
                    System.out.print("Nhập mô tả: ");
                    String description = scanner.nextLine();
                    System.out.print("Nhập người tạo: ");
                    String createdBy = scanner.nextLine();

                    Warehouse newWarehouse = new Warehouse();
                    newWarehouse.setName(name);
                    newWarehouse.setActive(isActive);
                    newWarehouse.setDescription(description);
                    newWarehouse.setCreatedBy(createdBy);
                    newWarehouse.setCreated(new Timestamp(System.currentTimeMillis()).toLocalDateTime());

                    warehouseDAO.create(newWarehouse);
                    break;

                case 2:
                    // Xóa Warehouse
                    System.out.print("Nhập ID Warehouse cần xóa: ");
                    int deleteId = scanner.nextInt();
                    warehouseDAO.delete(deleteId);
                    break;

                case 3:
                    // Sửa Warehouse
                    System.out.print("Nhập ID Warehouse cần sửa: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Nhập trạng thái mới (true/false): ");
                    boolean updateIsActive = scanner.nextBoolean();
                    scanner.nextLine();
                    System.out.print("Nhập mô tả mới: ");
                    String updateDescription = scanner.nextLine();
                    System.out.print("Nhập người tạo mới: ");
                    String updateCreatedBy = scanner.nextLine();

                    Warehouse updateWarehouse = new Warehouse();
                    updateWarehouse.setId(updateId);
                    updateWarehouse.setName(updateName);
                    updateWarehouse.setActive(updateIsActive);
                    updateWarehouse.setDescription(updateDescription);
                    updateWarehouse.setCreatedBy(updateCreatedBy);
                    updateWarehouse.setCreated(new Timestamp(System.currentTimeMillis()).toLocalDateTime());

                    warehouseDAO.update(updateWarehouse);
                    break;

                case 4:
                    // Đọc Warehouse
                    List<Warehouse> warehouses = warehouseDAO.findAll();
                    System.out.printf("%-5s %-20s %-20s %-40s %-30s %-20s%n", "ID", "Tên", "Trạng thái", "Mô tả",
                            "Người tạo", "Ngày tạo");
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
                    for (Warehouse wh : warehouses) {
                        System.out.printf("%-5d %-20s %-20s %-40s %-30s %-20s%n",
                                wh.getId(),
                                wh.getName(),
                                wh.getActive(),
                                wh.getDescription(),
                                wh.getCreatedBy(),
                                wh.getCreated());
                    }
                    break;

                case 5:
                    // Tìm Warehouse theo tên
                    System.out.print("Nhập tên Warehouse để tìm: ");
                    String searchName = scanner.nextLine();
                    List<Warehouse> searchedWarehouses = warehouseDAO.findByName(searchName);

                    if (searchedWarehouses.isEmpty()) {
                        System.out.println("Không tìm thấy Warehouse với tên chứa \"" + searchName + "\".");
                    } else {
                        System.out.printf("%-5s %-20s %-20s %-40s %-30s %-20s%n", "ID", "Tên", "Trạng thái", "Mô tả",
                                "Người tạo", "Ngày tạo");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
                        for (Warehouse wh : searchedWarehouses) {
                            System.out.printf("%-5d %-20s %-20s %-40s %-30s %-20s%n",
                                    wh.getId(),
                                    wh.getName(),
                                    wh.getActive(),
                                    wh.getDescription(),
                                    wh.getCreatedBy(),
                                    wh.getCreated());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 0);
    }

    private static void manageLocator(Scanner scanner) {
        int choice;
        do {
            System.out.println("+-------------------------------------+");
            System.out.printf("| %-35s |\n", "Quản lý Locator:");
            System.out.println("+-------------------------------------+");
            System.out.printf("| %-2s | %-30s |\n", "1", "Thêm Locator");
            System.out.printf("| %-2s | %-30s |\n", "2", "Xóa Locator");
            System.out.printf("| %-2s | %-30s |\n", "3", "Sửa Locator");
            System.out.printf("| %-2s | %-30s |\n", "4", "Xem tất cả Locator");
            System.out.printf("| %-2s | %-30s |\n", "5", "Tìm Locator theo tên");
            System.out.printf("| %-2s | %-30s |\n", "0", "Quay lại");
            System.out.println("+-------------------------------------+");
            System.out.print("Chọn chức năng bạn cần dùng: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Thêm Locator
                    System.out.print("Nhập tên Locator: ");
                    String locatorName = scanner.nextLine();
                    System.out.print("Nhập trạng thái (true/false): ");
                    boolean isActive = scanner.nextBoolean();
                    System.out.print("Nhập tọa độ x: ");
                    int x = scanner.nextInt();
                    System.out.print("Nhập tọa độ y: ");
                    int y = scanner.nextInt();
                    System.out.print("Nhập tọa độ z: ");
                    int z = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập người tạo: ");
                    String createdBy = scanner.nextLine();
                    System.out.print("Nhập ID Warehouse: ");
                    int warehouseId = scanner.nextInt();
                    scanner.nextLine();

                    Locator newLocator = new Locator();
                    newLocator.setName(locatorName);
                    newLocator.setActive(isActive);
                    newLocator.setX(x);
                    newLocator.setY(y);
                    newLocator.setZ(z);
                    newLocator.setCreated(new Timestamp(System.currentTimeMillis()).toLocalDateTime());
                    newLocator.setCreatedBy(createdBy);

                    Optional<Warehouse> warehouse = warehouseDAO.findById(warehouseId);
                    newLocator.setWarehouse(warehouse.orElse(null));

                    locatorDAO.create(newLocator);
                    break;

                case 2:
                    // Xóa Locator
                    System.out.print("Nhập ID Locator cần xóa: ");
                    int deleteLocatorId = scanner.nextInt();
                    locatorDAO.delete(deleteLocatorId);
                    break;

                case 3:
                    // Sửa Locator
                    System.out.print("Nhập ID Locator cần sửa: ");
                    int updateLocatorId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String updateLocatorName = scanner.nextLine();
                    System.out.print("Nhập tọa độ x mới: ");
                    int updateX = scanner.nextInt();
                    System.out.print("Nhập tọa độ y mới: ");
                    int updateY = scanner.nextInt();
                    System.out.print("Nhập tọa độ z mới: ");
                    int updateZ = scanner.nextInt();
                    scanner.nextLine();

                    Locator updateLocator = new Locator();
                    updateLocator.setId(updateLocatorId);
                    updateLocator.setName(updateLocatorName);
                    updateLocator.setX(updateX);
                    updateLocator.setY(updateY);
                    updateLocator.setZ(updateZ);

                    locatorDAO.update(updateLocator);
                    break;

                case 4:
                    // Đọc Locator
                    List<Locator> locators = locatorDAO.findAll();
                    System.out.printf("%-5s %-20s %-10s %-10s %-10s %-30s %-20s %-20s%n",
                            "ID", "Tên", "X", "Y", "Z", "Trạng thái", "Người tạo", "Ngày tạo");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    for (Locator locator : locators) {
                        System.out.printf("%-5d %-20s %-10d %-10d %-10d %-30s %-20s %-20s%n",
                                locator.getId(),
                                locator.getName(),
                                locator.getX(),
                                locator.getY(),
                                locator.getZ(),
                                locator.getActive() ? "Hoạt động" : "Không hoạt động",
                                locator.getCreatedBy(),
                                locator.getCreated().toString());
                    }
                    break;

                case 5:
                    // Tìm Locator theo tên
                    System.out.print("Nhập tên Locator để tìm: ");
                    String searchName = scanner.nextLine();
                    Optional<Locator> searchedLocator = locatorDAO.findByNameOnly(searchName);

                    if (searchedLocator.isEmpty()) {
                        System.out.println("Không tìm thấy Locator với tên \"" + searchName + "\".");
                    } else {
                        Locator locator = searchedLocator.get();
                        System.out.printf("%-5s %-20s %-10s %-10s %-10s %-30s %-20s %-20s%n",
                                "ID", "Tên", "X", "Y", "Z", "Trạng thái", "Người tạo", "Ngày tạo");
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("%-5d %-20s %-10d %-10d %-10d %-30s %-20s %-20s%n",
                                locator.getId(),
                                locator.getName(),
                                locator.getX(),
                                locator.getY(),
                                locator.getZ(),
                                locator.getActive() ? "Hoạt động" : "Không hoạt động",
                                locator.getCreatedBy(),
                                locator.getCreated().toString());
                    }
                    break;

                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 0);
    }
}