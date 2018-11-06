package g.acedemy.baitap6;

public class Taikhoan  {
    private String usernam;
    private String password;

    public Taikhoan(String usernam, String password) {
        this.usernam = usernam;
        this.password = password;
    }

    public String getUsernam() {
        return usernam;
    }

    public void setUsernam(String usernam) {
        this.usernam = usernam;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
