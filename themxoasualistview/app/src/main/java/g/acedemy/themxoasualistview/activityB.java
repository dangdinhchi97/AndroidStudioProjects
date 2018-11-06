package g.acedemy.themxoasualistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activityB extends AppCompatActivity {
    static final String NAME_UPDATE="NAME_UPDATE";
    static final String MADEIN_UPDATE="MADEIN_UPDATE";
    static final  int  RESULT=1;
    String name,sx;
EditText et_nameb;
EditText et_sxb;
Button btnupdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        anhxa();
        getdata();
        seteventupdate();
    }

    private void seteventupdate() {
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nhapvap_name=et_nameb.getText().toString();
                String nhapvao_sx=et_sxb.getText().toString();
                Intent intent=new Intent();
                intent.putExtra(NAME_UPDATE,nhapvap_name);
                intent.putExtra(MADEIN_UPDATE,nhapvao_sx);


                setResult(RESULT,intent);
                finish();
            }
        });
    }

    private void getdata() {
        Intent intent=getIntent();
        name=intent.getStringExtra(MainActivity.NAME);
        sx=intent.getStringExtra(MainActivity.MADE_IN);
        et_nameb.setText(name);
        et_sxb.setText(sx);
    }

    private void anhxa() {
        et_nameb= (EditText)findViewById(R.id.etb_name);
        et_sxb= (EditText) findViewById(R.id.etb_sx);
        btnupdate= (Button) findViewById(R.id.btnupdateb);
    }


}
