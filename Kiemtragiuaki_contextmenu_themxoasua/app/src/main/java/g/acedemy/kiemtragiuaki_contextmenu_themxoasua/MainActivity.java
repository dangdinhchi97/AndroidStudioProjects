package g.acedemy.kiemtragiuaki_contextmenu_themxoasua;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int vitri=-1;
    public static final String TEN ="TEN";
    public static final String TUOI ="TUOI";
    public static final String HINH ="HINH";
    public static final int  REQUEST_CODE=100;
    public static final int  REQUEST_CODE1=1001;
private Dialog dialog;
private ListView lvperson;
private psonAdapter adt;
private ArrayList<Person> objects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        gan_de_lay_posittion();
        registerForContextMenu(lvperson);
    }

    private void anhxa() {
        lvperson= (ListView) findViewById(R.id.lvperson);
        objects=new ArrayList<>();
        objects.add(new Person(true,"Chi",12));
        objects.add(new Person(false,"huyen",12));
        objects.add(new Person(true,"Chi",12));
        objects.add(new Person(false,"Thu",12));
        adt=new psonAdapter(this,R.layout.layout_person_item,objects);
        lvperson.setAdapter(adt);
    }
public void gan_de_lay_posittion(){
        lvperson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                vitri=position;
                return false;
            }
        });
}

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menucontext,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
                break;
            case R.id.detele:
                dialog=new Dialog(MainActivity.this);
                dialog.setTitle("Ban co muon xoa khong!");
                dialog.setContentView(R.layout.dialog);
                dialog.show();
                Button btnxoa= (Button) dialog.findViewById(R.id.xoa);
                Button btnkhongxoa= (Button) dialog.findViewById(R.id.khongxoa);
                btnxoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        objects.remove(vitri);
                        adt.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "xoa thanh cong", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                btnkhongxoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.update:
                Intent intent1=new Intent(MainActivity.this,UpdateActivity.class);
                boolean gioitinh=objects.get(vitri).isIsmale();
                String ten=objects.get(vitri).getTen();
                int tuoi=Integer.parseInt(String.valueOf(objects.get(vitri).getTuoi()));
                intent1.putExtra(HINH,gioitinh);
                intent1.putExtra(TEN,ten);
                intent1.putExtra(TUOI,tuoi);
                startActivityForResult(intent1,REQUEST_CODE1);
                break;
            case R.id.detail:
                Intent intent2=new Intent(MainActivity.this,Detail.class);
                boolean gioitinhh=objects.get(vitri).isIsmale();
                String tenn=objects.get(vitri).getTen();
                int tuoii=Integer.parseInt(String.valueOf(objects.get(vitri).getTuoi()));
                intent2.putExtra(HINH,gioitinhh);
                intent2.putExtra(TEN,tenn);
                intent2.putExtra(TUOI,tuoii);
                startActivity(intent2);
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode==REQUEST_CODE){
           switch (resultCode){
               case AddActivity.RESULt_ADD:
                   boolean gioitinh=data.getBooleanExtra(AddActivity.GIOITINH_ADD,true);
                   String ten=data.getStringExtra(AddActivity.TEN_ADD);
                   int tuoi=data.getIntExtra(AddActivity.TUOI_ADD,9);
                   Person pson=new Person(gioitinh,ten,tuoi);
                   objects.add(pson);
                   adt.notifyDataSetChanged();
                   break;
           }
       }
       if(requestCode==REQUEST_CODE1){
           switch (resultCode){
               case UpdateActivity.RESULt_UPDATE:
                   boolean gioitinh=data.getBooleanExtra(UpdateActivity.GIOITINH_ADD,true);
                   String ten=data.getStringExtra(UpdateActivity.TEN_ADD);
                   int tuoi=data.getIntExtra(UpdateActivity.TUOI_ADD,99);
                   Person ps=new Person(gioitinh,ten,tuoi);
                   objects.set(vitri,ps);
                   break;
           }
       }

    }
}
