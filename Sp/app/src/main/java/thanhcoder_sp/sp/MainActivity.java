package thanhcoder_sp.sp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=(Spinner)findViewById(R.id.idspiner);

        List<String >list =new ArrayList<>();//khai bao mot mang danh dach
        list.add("JAVA");
        list.add("ANDOIRD");
        list.add("IOS");
        list.add("JAV5");
        list.add("ANDOIRD5");
        list.add("IOS4");
        list.add("JAV4");
        list.add("ANDOIRD4");
        list.add("IOS3");
        list.add("JAV2");
        list.add("ANDOIRD1");
        list.add("IOS1");
        list.add("JAV1");
//ArrayAdapter la cau noi giua view va du lieu (list)
        //this: lay activity hien tai
        //iteim sap xep theo chieu doc va tung hang
        //list la mot oject nao do
        ArrayAdapter<String>adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
       //lam mau cho o cham tron
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        //dua len
        sp.setAdapter(adapter);

        /*bat su kien cho spiner*/
       sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(MainActivity.this,sp.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

    }
}
