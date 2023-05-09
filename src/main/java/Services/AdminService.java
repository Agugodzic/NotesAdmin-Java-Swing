/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Data.Data;
import Data.DbConfig;
import Interface.AdminInterface;
import Model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author agugo
 */
public class AdminService implements AdminInterface<Admin,Integer>{
        private Connection connection;
    private PreparedStatement preQuery;
    private boolean isSuccesfully = false;
    private final String findCredentials = "SELECT * FROM admins WHERE adminname = ? AND adminpassword = ?";

    public AdminService() {
        DbConfig dbConfig = new DbConfig();
        Data data = new Data(dbConfig.getUser(), dbConfig.getPassword(), dbConfig.getDbname(), dbConfig.getHost(), dbConfig.getPort());
        data.DBconnect();
        connection = data.getConnection();
    }
    
    @Override
    public Admin getAdmin(String adminName, String adminPassword) {
        Admin admin = new Admin();
        try {
            preQuery = connection.prepareStatement(findCredentials);
            preQuery.setString(1,adminName);
            preQuery.setString(2,adminPassword);
            ResultSet data = preQuery.executeQuery();
            if (data.next()) {
                admin.setId(data.getInt("id"));
                admin.setAdminname(data.getString("adminname"));
                admin.setAdminpassword(data.getString("adminpassword"));
            }

        } catch (SQLException ex) {
            System.out.println("Exception: " + ex);
        }
        return admin;
    }

}
