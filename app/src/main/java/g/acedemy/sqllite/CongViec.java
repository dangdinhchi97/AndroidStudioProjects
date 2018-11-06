package g.acedemy.sqllite;

public class CongViec {
    private int ID;
    private String tencV;

    public CongViec(int ID, String tencV) {
        this.ID = ID;
        this.tencV = tencV;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTencV() {
        return tencV;
    }

    public void setTencV(String tencV) {
        this.tencV = tencV;
    }
}
