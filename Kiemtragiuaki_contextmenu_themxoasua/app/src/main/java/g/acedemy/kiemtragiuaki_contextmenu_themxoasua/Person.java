package g.acedemy.kiemtragiuaki_contextmenu_themxoasua;

public class Person {
    private boolean ismale;
    private String ten;
    private int tuoi;

    public Person(boolean ismale, String ten, int tuoi) {
        this.ismale = ismale;
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public boolean isIsmale() {
        return ismale;
    }

    public void setIsmale(boolean ismale) {
        this.ismale = ismale;
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
}
