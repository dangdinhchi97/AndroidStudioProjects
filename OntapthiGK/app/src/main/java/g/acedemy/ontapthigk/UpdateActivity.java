package g.acedemy.ontapthigk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class UpdateActivity extends AppCompatActivity {
private boolean gioitinh;
private String ten;
private long sdt;
private RadioButton rnam,rnu;
private EditText etten,etsdt;
private Button btnupdate;
public static final String GIOITINH="GIOITINH";
    public static final String TEN="TEN";
    public static final String SDT="SDT";
    public static final int  RESULT_UPDATE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        rnam= (RadioButton) findViewById(R.id.nam_update);
        rnu= (RadioButton) findViewById(R.id.nu_update);
        etten= (EditText) findViewById(R.id.ettenupdate);
        etsdt= (EditText) findViewById(R.id.etsdtupdate);
        btnupdate= (Button) findViewById(R.id.btnupdate);
        getData();
        eventupdate();
    }

    private void getData() {
        Intent intent=getIntent();
        gioitinh=intent.getBooleanExtra(DanhsachPSActivity.NAM,true);
        if(gioitinh==true){
            rnam.setChecked(true);
        }else rnu.setChecked(true);
        ten=intent.getStringExtra(DanhsachPSActivity.TEN);
        etten.setText(ten);
        sdt=intent.getIntExtra(DanhsachPSActivity.SDT,9);
        etsdt.setText(String.valueOf(sdt));
    }
    public void eventupdate(){
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                if(rnam.isChecked()){
                    gioitinh=true;
                    intent.putExtra(GIOITINH,gioitinh);
                }else {
                    gioitinh=false;
                    intent.putExtra(GIOITINH,gioitinh);
                }
                ten=etten.getText().toString();
                intent.putExtra(TEN,ten);
                sdt=Long.parseLong(etsdt.getText().toString());
                intent.putExtra(SDT,sdt);
                setResult(RESULT_UPDATE,intent);
                finish();
            }
        });
    }
}
