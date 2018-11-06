package g.acedemy.themxoasualistview;

public class SanPHam {

    private int color;

    private String tenSp;
    private String sxSp;

    public SanPHam( int color, String tenSp, String sxSp) {

        this.color = color;
        this.tenSp = tenSp;
        this.sxSp = sxSp;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }



    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getSxSp() {
        return sxSp;
    }

    public void setSxSp(String sxSp) {
        this.sxSp = sxSp;
    }
}
