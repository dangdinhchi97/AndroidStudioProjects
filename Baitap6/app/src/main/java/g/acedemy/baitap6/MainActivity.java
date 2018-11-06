package g.acedemy.baitap6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private EditText etuser_name;
private EditText etpass_word;
private Button btn_longon;
private Button btn_reset;
private Button btn_exit;
private Button bnt_clearall;
private ListView lv_longon;

private ArrayList<Taikhoan> object;
private TaikhoanAdapter adt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        getObject();
        envenLongon();
        envenReset();
        envenExit();
        envenClearAll();

    }

    private void envenClearAll() {
        bnt_clearall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.removeAll(object);
                adt.notifyDataSetChanged();
            }
        });
    }

    private void envenExit() {
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }

    private void envenReset() {
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etuser_name.setText("");
                etpass_word.setText("");
            }
        });
    }
    private void getObject(){
        String user=etuser_name.getText().toString();
        String pass=etpass_word.getText().toString();


        object=new ArrayList<>();
        object.add(new Taikhoan("Mai","Mai"));
        object.add(new Taikhoan("Hai ","Ha "));
        object.add(new Taikhoan("Tuan ","Tuan"));
        adt=new TaikhoanAdapter(this,R.layout.nguoidung,object);
        lv_longon.setAdapter(adt);

    }
    private void anhxa() {
        lv_longon= (ListView) findViewById(R.id.lvlongon);
        etuser_name= (EditText) findViewById(R.id.etusername);
        etpass_word= (EditText) findViewById(R.id.etpassword);
        btn_longon= (Button) findViewById(R.id.btnlogin);
        btn_reset= (Button) findViewById(R.id.btnreset);
        btn_exit= (Button) findViewById(R.id.btnexit);

        bnt_clearall= (Button) findViewById(R.id.btnclear);
    }
    private void envenLongon(){
        btn_longon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=etuser_name.getText().toString();
                String password=etpass_word.getText().toString();
                if(username.equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "You have to input username", Toast.LENGTH_SHORT).show();
                }
                else if(password.equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "You have to input password", Toast.LENGTH_SHORT).show();
                }
                else {
                    String user=etuser_name.getText().toString().trim();
                    String pass=etpass_word.getText().toString().trim();
                    Taikhoan tk=new Taikhoan(user,pass);
                    object.add(tk);
                }
                adt.notifyDataSetChanged();
            }
        });
    }
}
