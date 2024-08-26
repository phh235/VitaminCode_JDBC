package org.example.dao.daoImpl;import org.example.entity.ProductCombo;import org.example.entity.ProductItem;import org.example.entity.abstractClass.abstractProduct;import org.example.utils.Helper;import org.example.utils.ProductType;import java.sql.ResultSet;import java.sql.SQLException;import java.util.ArrayList;import java.util.List;public class ProductDAO {    private static final String SELECT_PRODUCTS_ASC = "SELECT * FROM product ORDER BY ID ASC;";    private static final String SELECT_PRODUCTS_DESC = "SELECT * FROM product ORDER BY ID DESC;";    public abstractProduct create(ResultSet rs) throws SQLException {        String productType = rs.getString("product_type");        if ("COMBO".equals(productType)) {            return new ProductCombo(                    rs.getInt("id"),                    rs.getString("name"),                    rs.getBoolean("is_active"),                    rs.getInt("locator_id"),                    rs.getTimestamp("created"),                    rs.getString("created_by"),                    rs.getInt("qty_stock"),                    rs.getInt("product_parent_id"),                    ProductType.COMBO            );        } else if ("ITEM".equals(productType)) {            return new ProductItem(                    rs.getInt("id"),                    rs.getString("name"),                    rs.getBoolean("is_active"),                    rs.getInt("locator_id"),                    rs.getTimestamp("created"),                    rs.getString("created_by"),                    rs.getInt("qty_stock"),                    rs.getInt("product_parent_id"),                    ProductType.ITEM            );        } else {            return null;        }    }    public List<abstractProduct> selectAllAsc() {        List<abstractProduct> list = new ArrayList<>();        try {            ResultSet rs = Helper.executeQuery(SELECT_PRODUCTS_ASC);            while (rs.next()) {                abstractProduct product = create(rs);                if (product != null) {                    list.add(product);                }            }        } catch (SQLException e) {            e.printStackTrace();        }        return list;    }    public List<abstractProduct> selectAllDesc() {        List<abstractProduct> list = new ArrayList<>();        try {            ResultSet rs = Helper.executeQuery(SELECT_PRODUCTS_DESC);            while (rs.next()) {                abstractProduct product = create(rs);                if (product != null) {                    list.add(product);                }            }        } catch (SQLException e) {            e.printStackTrace();        }        return list;    }}