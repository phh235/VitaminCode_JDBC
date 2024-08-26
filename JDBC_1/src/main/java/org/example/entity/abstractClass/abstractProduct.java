package org.example.entity.abstractClass;import java.sql.Timestamp;import java.util.Scanner;public abstract class abstractProduct {    private int id;    private String name;    private Boolean isActive;    private int locatorId;    private Timestamp created;    private String createdBy;    private int qtyStock;    private int productParentId;    public abstractProduct() {    }    public abstractProduct(int id, String name, Boolean isActive, int locatorId, Timestamp created, String createdBy,                           int qtyStock, int productParentId) {        this.id = id;        this.name = name;        this.isActive = isActive;        this.locatorId = locatorId;        this.created = created;        this.createdBy = createdBy;        this.qtyStock = qtyStock;        this.productParentId = productParentId;    }    public int getId() {        return id;    }    public void setId(int id) {        this.id = id;    }    public String getName() {        return name;    }    public void setName(String name) {        this.name = name;    }    public Boolean getActive() {        return isActive;    }    public void setActive(Boolean active) {        isActive = active;    }    public int getLocator() {        return locatorId;    }    public void setLocator(int locatorId) {        this.locatorId = locatorId;    }    public Timestamp getCreated() {        return created;    }    public void setCreated(Timestamp created) {        this.created = created;    }    public String getCreatedBy() {        return createdBy;    }    public void setCreatedBy(String createdBy) {        this.createdBy = createdBy;    }    public int getQtyStock() {        return qtyStock;    }    public void setQtyStock(int qtyStock) {        this.qtyStock = qtyStock;    }    public int getProductParentId() {        return productParentId;    }    public void setProductParentId(int productParentId) {        this.productParentId = productParentId;    }    public void input(Scanner sc) {        System.out.print("Nhập tên: ");        this.name = sc.nextLine();        System.out.print("Nhập người tạo: ");        this.createdBy = sc.nextLine();//        System.out.println("1. Đang hoạt động - 2. Ngừng hoạt động");        this.isActive = sc.nextInt() == 1;        sc.nextLine();        System.out.print("Nhập số lượng: ");        this.qtyStock = sc.nextInt();        System.out.print("Nhập Locator ID: ");        this.locatorId = sc.nextInt();        System.out.print("Nhập Paren Product ID: ");        this.productParentId = sc.nextInt();        sc.nextLine();        this.created = new Timestamp(System.currentTimeMillis());    }}