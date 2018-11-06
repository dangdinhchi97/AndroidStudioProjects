package g.acedemy.fragment_ngang_doc;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String hoTen;
    private int nam;
    private String diachi;
    private String email;

    public SinhVien(String hoTen, int nam, String diachi, String email) {
        this.hoTen = hoTen;
        this.nam = nam;
        this.diachi = diachi;
        this.email = email;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
