package com.example.quynhlinh.sodienthoai.model;

/**
 * Created by QuynhLinh on 3/12/2018.
 */

public class sodienthoai {
    private String ten;
    private String sdt;
    private int number;
    public sodienthoai(String ten, String sdt) {
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
