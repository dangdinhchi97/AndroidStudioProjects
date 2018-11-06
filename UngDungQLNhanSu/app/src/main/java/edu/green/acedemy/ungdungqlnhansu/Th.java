package edu.green.acedemy.ungdungqlnhansu;

public class Th {
    private String hoTen;
    private int phuCap;
    private double heSL;

   public Th (){
        this.hoTen="";
        this.phuCap=0;
        this.heSL=0.0;
    }

    public Th(String hoTen, int phuCap, double heSL) {
        this.hoTen = hoTen;
        this.phuCap = phuCap;
        this.heSL = heSL;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(int phuCap) {
        this.phuCap = phuCap;
    }

    public double getHeSL() {
        return heSL;
    }

    public void setHeSL(double heSL) {
        this.heSL = heSL;
    }
}
