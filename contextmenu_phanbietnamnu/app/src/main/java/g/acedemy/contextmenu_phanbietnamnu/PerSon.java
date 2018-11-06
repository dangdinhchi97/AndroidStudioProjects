package g.acedemy.contextmenu_phanbietnamnu;

public class PerSon {
    private boolean isMale;
    private String ten;
    private long sdt;

    public PerSon(boolean isMale, String ten, long sdt) {
        this.isMale = isMale;
        this.ten = ten;
        this.sdt = sdt;
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

    public long getSdt() {
        return sdt;
    }

    public void setSdt(long sdt) {
        this.sdt = sdt;
    }
}
