package g.acedemy.kiemtragiuaki_contextmenu_themxoasua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class UpdateActivity extends AppCompatActivity {
    public static final String GIOITINH_ADD="GIOITINH_ADD";
    public static final String TEN_ADD="TEN_ADD";
    public static final String TUOI_ADD="TUOI_ADD";
    public static final int  RESULt_UPDATE=1211222;
    private RadioButton rnam,rnu;
    private EditText etname;
    private EditText ettuoi;
    private Button btnupdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        rnam= (RadioButton) findViewById(R.id.rnam);
        rnu= (RadioButton) findViewById(R.id.rnu);
        etname= (EditText) findViewById(R.id.etten);
        ettuoi= (EditText) findViewById(R.id.ettuoi);
         btnupdate= (Button) findViewById(R.id.btnupdate);
        getdata();
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                boolean gioitinh;
                if(rnam.isChecked()){
                    gioitinh=true;
                    intent.putExtra(GIOITINH_ADD,gioitinh);
                }else if(rnu.isChecked()) {
                    gioitinh=false;
                    intent.putExtra(GIOITINH_ADD,gioitinh);
                }
                String ten=etname.getText().toString();
                intent.putExtra(TEN_ADD,ten);
                int tuoi= Integer.parseInt(ettuoi.getText().toString());
                intent.putExtra(TUOI_ADD,tuoi);
                setResult(RESULt_UPDATE,intent);
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
