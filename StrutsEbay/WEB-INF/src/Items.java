import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import org.apache.struts2.interceptor.SessionAware;

public class Items implements SessionAware {
    
    private String item_name;
    private double item_price;
    private Map<String, Object> session;
    private List<Item> allItems;

    public Items() {
    }
    

    
    // add functions
    public String addItem() {
        String currentUser = (String) session.get("currentUser");
        Integer userId = (Integer) session.get("userId");
        
        if (currentUser == null || userId == null) {
            return "error";
        }
        
        if (item_name == null || item_name.isEmpty() || item_price <= 0) {
            return "error";
        }
        
        try (Connection conn = Database.getConnection()) {
            String query = "INSERT INTO items (name, price, seller, seller_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, item_name);
            ps.setDouble(2, item_price);
            ps.setString(3, currentUser);
            ps.setInt(4, userId);
            ps.executeUpdate();
            
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
    
    // viwe all
    public String getItems() {
        try (Connection conn = Database.getConnection()) {
            String query = "SELECT * FROM items";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            allItems = new ArrayList<>();
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getDouble("price"));
                item.setSeller(rs.getString("seller"));
                allItems.add(item);
            }
            session.put("allItems", allItems);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
    
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void setSession(Map map) {
        session = map;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    
    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public List<Item> getAllItems() {
        return allItems;
    }

    public void setAllItems(List<Item> allItems) {
        this.allItems = allItems;
    }
}

