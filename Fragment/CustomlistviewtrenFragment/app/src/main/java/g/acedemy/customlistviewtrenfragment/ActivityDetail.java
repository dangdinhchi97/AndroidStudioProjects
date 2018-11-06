package g.acedemy.customlistviewtrenfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ActivityDetail extends AppCompatActivity {
RadioButton rbtnNam,rbtnNu;
TextView tv_ten,tv_tuoi;
ImageView img_hinhdi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deltail);
        rbtnNam= (RadioButton) findViewById(R.id.rbtnmale_dt);
        rbtnNu= (RadioButton) findViewById(R.id.rbtnfamale_dt);
        tv_ten= (TextView) findViewById(R.id.tv_ten_dt);
        tv_tuoi= (TextView) findViewById(R.id.tv_tuoi_dt);
        img_hinhdi= (ImageView) findViewById(R.id.img_country_dt);
        getIntent_dt();
    }
    public void getIntent_dt(){
        Intent intent=getIntent();
        boolean general=intent.getBooleanExtra(GaigoiFragment.NAM,true);
        if (general==true){
            rbtnNam.setChecked(true);
            rbtnNu.setChecked(false);
        }else {rbtnNu.setChecked(true);
        rbtnNam.setChecked(false);}
        String name=intent.getStringExtra(GaigoiFragment.TEN);
        tv_ten.setText(name);
        int tuoi=intent.getIntExtra(GaigoiFragment.TUOI,12);
        tv_tuoi.setText(tuoi+"");
        int hinh=intent.getIntExtra(GaigoiFragment.IMG_COUNTRY,13);
        img_hinhdi.setImageResource(hinh);
    }
}
