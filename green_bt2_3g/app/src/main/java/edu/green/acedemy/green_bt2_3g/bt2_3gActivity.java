package edu.green.acedemy.green_bt2_3g;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bt2_3gActivity extends AppCompatActivity {
private EditText etLl;
private Button btTinhc;
private TextView tvResult;

    private double TinhTienCuoc (float a){

         a=Float.parseFloat(etLl.getText().toString());

        if(a<100||a==100)return 10000;
        if(a<250||a==250&&a>101)return 25000;
        else return 1200;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt2_3g);
        etLl=(EditText)findViewById(R.id.idLul);
        btTinhc=(Button)findViewById(R.id.idTih);
        tvResult=(TextView)findViewById(R.id.idresult);

        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            try {



                    Float a=Float.parseFloat(etLl.getText().toString());
                if(a>0){
                    double result=TinhTienCuoc(a);
                    tvResult.setText(String.valueOf(result));
                }else tvResult.setText("Phai lon hon khong");
            }catch (Exception e ){
                tvResult.setText("Nhap lai sai dinh dang roi");
            }
            }
        };btTinhc.setOnClickListener(listener);

    }
}
