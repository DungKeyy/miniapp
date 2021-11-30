/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import QLST.nhaphangform;
import database.databaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trant
 */
public class nhanvienDAO {
   static  String k;
   public int add(nhanvien nv){
       Connection conn=null;
       PreparedStatement sttm =null;
       try {
           String sql="insert nhanvien(ten_nv,ngay_sinh,gioi_tinh,dia_chi,sdt_nv, username, password,phan_quyen)"+" values(?,?,?,?,?,?,?,?)";
           conn= databaseUtils.getDBConnect();
           sttm= conn.prepareStatement(sql);
           sttm.setString(1, nv.getTen_nv());
           sttm.setString(2, nv.getNgay_sinh());
           sttm.setString(3, nv.getGioi_tinh());
           sttm.setString(4, nv.getDia_chi());
            sttm.setInt(5, nv.getSđt_nv());
           sttm.setString(6, nv.getUsername());
           sttm.setString(7, nv.getPassword());
           sttm.setInt(8, nv.getPhan_quyen());
           
           if(sttm.executeUpdate()>0){
               System.out.println("add thanh cong");
               return 1;
           }
           else{
               System.out.println("sao zi?");
           }
       } catch (Exception e) {
           System.out.println(e.toString());
       }
       finally{
           try {
               conn.close();
               sttm.close();
           } catch (Exception e) {
           }
       }
       return -1; //neu them k thanh cong
   }
   
   public static int tim_manv(int manv){
       return manv;
   }
    public int edit(nhanvien nv){
       Connection conn=null;
       PreparedStatement sttm =null;
       try {
           String sql="update nhanvien set ten_nv=?,ngay_sinh=?,gioi_tinh=?,dia_chi=?, sdt_nv=?, username=?, password=?,phan_quyen=? where ma_nv=?";
           conn= databaseUtils.getDBConnect();
           sttm= conn.prepareStatement(sql);
            
           sttm.setString(1, nv.getTen_nv());
           sttm.setString(2, nv.getNgay_sinh());
           sttm.setString(3, nv.getGioi_tinh());
           sttm.setString(4, nv.getDia_chi());
            
            sttm.setInt(5, nv.getSđt_nv());
           sttm.setString(6, nv.getUsername());
           sttm.setString(7, nv.getPassword());
           sttm.setInt(8, nv.getPhan_quyen());
          sttm.setInt(9, nv.getMa_nv());
           if(sttm.executeUpdate()>0){
               System.out.println("edit thanh cong");
               return 1;
           }
           else{
               System.out.println("sao zi?");
           }
       } catch (Exception e) {
           System.out.println(e.toString());
       }
       finally{
           try {
               conn.close();
               sttm.close();
           } catch (Exception e) {
           }
       }
       return -1; //neu them k thanh cong
   }
   public int del(int ma){
       Connection conn=null;
       PreparedStatement sttm =null;
       try {
           String sql="DELETE FROM nhanvien WHERE nhanvien.ma_nv = ?";
           conn= databaseUtils.getDBConnect();
           sttm= conn.prepareStatement(sql);
          sttm.setInt(1, ma);
           if(sttm.executeUpdate()>0){
               System.out.println("xoa thanh cong");
               return 1;
           }
           else{
               System.out.println("sao zi?");
           }
       } catch (Exception e) {
           System.out.println(e.toString());
       }
       finally{
           try {
               conn.close();
               sttm.close();
           } catch (Exception e) {
           }
       }
       return -1; //neu them k thanh cong   List<nhanvien>
   }
   public List<nhanvien> getAllNhanvien(){
        List<nhanvien> ls = new ArrayList<>();
       Connection conn= null;
       Statement sttm= null;
       ResultSet rs=null;
       //ma_nv, ten_nv, ngay_sinh, gioi_tinh, dia_chi, sdt_nv, username,password, phan_quyen from nhanvien order by ma_nv desc
       try {
           String sql = "select ma_nv, ten_nv, ngay_sinh, gioi_tinh, dia_chi, sdt_nv, username,password, phan_quyen from nhanvien  ";
           conn= databaseUtils.getDBConnect();
           sttm= conn.createStatement();
           rs= sttm.executeQuery(sql);
           while(rs.next()){
               nhanvien nv= new nhanvien();
                k= rs.getString(2);
               nv.setMa_nv(rs.getInt(1));
               nv.setTen_nv(rs.getString(2));
               nv.setNgay_sinh(rs.getString(3));
                nv.setGioi_tinh(rs.getString(4));
                 
               nv.setDia_chi(rs.getString(5));
              nv.setSđt_nv(rs.getInt(6));
             
              nv.setUsername(rs.getString(7));
              nv.setPassword(rs.getString(8));
              nv.setPhan_quyen(rs.getInt(9));
              ls.add(nv);
           }
       } catch (Exception e) {
           System.out.println(e.toString());
       }
       finally{
           try {
               rs.close();
               sttm.close();
               conn.close();
           } catch (Exception e) {
           }
       }
    return ls;
      //return k;
   }
   public nhanvien getNhanvienById(int ma_nv){
       Connection conn=null;
       PreparedStatement sttm=null;
       ResultSet rs= null;
       nhanvien nv=new nhanvien();
       try {
           String sql="select ma_nv, ten_nv, ngay_sinh, gioi_tinh, dia_chi, sdt_nv, username,password, phan_quyen from nhanvien where ma_nv=?";
            conn= databaseUtils.getDBConnect();
            sttm= conn.prepareStatement(sql);
            sttm.setInt(1, ma_nv);
           rs= sttm.executeQuery();
            while(rs.next()){
               
               nv.setMa_nv(rs.getInt(1));
               nv.setTen_nv(rs.getString(2));
               nv.setNgay_sinh(rs.getString(3));
                nv.setGioi_tinh(rs.getString(4));
                 
               nv.setDia_chi(rs.getString(5));
              nv.setSđt_nv(rs.getInt(6));
             
              nv.setUsername(rs.getString(7));
              nv.setPassword(rs.getString(8));
              nv.setPhan_quyen(rs.getInt(9));
               return nv;
           }
       } catch (Exception e) {
            System.out.println(e.toString());
       }
        finally{
           try {
               rs.close();
               sttm.close();
               conn.close();
           } catch (Exception e) {
           }
       }
       return null;
   }
    public static void main(String[] args) {
        nhanvienDAO dao= new nhanvienDAO();
        nhanvien nv= new nhanvien(2,"phuongchot","10/07/2000", "nu", "thanh hoa",  012345567, "phuongchot", "123456", 1);
        //dao.add(nv);
        //dao.edit(nv);
         
         
          
    }
}           
