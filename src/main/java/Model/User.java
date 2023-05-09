package Model;

public class User {
    private Integer userid;
    private String username;
    private String password;
    private String theme;

    public User(){}
    public User(Integer id, String username, String password,String email, String theme, int background) {
        this.userid = id;
        this.username = username;
        this.password = password;
        this.theme = theme;
        this.background = background;
        this.email = email;
    }

    public void setId(Integer id) {
        this.userid = id;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    private int background;

    public int getBackground() {
        return background;
    }
    private String email;


    public long getUserid() {
        return userid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


}
