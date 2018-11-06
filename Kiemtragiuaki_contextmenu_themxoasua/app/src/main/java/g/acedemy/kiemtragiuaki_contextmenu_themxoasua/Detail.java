package g.acedemy.kiemtragiuaki_contextmenu_themxoasua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Detail extends AppCompatActivity {
    public static final String GIOITINH_ADD="GIOITINH_ADD";
    public static final String TEN_ADD="TEN_ADD";
    public static final String TUOI_ADD="TUOI_ADD";
    public static final int  RESULt_DETAIL=122211222;
    RadioButton rnam,rnu;
    EditText etname;
    EditText ettuoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        rnam= (RadioButton) findViewById(R.id.rnam);
        rnu= (RadioButton) findViewById(R.id.rnu);
        etname= (EditText) findViewById(R.id.etten);
        ettuoi= (EditText) findViewById(R.id.ettuoi);
        Button btnreturn= (Button) findViewById(R.id.btnreturn);
        getdata();
        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getdata() {
        Intent intent=getIntent();
        boolean gioitinh=intent.getBooleanExtra(MainActivity.HINH,true);
        if(gioitinh==true){
            rnam.setChecked(true);
        }else {
            rnu.setChecked(true);
        }
        String ten=intent.getStringExtra(MainActivity.TEN);
        etname.setText(ten);
        int tuoi=intent.getIntExtra(MainActivity.TUOI,3);
        ettuoi.setText(tuoi);
    }
}
