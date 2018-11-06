package edu.green.acedemy.ungdungqlnhansu;

public class HanhChinh extends Th {
    private String phongBan;
    private int songaycong;
    private String chucvu;

    public HanhChinh(String phongBan, int songaycong, String chucvu) {
        this.phongBan = phongBan;
        this.songaycong = songaycong;
        this.chucvu = chucvu;
    }

    public HanhChinh(String hoTen, int phuCap, double heSL, String phongBan, int songaycong, String chucvu) {
        super(hoTen, phuCap, heSL);
        this.phongBan = phongBan;
        this.songaycong = songaycong;
        this.chucvu = chucvu;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public int getSongaycong() {
        return songaycong;
    }

    public void setSongaycong(int songaycong) {
        this.songaycong = songaycong;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
}
