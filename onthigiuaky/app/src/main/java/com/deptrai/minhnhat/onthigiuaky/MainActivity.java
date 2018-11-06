package com.deptrai.minhnhat.onthigiuaky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvname;
    personAdapter adt;
    ArrayList obj;
    private String name;
    private int age;
    public static String NAME ="name_footballplayer";
    public static String AGE ="age_footballplayer";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvname = (ListView) findViewById(R.id.lstMyListview);
        obj = new ArrayList<>();
        obj.add(new person("Johan Cruff", 21, R.mipmap.johan, R.mipmap.halan));
        obj.add(new person("Diego Maradona", 20, R.mipmap.maradona, R.mipmap.achen));
        obj.add(new person("Franz Beckenbauer", 22, R.mipmap.beck, R.mipmap.german));
        obj.add(new person("Pele", 25, R.mipmap.pele, R.mipmap.brazil));
        obj.add(new person("Michel Platini", 20, R.mipmap.platini, R.mipmap.frank));
        obj.add(new person("Ronaldo De Lima", 19, R.mipmap.ronaldo, R.mipmap.brazil));
        obj.add(new person("Lionel Messi", 19, R.mipmap.messi, R.mipmap.achen));
        obj.add(new person("Gareth Bale", 20, R.mipmap.garethbale, R.mipmap.ireland));
        getData();

        adt = new personAdapter(MainActivity.this, R.layout.person_list, obj);

        lvname.setAdapter(adt);
        registerForContextMenu(lvname);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delete_id:
                obj.remove(info.position);
                adt.notifyDataSetChanged();
                return true;



            default:
                return super.onContextItemSelected(item);

        }
    }

    public void createContact(View view)
    {
        Intent intent = new Intent(MainActivity.this, CreateActivity.class);
        startActivity(intent);
    }

    public void getData(){
        Intent intent = getIntent();
        name = intent.getStringExtra(CreateActivity.NAME);
        age = intent.getIntExtra(CreateActivity.AGE, 0);
        obj.add(new person(name, age,0, 0));

    }
}
