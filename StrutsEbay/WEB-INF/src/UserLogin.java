public class UserLogin {
         
    //declare variables of the same name as the webpage parameters taken in
    private String userName;
    private String password;
    private String whoIsThere;

    //empty constructor
    public UserLogin() {
  
    } 
    
    
    public String login() {
        if (userName != null && userName.equals("Stefan")) {
            whoIsThere = "Me";
            return "SUCCESS";
        } else {
            whoIsThere = "Guest";
            return "FAILURE";
        }
    } 
    

    //getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getWhoIsThere() {
        return whoIsThere;
    }

    public void setWhoIsThere(String whoIsThere) {
        this.whoIsThere = whoIsThere;
    }
}
