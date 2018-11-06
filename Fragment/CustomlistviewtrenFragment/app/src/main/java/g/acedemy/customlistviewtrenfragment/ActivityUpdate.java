package g.acedemy.customlistviewtrenfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActivityUpdate extends AppCompatActivity {
    public static final int KQ_UPDATE=11;

    public static final String GIOITINH_UPDATE="GIOITINH_UPDATE";
    public static final String TEN_UPDATE="TEN_UPDATE";
    public static final String TUOI_UPDATE="TUOI_UPDATE";
    public static final String IMG__CT_UPDATE="IMG__CT_UPDATE";

RadioButton rdonam,rdonu;
EditText etten,ettuoi;
ImageView imghinh;
Button btnupdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        anhxa();
        getdat();
        eventupdate();
    }

    private void eventupdate() {
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                if (rdonam.isChecked()) {
                    intent.putExtra(GIOITINH_UPDATE, true);
                }else intent.putExtra(GIOITINH_UPDATE,false);



                int tuoi= Integer.parseInt(ettuoi.getText().toString());
                if (etten.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(ActivityUpdate.this, "Chua nhap name", Toast.LENGTH_SHORT).show();
                }
                else if (String.valueOf(tuoi).equalsIgnoreCase("")){
                    Toast.makeText(ActivityUpdate.this, "Chua nhap age", Toast.LENGTH_SHORT).show();
                }
                else {
                    intent.putExtra(TEN_UPDATE, etten.getText().toString());

                    intent.putExtra(TUOI_UPDATE, tuoi);
                    // int hinh=imghinh.getImageAlpha();
                    // intent.putExtra(IMG__CT_UPDATE,hinh);
                    setResult(KQ_UPDATE, intent);
                    finish();
                }

            }
        });

    }

    private void getdat() {
        Intent intent=getIntent();
        boolean gioitinh=intent.getBooleanExtra(GaigoiFragment.NAM,true);
        String ten=intent.getStringExtra(GaigoiFragment.TEN);
        int tuoi=intent.getIntExtra(GaigoiFragment.TUOI,21);
        int hinh=intent.getIntExtra(GaigoiFragment.IMG_COUNTRY,22);
        if (gioitinh==true){
            rdonam.setChecked(true);
        }else rdonu.setChecked(true);
        etten.setText(ten);
        ettuoi.setText(tuoi+"");
        imghinh.setImageResource(hinh);
    }

    private void anhxa() {
        rdonam= (RadioButton) findViewById(R.id.rbtnfamale_update);
        rdonu= (RadioButton) findViewById(R.id.rbtnmale_update);
        etten= (EditText) findViewById(R.id.et_ten_update);
        ettuoi= (EditText) findViewById(R.id.et_tuoi_update);
        imghinh= (ImageView) findViewById(R.id.img_country_update);
        btnupdate= (Button) findViewById(R.id.btn_update);
    }
}
