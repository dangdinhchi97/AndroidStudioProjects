package g.acedemy.ontapthigk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ViewDetailActivity extends AppCompatActivity {
private RadioButton nam,nu;
private EditText ten;
private EditText sdt;
private Button btnreturn;
private boolean gioitinh;
 private String name;
private  long phone;
//static final Boolean Nam=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail);
        nam= (RadioButton) findViewById(R.id.nam);
        nu= (RadioButton) findViewById(R.id.nu);
        ten= (EditText) findViewById(R.id.ten);
        sdt= (EditText) findViewById(R.id.sdt);
        btnreturn= (Button) findViewById(R.id.btnreturn);

       getEXTRA();

       btnreturn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                finish();
           }
       });

    }
    public void getEXTRA(){
        Intent intent=getIntent();
        gioitinh=intent.getBooleanExtra(DanhsachPSActivity.NAM,true);
        if(gioitinh==true){
            nam.setChecked(true);
        }else nu.setChecked(true);
        name=intent.getStringExtra(DanhsachPSActivity.TEN);
        ten.setText(name);
        phone=intent.getLongExtra(DanhsachPSActivity.SDT,0);
        sdt.setText(String.valueOf(phone));
    }
}
