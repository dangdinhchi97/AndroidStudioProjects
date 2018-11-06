package g.acedemy.kiemtragiuaki_contextmenu_themxoasua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class AddActivity extends AppCompatActivity {
    public static final String GIOITINH_ADD="GIOITINH_ADD";
    public static final String TEN_ADD="TEN_ADD";
    public static final String TUOI_ADD="TUOI_ADD";
    public static final int  RESULt_ADD=121122;
    EditText etname;
    EditText ettuoi;
RadioButton rnam,rnu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
         rnam= (RadioButton) findViewById(R.id.rnam);
         rnu= (RadioButton) findViewById(R.id.rnu);
        etname= (EditText) findViewById(R.id.etten);
         ettuoi= (EditText) findViewById(R.id.ettuoi);
        Button btnadd= (Button) findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean gioitinh;
                Intent intent=new Intent();
                if(rnam.isChecked()){
                    gioitinh=true;
                    intent.putExtra(GIOITINH_ADD,gioitinh);
                }else if(rnu.isChecked()){
                    gioitinh=false;
                    intent.putExtra(GIOITINH_ADD,gioitinh);
                }
                String ten=etname.getText().toString();
                intent.putExtra(TEN_ADD,ten);
                int tuoi= Integer.parseInt(ettuoi.getText().toString());
                intent.putExtra(TUOI_ADD,tuoi);
                setResult(RESULt_ADD,intent);
                finish();

            }
        });
    }
}
