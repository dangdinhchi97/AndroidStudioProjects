package thanhcoder.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private ListView lv;
private String []number={"000000","000000333","11111222","33333333"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.idlv);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,number);
        lv.setAdapter(arrayAdapter);


    }
}
