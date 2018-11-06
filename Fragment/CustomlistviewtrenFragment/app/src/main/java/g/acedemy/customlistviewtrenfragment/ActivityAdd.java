package g.acedemy.customlistviewtrenfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActivityAdd extends AppCompatActivity {
    public static final int KQ_ADD=121;

    public static final String GT_ADD="GT_ADD";
    public static final String TEN_ADD="TEN_ADD";
    public static final String TUOI_ADD="TUOI_ADD";
    public static final String ANH_ADD="ANH_ADD";
Button btnadd;
ImageView img_anhsex;
EditText etten,ettuoi;
RadioButton rdnam,rdnu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        anhxa();
        eventadd();
        rdnam.setChecked(true);
    }

    private void anhxa() {
        btnadd= (Button) findViewById(R.id.btn_add);
        rdnam= (RadioButton) findViewById(R.id.rbtnmale_add);
        rdnu= (RadioButton) findViewById(R.id.rbtnfamale_add);
        etten= (EditText) findViewById(R.id.et_ten_add);
        ettuoi= (EditText) findViewById(R.id.et_tuoi_add);
        img_anhsex= (ImageView) findViewById(R.id.img_country_add);
    }

    private void eventadd() {
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                if (rdnam.isChecked()){
                    intent.putExtra(GT_ADD,true);
                }else {
                    intent.putExtra(GT_ADD,false);
                }

                String name=etten.getText().toString();
                int tuoi= Integer.parseInt(ettuoi.getText().toString());
                if (name.equalsIgnoreCase("")){
                    Toast.makeText(ActivityAdd.this, "Ban chua nhap name", Toast.LENGTH_SHORT).show();
                }else if (String.valueOf(tuoi).equalsIgnoreCase("")){
                    Toast.makeText(ActivityAdd.this, "Ban chua nhap age", Toast.LENGTH_SHORT).show();
                }
                else {
                    intent.putExtra(TEN_ADD, name);

                    intent.putExtra(TUOI_ADD, tuoi);
                    setResult(KQ_ADD, intent);
                    finish();
                }
            }
        });
    }
}
