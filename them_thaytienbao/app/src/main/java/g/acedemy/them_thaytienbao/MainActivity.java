package g.acedemy.them_thaytienbao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    public static final String GT="GT";
    public static final String MA="MA";
    public static final String TEN="TEN";
    public static final int  REQUESCODE=100;


private EditText etma,etten;
private RadioButton rnam,rnu;
private Button btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rnam= (RadioButton) findViewById(R.id.rnam);
        rnu= (RadioButton) findViewById(R.id.rnu);

        etma= (EditText) findViewById(R.id.etma);
        etten= (EditText) findViewById(R.id.etten);
        btnadd= (Button) findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        Intent intent=new Intent(MainActivity.this,AddActivity.class);
        boolean gioitinh;
        if(rnam.isChecked()){
            gioitinh=true;
            intent.putExtra(GT,gioitinh);
        }else if(rnu.isChecked()){
            gioitinh=false;
            intent.putExtra(GT,gioitinh);
        }
        int ma= Integer.parseInt(etma.getText().toString());
        intent.putExtra(MA,ma);
        String ten=etten.getText().toString();
        intent.putExtra(TEN,ten);
        startActivity(intent);

            }
        });
    }
}
