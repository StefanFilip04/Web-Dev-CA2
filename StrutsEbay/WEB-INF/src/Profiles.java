import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import org.apache.struts2.interceptor.SessionAware;

public class Profiles implements SessionAware {
    
    private String view_user;
    private String userId;
    private String userName;
    private Map<String, Object> session;
    private Map<String, Object> userProfile;
    private List<Map<String, Object>> allUsers;

    public Profiles() {
    }
    
    // view user
    public String getProfile() {
        String currentUser = (String) session.get("currentUser");
        if (currentUser == null) {
            return "error";
        }
        
        try (Connection conn = Database.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, currentUser);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                userProfile = new java.util.HashMap<>();
                userProfile.put("id", rs.getInt("id"));
                userProfile.put("username", rs.getString("username"));
                userProfile.put("email", rs.getString("email"));
                
                session.put("viewedProfile", userProfile);
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }




    //view user
    public String viewUserProfile() {
        if (userId == null || userId.isEmpty()) {
            return "error";
        }
        
        try (Connection conn = Database.getConnection()) {
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(userId));
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                userProfile = new java.util.HashMap<>();
                userProfile.put("id", rs.getInt("id"));
                userProfile.put("username", rs.getString("username"));
                userProfile.put("email", rs.getString("email"));
                session.put("viewedProfile", userProfile);
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }



    // view all 
    public String getUsers() {
        try (Connection conn = Database.getConnection()) {
            String query = "SELECT * FROM users";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            allUsers = new ArrayList<>();
            while (rs.next()) {
                Map<String, Object> user = new java.util.HashMap<>();
                user.put("id", rs.getInt("id"));
                user.put("username", rs.getString("username"));
                user.put("email", rs.getString("email"));
                //add another user
                allUsers.add(user);
            }
            session.put("allUsers", allUsers);
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

    public String getView_user() {
        return view_user;
    }

    public void setView_user(String view_user) {
        this.view_user = view_user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<String, Object> getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(Map<String, Object> userProfile) {
        this.userProfile = userProfile;
    }

    public List<Map<String, Object>> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<Map<String, Object>> allUsers) {
        this.allUsers = allUsers;
    }
}