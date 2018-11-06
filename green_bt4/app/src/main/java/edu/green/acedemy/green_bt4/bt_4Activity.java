package edu.green.acedemy.green_bt4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class bt_4Activity extends AppCompatActivity {
private EditText etNhap;
private RadioButton rb1,rb2,rb3;
private Button btNhaplai,btGiai;
private TextView tvresult;
private RadioGroup rg;
private double day1(int n){
    double Sn=0;
    for (int i=1;i<=n;i++){
        Sn=Sn+i;
    }
    return Sn;
}
private double day2(int n){
    double Sn=0;
    for (int i=1;i<=n;i++){
        Sn=Sn+(i/(i+1));
    }return Sn;
}
private double day3(int n){
    double Sn=0;
    for (int i=1;i<=n+1;i++){
        Sn=Sn+((Math.pow((-1),(i+1)))*i );
    }return Sn;
}
private boolean dulieudung(){
    if(etNhap.getText().toString().equalsIgnoreCase("")){
        tvresult.setText("Ban chưa nhập n");
        etNhap.requestFocus();
        return false;
    }
    if(!(rb1.isChecked()||rb2.isChecked()||rb3.isChecked())){
        tvresult.setText("Ban chưa chọn phương thức ");
        rb1.requestFocus();
        return false;
    }

  return true;
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt_4);
        etNhap=(EditText)findViewById(R.id.idNhap);
        rb2=(RadioButton)findViewById(R.id.id2);
        rb1=(RadioButton)findViewById(R.id.id1);
        rb3=(RadioButton)findViewById(R.id.id3);
        btNhaplai=(Button)findViewById(R.id.idNhaplai);
        btGiai=(Button)findViewById(R.id.idGiai);
        tvresult=(TextView)findViewById(R.id.idResult);
        rg=(RadioGroup)findViewById(R.id.idrg) ;
        View.OnClickListener listner=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int a=Integer.parseInt(etNhap.getText().toString());
                etNhap.setText("");
                rg.clearCheck();
                tvresult.setText("");

            }
        };btNhaplai.setOnClickListener(listner);
        btGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dulieudung()){
                 //   Toast.makeText(bt_4Activity.this,"fs",Toast.LENGTH_LONG).show();
                   try {


                       int a= Integer.parseInt(etNhap.getText().toString());
                        if(rb1.isChecked()){
                            tvresult.setText(String.valueOf(day1(a)));
                        }
                      else    if(rb2.isChecked()){
                            tvresult.setText(String.valueOf(day2(a)));
                        }
                        else  {
                            tvresult.setText(String.valueOf(day3(a)));
                        }

                }catch (Exception e ){

                    }}
            }
        });

    }
}
