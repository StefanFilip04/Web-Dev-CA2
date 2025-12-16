import java.util.Map;
import java.sql.*;
import org.apache.struts2.interceptor.SessionAware;

public class SessionExample implements SessionAware {
    
    private String username;
    private String password;
    private Map<String, Object> session;




    public String login() {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return "error";
        }
        
        try (Connection conn = Database.getConnection()) {
            if (conn == null) {
                System.out.println("Database connection failed");
                return "error";
            }
            
            try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
                stmt.setString(1, username.trim());
                stmt.setString(2, password.trim());
                
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        session.put("currentUser", username);
                        return "success";
                    } else {
                        System.out.println("Login failed: No matching user found for username: " + username);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
            e.printStackTrace();
        }
        return "error";
    }




    public String register() {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return "error";
        }
        
        try (Connection conn = Database.getConnection()) {
            if (conn == null) {
                System.out.println("Database connection failed");
                return "error";
            }
            
            //check user exist
            try (PreparedStatement checkStmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?")) {
                checkStmt.setString(1, username.trim());
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("User already exists: " + username);
                        return "error";
                    }
                }
            }
            
            //make user
            try (PreparedStatement insertStmt = conn.prepareStatement(
                    "INSERT INTO users (username, password) VALUES (?, ?)", 
                    Statement.RETURN_GENERATED_KEYS)) {
                
                insertStmt.setString(1, username.trim());
                insertStmt.setString(2, password.trim());
                insertStmt.executeUpdate();
                
                try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        session.put("userId", generatedKeys.getInt(1));
                    }
                }
            }
            
            session.put("currentUser", username.trim());
            System.out.println("User registered successfully: " + username);
            return "success";
        } catch (Exception e) {
            System.out.println("Registration error: " + e.getMessage());
            e.printStackTrace();
        }
        return "error";
    }



    public String logout() {
        if (session != null) {
            session.clear();
        }
        return "success";
    }




    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void setSession(Map map) {
        session = map;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}