package g.acedemy.ontapthigk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
private RadioButton addnam,addnu;
private EditText edadd_ten,edadd_sdt;
private  Button btnAdd;
public static final String TEN_ADD="TEN_ADD";
public static final String SDT_ADD="SDT_ADD";
public static final String GIOITINH="GiOITINH";
public static final int  RESULT_ADD=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        addnam= (RadioButton) findViewById(R.id.addnam);
        addnu= (RadioButton) findViewById(R.id.addnu);
        edadd_ten= (EditText) findViewById(R.id.edadd_ten);
        edadd_sdt= (EditText) findViewById(R.id.edadd_sdt);
       btnAdd= (Button) findViewById(R.id.btnAdd);
       addnam.setChecked(true);
        eventAdd();

    }

   public void eventAdd(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                Boolean isMale;



                String ten=edadd_ten.getText().toString();
                int sdt=Integer.parseInt(edadd_sdt.getText().toString());




                    if (addnam.isChecked()) {

                        isMale = true;
                        intent.putExtra(GIOITINH,isMale);

                    } else {
                        isMale = false;
                        intent.putExtra(GIOITINH,isMale);
                    }
                    intent.putExtra(TEN_ADD,ten);
                    intent.putExtra(SDT_ADD,sdt);
                   setResult(RESULT_ADD,intent);
                   finish();

            }
        });
   }


}
