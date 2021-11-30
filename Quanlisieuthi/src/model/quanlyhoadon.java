/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class quanlyhoadon {
    private int mahd;
    private String Date_Buy;
    private int thanhTien;
    private int manv;
    public quanlyhoadon() {
    }

    public quanlyhoadon(String Date_Buy, int thanhTien) {
        this.Date_Buy = Date_Buy;
        this.thanhTien = thanhTien;
    }

    public quanlyhoadon(int mahd, String Date_Buy, int thanhTien) {
        this.mahd = mahd;
        this.Date_Buy = Date_Buy;
        this.thanhTien = thanhTien;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public String getDate_Buy() {
        return Date_Buy;
    }

    public void setDate_Buy(String Date_Buy) {
        this.Date_Buy = Date_Buy;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    

    
    
}
