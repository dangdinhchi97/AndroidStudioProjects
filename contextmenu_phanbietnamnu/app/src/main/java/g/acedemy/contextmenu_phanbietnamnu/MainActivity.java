package g.acedemy.contextmenu_phanbietnamnu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ListView lv;
private ArrayList<PerSon> persons;
private personAdapter personAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();

    }

    private void anhxa() {
        lv= (ListView) findViewById(R.id.lv);
        persons=new ArrayList<>();
        persons.add(new PerSon(true,"Thien", 1633));
        persons.add(new PerSon(true,"Huyen", 163));
        persons.add(new PerSon(true,"Thai", 1633));
        persons.add(new PerSon(true,"Van", 163333));
        persons.add(new PerSon(true,"Minh", 1633));
        persons.add(new PerSon(true,"tiep", 1633));
        persons.add(new PerSon(true,"Tien", 1633));
        persons.add(new PerSon(true,"thien", 163));
        persons.add(new PerSon(true,"xu", 16333));
        personAdapter=new personAdapter(this,R.layout.person_item,persons);
        lv.setAdapter(personAdapter);


    }
}
