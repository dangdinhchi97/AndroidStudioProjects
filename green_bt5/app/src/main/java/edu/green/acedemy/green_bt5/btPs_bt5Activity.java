package edu.green.acedemy.green_bt5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class btPs_bt5Activity extends AppCompatActivity {
private EditText etTu1,etMau1,etTu2,etMau2;
private Button btCong,btTru,btNhan,btChia;
private TextView tvResul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt_ps_bt5);
        etTu1=(EditText)findViewById(R.id.idtu1);
        etTu2=(EditText)findViewById(R.id.idtu2);
        etMau1=(EditText)findViewById(R.id.idmau1);
        etMau2=(EditText)findViewById(R.id.idmau2);
        btCong=(Button)findViewById(R.id.idcong);
        tvResul=(TextView)findViewById(R.id.idresult);


        btCong.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {


try{

                int a1=Integer.parseInt(etTu1.getText().toString());
                int a2=Integer.parseInt(etMau1.getText().toString());
                int b1=Integer.parseInt(etTu2.getText().toString());
                int b2=Integer.parseInt(etMau2.getText().toString());

                PhanSo ps1=new PhanSo(a1,a2);
                PhanSo ps2=new PhanSo(b1,b2);
                PhanSo pss =new PhanSo();

              pss.cong(ps1,ps2);
    pss.toiGian(pss.tuSo,pss.mauSo);
               int  a=pss.tuSo;
              int b=pss.mauSo;

                tvResul.setText(a+"/"+b);}


                catch (Exception e){
    e.getMessage();

        Toast.makeText(btPs_bt5Activity.this,"nhap sai yeu cau nhap lai",Toast.LENGTH_LONG).show();
                    tvResul.setText("...");
}
}



        });


    }
}
