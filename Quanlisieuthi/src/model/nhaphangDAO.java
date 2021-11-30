/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import QLST.Login;
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
public class nhaphangDAO {
    Login lg= new Login();
    public int add(nhaphang nv){
       Connection conn=null;
       PreparedStatement sttm =null;
       try {
           String sql="insert nhap_hang(ma_nhap, ma_ncc, ma_nv, ngay_nhap, thanh_tien)"+" values(?,?,?,?,?)";
           conn= databaseUtils.getDBConnect();
           sttm= conn.prepareStatement(sql);
           sttm.setInt(1, nv.getManhap());
           sttm.setInt(2, nv.getMancc());     
           sttm.setInt(3, nv.getManv());
           sttm.setString(4, nv.getNgaynhap());
            sttm.setInt(5, nv.getThanhtien());
           
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
    
    public void getdata(){
        
    }
    public ArrayList<nhaphang> getListNH(){
         Connection conn= null;
       Statement sttm= null;
       ResultSet rs=null;
    ArrayList<nhaphang> list=new ArrayList<>();
    String sql="select ma_nhap,ma_ncc,ma_nv,ngay_nhap,thanh_tien from nhap_hang";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                nhaphang s=new nhaphang();
                s.setManhap(rs.getInt("ma_nhap"));
                s.setMancc(rs.getInt("ma_ncc"));
                s.setManv(rs.getInt("ma_nv"));
                s.setNgaynhap(rs.getString("ngay_nhap"));
                s.setThanhtien(rs.getInt("thanh_tien"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     public List<nhaphang> getttNhap(int mancc, int manhap){
         List<nhaphang> ls= new ArrayList<>();
         
           nhaphang nv= new nhaphang();
           nv.setManhap(manhap);
           nv.setMancc(mancc);
           nv.setManv(lg.returnma()); 
         return ls;
     }
}
