package org.example.dao.daoImpl;import org.example.dao.CRUDOperations;import org.example.entity.Warehouse;import org.example.utils.Helper;import java.sql.*;import java.util.ArrayList;import java.util.List;import java.util.Optional;public class WarehouseDAO implements CRUDOperations<Warehouse> {    private static final String SELECT_ALL_WAREHOUSE_SQL = "SELECT * FROM warehouse";    private static final String SELECT_WAREHOUSE_BY_ID_SQL = "SELECT * FROM warehouse WHERE id = ?";    private static final String SELECT_WAREHOUSE_BY_NAME_SQL = "SELECT * FROM warehouse WHERE name LIKE ?";    private static final String INSERT_WAREHOUSE_SQL = "INSERT INTO warehouse (name, is_active, description, " +            "created_by, created) VALUES (?, ?, ?, ?, ?)";    private static final String UPDATE_WAREHOUSE_SQL = "UPDATE warehouse SET name = ?, is_active = ?, description = ?, " +            "created_by = ?, created = ? WHERE id = ?";    private static final String DELETE_WAREHOUSE_SQL = "DELETE FROM warehouse WHERE id = ?";    @Override    public void create(Warehouse warehouse) {        try {            Helper.executeUpdate(INSERT_WAREHOUSE_SQL,                    warehouse.getName(),                    warehouse.isActive(),                    warehouse.getDescription(),                    warehouse.getCreatedBy(),                    warehouse.getCreated()            );            System.out.println("Đã thêm warehouse thành công");        } catch (Exception e) {            System.out.println("Thêm warehouse thất bại");            e.printStackTrace();        }    }    @Override    public List<Warehouse> findAll() {        List<Warehouse> warehouses = new ArrayList<>();        try (ResultSet rs = Helper.executeQuery(SELECT_ALL_WAREHOUSE_SQL)) {            while (rs.next()) {                Warehouse wareHouse = new Warehouse();                wareHouse.setId(rs.getInt("id"));                wareHouse.setName(rs.getString("name"));                wareHouse.setActive(rs.getBoolean("is_active"));                wareHouse.setDescription(rs.getString("description"));                wareHouse.setCreatedBy(rs.getString("created_by"));                wareHouse.setCreated(rs.getTimestamp("created"));                warehouses.add(wareHouse);            }        } catch (SQLException e) {            e.printStackTrace();        }        return warehouses;    }    @Override    public Optional<Warehouse> findById(int id) {        Warehouse warehouse = null;        try (Connection connection = Helper.getConnection();             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WAREHOUSE_BY_ID_SQL)) {            preparedStatement.setInt(1, id);            ResultSet rs = preparedStatement.executeQuery();            if (rs.next()) {                warehouse = new Warehouse();                warehouse.setId(rs.getInt("id"));                warehouse.setName(rs.getString("name"));                warehouse.setActive(rs.getBoolean("is_active"));                warehouse.setDescription(rs.getString("description"));                warehouse.setCreatedBy(rs.getString("created_by"));                warehouse.setCreated(rs.getTimestamp("created"));            }        } catch (SQLException e) {            e.printStackTrace();        }        return Optional.ofNullable(warehouse);    }    @Override    public List<Warehouse> findByName(String name) {        List<Warehouse> warehouses = new ArrayList<>();        try {            ResultSet rs = Helper.executeQuery(SELECT_WAREHOUSE_BY_NAME_SQL, "%" + name + "%");            while (rs.next()) {                Warehouse warehouse = new Warehouse();                warehouse.setId(rs.getInt("id"));                warehouse.setName(rs.getString("name"));                warehouse.setActive(rs.getBoolean("is_active"));                warehouse.setDescription(rs.getString("description"));                warehouse.setCreatedBy(rs.getString("created_by"));                warehouse.setCreated(rs.getTimestamp("created"));                warehouses.add(warehouse);            }        } catch (Exception e) {            e.printStackTrace();        }        return warehouses;    }    @Override    public Optional<Warehouse> findByNameOnly(String name) {        return Optional.empty();    }    @Override    public void update(Warehouse warehouse) {        try {            Helper.executeUpdate(UPDATE_WAREHOUSE_SQL,                    warehouse.getName(),                    warehouse.isActive(),                    warehouse.getDescription(),                    warehouse.getCreatedBy(),                    warehouse.getCreated(),                    warehouse.getId()            );            System.out.println("Cập nhật warehouse thành công");        } catch (Exception e) {            System.out.println("Cập nhật warehouse thất bại");            e.printStackTrace();        }    }    @Override    public void delete(int id) {        try {            Helper.executeUpdate(DELETE_WAREHOUSE_SQL, id);            System.out.println("Xóa warehouse thành công");        } catch (Exception e) {            System.out.println("Xóa warehouse thất bại");            e.printStackTrace();        }    }}