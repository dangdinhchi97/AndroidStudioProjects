package edu.green.acedemy.ungdungqlnhansu;

public class GiangVien extends  Th{
    private String khoa;
    private String trinhdo;
    private int soTiet;

    public GiangVien(String khoa, String trinhdo, int soTiet) {
        this.khoa = khoa;
        this.trinhdo = trinhdo;
        this.soTiet = soTiet;
    }

    public GiangVien(String hoTen, int phuCap, double heSL, String khoa, String trinhdo, int soTiet) {
        super(hoTen, phuCap, heSL);
        this.khoa = khoa;
        this.trinhdo = trinhdo;
        this.soTiet = soTiet;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }
    //method
    public void phucap(){

    }
}
