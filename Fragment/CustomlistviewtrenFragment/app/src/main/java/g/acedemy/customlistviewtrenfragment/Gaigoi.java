package g.acedemy.customlistviewtrenfragment;

public class Gaigoi {
    private boolean isMale;
    private String ten;
    private int tuoi;
    private int img_country;

    public Gaigoi(boolean isMale, String ten, int tuoi, int img_country) {
        this.isMale = isMale;
        this.ten = ten;
        this.tuoi = tuoi;
        this.img_country = img_country;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getImg_country() {
        return img_country;
    }

    public void setImg_country(int img_country) {
        this.img_country = img_country;
    }
}
