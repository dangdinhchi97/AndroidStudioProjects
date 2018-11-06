package edu.green.acedemy.green_bt3_ptb2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ptb2Activity extends AppCompatActivity {
private EditText eta,etb,etc;
private Button btNhaplai,btGiai;
private TextView tvResult;
private void ptb1(float a,float b){
    if(a==0)if(b==0) tvResult.setText("Pt vo so nghiệm");
            else tvResult.setText("Pt vo nghiệm");
     else tvResult.setText(String.valueOf(-b/a));
}
private void ptb2(float a,float b,float c){
    ;
    if(a==0) ptb1(b,c);
    else {
        double denta=(b*b-4*a*c);
        if(denta<0)tvResult.setText("Pt vo nghiem");
        if(denta==0)tvResult.setText(String .valueOf(-b/(2*a)));
        if(denta>0)

            tvResult.setText(String.valueOf(((-b-Math.sqrt(denta))/(2*a)))+"và"+String.valueOf(((-b-Math.sqrt(denta))/(2*a))) );


    }
}

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptb2);
        eta=(EditText)findViewById(R.id.ida);
        etb=(EditText)findViewById(R.id.idb);
        etc=(EditText)findViewById(R.id.idc);
        btNhaplai=(Button)findViewById(R.id.idNhalai);
        btGiai=(Button)findViewById(R.id.idGiai);
        tvResult=(TextView)findViewById(R.id.idResult) ;
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eta.setText("");
                etb.setText("");
                etc.setText("");
            }
        };btNhaplai.setOnClickListener(listener);
        btGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                float a=Float.parseFloat(eta.getText().toString());
                float b=Float.parseFloat(etb.getText().toString());
                float c=Float.parseFloat(etc.getText().toString());

                    ptb2(a,b,c);
                }catch (Exception e ){
                    tvResult.setText("Nhap sai dinh dang");
                }
            }
        });
}

}
