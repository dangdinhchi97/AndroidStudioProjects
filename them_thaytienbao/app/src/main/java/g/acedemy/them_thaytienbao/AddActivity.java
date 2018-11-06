package g.acedemy.them_thaytienbao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    private ListView lv;
    private personAdapter adt;
    private ArrayList<Person>object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
       anhxa();
       getData();
        Button btnreturn = (Button) findViewById(R.id.returnd);
        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
    public void anhxa(){
        lv= (ListView) findViewById(R.id.lv);
        object=new ArrayList<>();
        object.add(new Person(true,1,"f"));
        adt=new personAdapter(this,R.layout.person_item,object);
        lv.setAdapter(adt);
    }
    public void getData(){
        Intent intent=getIntent();
        boolean gioitinh;
        gioitinh=intent.getBooleanExtra(MainActivity.GT,true);
        String ten=intent.getStringExtra(MainActivity.TEN);
        int ma=intent.getIntExtra(MainActivity.MA,33);
        Person ps=new Person(gioitinh,ma,ten);
        object.add(ps);
        adt.notifyDataSetChanged();
    }
}
