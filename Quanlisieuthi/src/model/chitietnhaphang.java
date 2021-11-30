/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author trant
 */
public class chitietnhaphang {
    private int machitiet_nh;
    private int ma_nhap;
    private int ma_hang;
    private int gianhap;
    private int soluong;
    private int tongtien;

    public chitietnhaphang(int gianhap, int soluong, int tongtien) {
        this.gianhap = gianhap;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }

    public chitietnhaphang() {
    }

    public chitietnhaphang(int machitiet_nh, int ma_nhap, int ma_hang, int gianhap, int soluong, int tongtien) {
        this.machitiet_nh = machitiet_nh;
        this.ma_nhap = ma_nhap;
        this.ma_hang = ma_hang;
        this.gianhap = gianhap;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }

    @Override
    public String toString() {
        return "chitietnhaphang{" + "machitiet_nh=" + machitiet_nh + ", ma_nhap=" + ma_nhap + ", ma_hang=" + ma_hang + ", gianhap=" + gianhap + ", soluong=" + soluong + ", tongtien=" + tongtien + '}';
    }

    public int getMachitiet_nh() {
        return machitiet_nh;
    }

    public void setMachitiet_nh(int machitiet_nh) {
        this.machitiet_nh = machitiet_nh;
    }

    public int getMa_nhap() {
        return ma_nhap;
    }

    public void setMa_nhap(int ma_nhap) {
        this.ma_nhap = ma_nhap;
    }

    public int getMa_hang() {
        return ma_hang;
    }

    public void setMa_hang(int ma_hang) {
        this.ma_hang = ma_hang;
    }

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    
            
}
