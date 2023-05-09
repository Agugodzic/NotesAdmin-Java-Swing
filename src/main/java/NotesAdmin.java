import Model.Admin;
import Model.User;
import Services.AdminService;
import Services.UserService;
import View.Login;

import java.util.ArrayList;

public class NotesAdmin {
    public static void main(String[] args){
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        
        UserService userService = new UserService();
        AdminService adminService = new AdminService();
        User user = userService.findUser(1);
        System.out.println(user.getUsername());
        ArrayList<User> users = (ArrayList<User>) userService.findAll();
        for(User u: users){
            System.out.println("");
            System.out.println("-----------------------------");
            System.out.println("");
            System.out.println("Usuario: " + u.getUsername());
            System.out.println("email: " + u.getEmail());
            System.out.println("");
           
        }
        
        Admin admin = adminService.getAdmin("admin01","asd123");
        System.out.println("Admin: " + admin.getAdminname());
        


    }
}
