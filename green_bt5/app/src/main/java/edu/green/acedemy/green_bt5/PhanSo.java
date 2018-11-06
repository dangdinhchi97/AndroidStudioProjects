package edu.green.acedemy.green_bt5;

public class PhanSo {
    public int tuSo,mauSo;
   public PhanSo(){
        this.tuSo=0;
        this.mauSo=1;
    }
    public PhanSo(int tuSo,int mauSo){
        this.tuSo=tuSo;
        this.mauSo=mauSo;
    }
   public void cong(PhanSo ps1,PhanSo ps2){

       tuSo = (ps1.tuSo * ps2.mauSo) + (ps1.mauSo * ps2.tuSo);
       mauSo=ps1.mauSo*ps2.mauSo;

    }
    public void tru(PhanSo ps1,PhanSo ps2){

        tuSo = (ps1.tuSo * ps2.mauSo) - (ps1.mauSo * ps2.tuSo);
       mauSo=ps1.mauSo*ps2.mauSo;

    }
    public void nhan(PhanSo ps1,PhanSo ps2){

        tuSo = ps1.tuSo*ps2.tuSo;
        mauSo=ps1.mauSo*ps2.mauSo;

    }
    public void chia(PhanSo ps1,PhanSo ps2){


        tuSo = ps1.tuSo*ps2.mauSo;
        mauSo=ps1.mauSo*ps2.tuSo;

    }
    public void toiGian(int tu, int mau)throws Exception {
        if(mau==0)throw new Exception("ps so khong ton tai");
        else {

            for (int i=(int )(tu);i>=0;i--) {
                if(i==0)System.out.println("0");
                else
                { if(tu%i==0&&mau%i==0)
                {tuSo=tu/i;
                    mauSo=mau/i;
                    break;
                }

                }}

        }

    }

}
