package Services;
import Data.DbConfig;
import Data.Data;
import Interface.UserInterface;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserInterface<User, Integer> {
    private Connection connection;
    private PreparedStatement preQuery;
    private boolean isSuccesfully = false;
    private final String insert = "INSERT INTO users ( username, password, email, theme, background) VALUES (?,?,?,?,? )";
    private final String selectById = "SELECT * FROM users WHERE userid = ?;";
    private final String update = "UPDATE users SET username = ? , password = ?, email = ?, theme = ?, background = ? WHERE (userid = ?);";
    private final String findAll = "SELECT * FROM users;";
    private final String delete = "DELETE FROM users WHERE (userid = ?);";

    public UserService() {
        DbConfig dbConfig = new DbConfig();
        Data data = new Data(dbConfig.getUser(), dbConfig.getPassword(), dbConfig.getDbname(), dbConfig.getHost(), dbConfig.getPort());
        data.DBconnect();
        connection = data.getConnection();
    }
    
    @Override
    public boolean createUser(User user){
        try {
            preQuery = connection.prepareStatement(insert);
            preQuery.setString(1, user.getUsername());
            preQuery.setString(2, user.getPassword());
            preQuery.setString(3, user.getEmail());
            preQuery.setString(4, user.getTheme());
            preQuery.setInt(5, user.getBackground());

            System.out.println(preQuery);

            if (preQuery.executeUpdate() > 0) {
                isSuccesfully = true;
            }
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex);
        }
        return isSuccesfully;
    }

    @Override
    public User findUser(Integer id) {
        User user = new User();
        try {
            preQuery = connection.prepareStatement(selectById);
            preQuery.setInt(1, id);
            ResultSet data = preQuery.executeQuery();
            if (data.next()) {
                user.setId(data.getInt("userid"));
                user.setUsername(data.getString("username"));
                user.setPassword(data.getString("password"));
                user.setEmail(data.getString("email"));
                user.setTheme(data.getString("theme"));
                user.setBackground(data.getInt("background"));
            }

        } catch (SQLException ex) {
            System.out.println("Exception: " + ex);
        }
        return user;
    }

    @Override
    public User updateUser(User newUser, Integer id) {
        User user = new User();
        try {
            preQuery = connection.prepareStatement(update);
            preQuery.setString(1, newUser.getUsername());
            preQuery.setString(2, newUser.getPassword());
            preQuery.setString(3, newUser.getEmail());
            preQuery.setString(4, newUser.getTheme());
            preQuery.setInt(5, newUser.getBackground());
            preQuery.setInt(6, id);

            ResultSet data = preQuery.executeQuery();

            preQuery.setString(3, newUser.getEmail());
            if (data.next()) {
                user.setId(data.getInt("userid"));
                user.setUsername(data.getString("username"));
                user.setPassword(data.getString("password"));
                user.setEmail(data.getString("email"));
                user.setTheme(data.getString("theme"));
                user.setBackground(data.getInt("background"));
            }

        } catch (SQLException ex) {
            System.out.println("Exception: " + ex);
        }
        return user;
    }

    @Override
    public boolean deleteUser(Integer id) {
        try {
            preQuery = connection.prepareStatement(delete);
            preQuery.setInt(1, id);

            if (preQuery.executeUpdate() > 0) {
                isSuccesfully = true;
            }

        } catch (SQLException ex) {
            System.out.println("Exception: " + ex);
        }
        return isSuccesfully;
    }   
    
    @Override
    public ArrayList<User> findAll() {
        ArrayList<User> users = new ArrayList<User>();
        try {            
            preQuery = connection.prepareStatement(findAll);
            ResultSet data = preQuery.executeQuery();
            while (data.next()) {
                users.add(new User(data.getInt("userid"), data.getString("username"), data.getString("password"), data.getString("email"), data.getString("theme"),data.getInt("background")));
            }
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex);
        }
        return users;
    }
}