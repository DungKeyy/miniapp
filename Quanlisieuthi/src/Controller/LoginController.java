/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

 
import Views.LoginForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author trant
 */
public class LoginController {
    public static int ma_nv;
     public static long millis1;
     private static final String DATABASE_URL = "jdbc:mysql://localhost/minimarket?serverTimezone=UTC";
    private static final String DATABASE_USER_NAME = "root";
    private static final String DATABASE_PASSWORD = "";
  
    public LoginController() {
    }
   
    public static Connection DBConnect(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD);
             
            return con;
        } catch (Exception e) {
            System.out.println("fail roi");
        }
        return null;
    }
      
    public int checkLogin(String username, String password ) throws ClassNotFoundException, SQLException{
      
           Connection conn= DBConnect();
          Statement stm= conn.createStatement();
            String sql= "Select * from nhanvien where username='"+username+"' and password='"+password+"'";
                    ResultSet rs = stm.executeQuery(sql);
 
                  if (rs.next() ) {
                      millis1 = System.currentTimeMillis();
                       ma_nv= rs.getInt("ma_nv");
                       int quyen= rs.getInt("phan_quyen");
                        return quyen;
                      
                        }
                  else{
                      return -1;
                  }    
                 
                    
                }    
    public int returnma(){
        return ma_nv;
    }
    
    public static void main(String[] args) {
        
        
    }

    
}
