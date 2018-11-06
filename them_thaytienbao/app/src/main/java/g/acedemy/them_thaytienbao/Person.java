package g.acedemy.them_thaytienbao;

public class Person {
    private boolean isMale;
    private int ma;
    private String ten;

    public Person(boolean isMale, int ma, String ten) {
        this.isMale = isMale;
        this.ma = ma;
        this.ten = ten;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
