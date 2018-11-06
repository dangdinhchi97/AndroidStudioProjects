package edu.green.acedemy.btgreen1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bt1Activity extends AppCompatActivity {
EditText mEditText1,mEditText2;
Button mButtonCong,mButtonTru,mButtonNhan,mButtonChia;
TextView mTextView;
private double a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt1);

        mEditText1=(EditText)findViewById(R.id.et1);
        mEditText2=(EditText)findViewById(R.id.et2);
        mButtonCong=(Button)findViewById(R.id.cong);
        mButtonTru=(Button)findViewById(R.id.tru);
        mButtonNhan=(Button)findViewById(R.id.nhan);
        mButtonChia=(Button)findViewById(R.id.chia);
        mTextView=(TextView) findViewById(R.id.tvreslt);
        mButtonCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // if (!mEditText1.getText().toString().equalsIgnoreCase("")&&(!mEditText2.getText().toString().equalsIgnoreCase(""))){

                try {


                a=Double.parseDouble((mEditText1.getText().toString()));
                b=Double.parseDouble(mEditText2.getText().toString());
                  double  result=a+b;
                mTextView.setText(  String.valueOf(result));
              //Toast.makeText(bt1Activity.this,"Ke qua la "+result , Toast.LENGTH_SHORT).show();
            //}
            //else Toast.makeText(bt1Activity.this,"Du lieu nhap vao khong hop le",Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    e.getMessage();
                }
            }
        });
        mButtonTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if (!mEditText1.getText().toString().equalsIgnoreCase("")&&(!mEditText2.getText().toString().equalsIgnoreCase(""))){

                try {


                    a=Double.parseDouble((mEditText1.getText().toString()));
                    b=Double.parseDouble(mEditText2.getText().toString());
                    double  result=a-b;
                    mTextView.setText(  String.valueOf(result));
                    //Toast.makeText(bt1Activity.this,"Ke qua la "+result , Toast.LENGTH_SHORT).show();
                    //}
                    //else Toast.makeText(bt1Activity.this,"Du lieu nhap vao khong hop le",Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    e.getMessage();
                }
            }
        });
        mButtonNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if (!mEditText1.getText().toString().equalsIgnoreCase("")&&(!mEditText2.getText().toString().equalsIgnoreCase(""))){

                try {


                    a=Double.parseDouble((mEditText1.getText().toString()));
                    b=Double.parseDouble(mEditText2.getText().toString());
                    double  result=a*b;
                    mTextView.setText(  String.valueOf(result));
                    //Toast.makeText(bt1Activity.this,"Ke qua la "+result , Toast.LENGTH_SHORT).show();
                    //}
                    //else Toast.makeText(bt1Activity.this,"Du lieu nhap vao khong hop le",Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    e.getMessage();
                }
            }
        });
        mButtonChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if (!mEditText1.getText().toString().equalsIgnoreCase("")&&(!mEditText2.getText().toString().equalsIgnoreCase(""))){

                try {


                    a=Double.parseDouble((mEditText1.getText().toString()));
                    b=Double.parseDouble(mEditText2.getText().toString());
                    double  result=a/b;
                    mTextView.setText(  String.valueOf(result));
                    //Toast.makeText(bt1Activity.this,"Ke qua la "+result , Toast.LENGTH_SHORT).show();
                    //}
                    //else Toast.makeText(bt1Activity.this,"Du lieu nhap vao khong hop le",Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    e.getMessage();
                }
            }
        });

    }
}
