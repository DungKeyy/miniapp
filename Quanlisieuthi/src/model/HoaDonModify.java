/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HoaDonModify {
    private Connection conn;
    String ma="";
    public HoaDonModify(){
        try {
            String url="jdbc:mysql://localhost/minimarket";
            String user="root";
            String password="";
            conn=DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
        }
    }
    public ArrayList<quanlyhoadon> getListHD(){
    ArrayList<quanlyhoadon> list=new ArrayList<>();
    String sql="select ma_hd,ngay_tao,thanh_toan from hoa_don";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                quanlyhoadon s=new quanlyhoadon();
                s.setMahd(rs.getInt("ma_hd"));
                s.setDate_Buy(rs.getString("ngay_tao"));
                s.setThanhTien(rs.getInt("thanh_toan"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public int getmahd(){
         String sql="select ma_hd from hoa_don where ngay_tao='"+ma+"'";
         try {
             PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt("ma_hd");
            }
        } catch (Exception e) {
        }
          
         return 0;
    }
    public int AddHD(quanlyhoadon hd){
         
        try {
            String sql="insert hoa_don(ngay_tao,thanh_toan) values(?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, hd.getDate_Buy());
            ps.setInt(2, hd.getThanhTien());
            ma= hd.getDate_Buy();
             if(ps.executeUpdate()>0){
               System.out.println(ma);
                 
               return 1;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       return -1; 
       
    }
     public void DeleteHD(int id ){
        String sql="delete from hoa_don where ma_hd=?";
        try {
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new HoaDonModify();
    }
    
}