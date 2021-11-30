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
public class Chitet_hdModify {
    private Connection conn;
    public Chitet_hdModify(){
        try {
            String url="jdbc:mysql://localhost/minimarket";
            String user="root";
            String password="";
            conn=DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Dungtest(int k){
        System.out.println("====================="+k+"========================");
    }
    public ArrayList<chi_tiet_hd> getListSP(){
        ArrayList<chi_tiet_hd> list=new ArrayList<>();
        String sql="select ma_chi_tiet_hd,ma_hang,so_luong,tong_tien from chi_tiet_hd";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                chi_tiet_hd s=new chi_tiet_hd();
                s.setMa_chi_tiet_hd(rs.getInt("ma_chi_tiet_hd"));
                s.setMasp(rs.getInt("ma_hang"));
                s.setSo_luong(rs.getInt("so_luong"));
                s.setGia(rs.getInt("tong_tien"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public void addSP(chi_tiet_hd s, int k ){
        String sql="insert chi_tiet_hd(ma_hd,ma_hang,so_luong,tong_tien) values(?,?,?,?)";                
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, k);
            ps.setInt(2, s.getMasp());
            ps.setInt(3, s.getSo_luong());
            ps.setInt(4, s.getGia());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   /* public void DeleteSP(int id ){
        String sql="delete from chi_tiet_hd where ma_chi_tiet_hd=?";
        try {
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    
    
    public static void main(String[] args) {
        new Chitet_hdModify();
        
    }
}
