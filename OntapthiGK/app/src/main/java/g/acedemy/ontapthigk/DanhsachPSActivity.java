package g.acedemy.ontapthigk;

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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DanhsachPSActivity extends AppCompatActivity {
    private Dialog dialog;
    private ListView lv;
    private ArrayList<Person> object;
    private psAdapter adt;
    public static final String TEN="TEN";
    public static final String SDT="SDT";
    public static final String NAM="NAM";
    public int vitri=-1;
    public static final int REQUEST_CODE=100;
    public static final int REQUEST_CODE1=200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
    }

    private void anhxa() {
        lv= (ListView) findViewById(R.id.lv);
        object=new ArrayList<>();
        object.add(new Person(true,"Chi",112));
        object.add(new Person(true,"Tien",113));
        object.add(new Person(true,"Chi",112));
        object.add(new Person(true,"Chi",112));


        object.add(new Person(true,"Chi",112));
        object.add(new Person(false,"Chi",112));
        object.add(new Person(true,"Chi",112));
        object.add(new Person(true,"Chi",112));
        object.add(new Person(true,"Chi",112));
        object.add(new Person(true,"Chi",112));
        adt=new psAdapter(this,R.layout.person_item,object);
        lv.setAdapter(adt);
        gan_de_lay_posittion();
        registerForContextMenu(lv);

    }
    public void gan_de_lay_posittion(){
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
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
        getMenuInflater().inflate(R.menu.example_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.detail:
                Intent intent=new Intent(DanhsachPSActivity.this,ViewDetailActivity.class);
                intent.putExtra(TEN,object.get(vitri).getTen());
                intent.putExtra(SDT,object.get(vitri).getSdt());
                intent.putExtra(NAM,object.get(vitri).isMale());
                startActivity(intent);
                break;
            case R.id.add:
                Intent intent1=new Intent(DanhsachPSActivity.this,AddActivity.class);
                startActivityForResult(intent1,REQUEST_CODE);
                break;
            case R.id.remove:

                dialog=new Dialog(DanhsachPSActivity.this);
                dialog.setTitle("Ban co muon xoa no khong ne!");
                dialog.setContentView(R.layout.dialog);
                dialog.show();
                Button btnxoa= (Button) dialog.findViewById(R.id.btnxoa);
                Button btnkhongxoa= (Button)dialog. findViewById(R.id.btnkhongxoa);
                btnxoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        adt.remove(object.get(vitri));
                        adt.notifyDataSetChanged();
                        Toast.makeText(DanhsachPSActivity.this, "xoa thanh cong", Toast.LENGTH_SHORT).show();
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
                Intent intent2=new Intent(DanhsachPSActivity.this,UpdateActivity.class);
                boolean gioitinhupdate=object.get(vitri).isMale();
                String tenupdate=object.get(vitri).getTen();
                long sdtupdate=Long.parseLong(String.valueOf(object.get(vitri).getSdt()));
                intent2.putExtra(NAM,gioitinhupdate);
                intent2.putExtra(TEN,tenupdate);
                intent2.putExtra(SDT,sdtupdate);
                startActivityForResult(intent2,REQUEST_CODE1);
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE){
            switch (resultCode){
                case AddActivity.RESULT_ADD:
                    boolean gioitinh=data.getBooleanExtra(AddActivity.GIOITINH,true);
                    String ten=data.getStringExtra(AddActivity.TEN_ADD);
                    int sdt=data.getIntExtra(AddActivity.SDT_ADD,11);
                   Person psadd=new Person(gioitinh,ten,sdt);
                   object.add(psadd);
                   adt.notifyDataSetChanged();

                    break;

            }
        }
        if(requestCode==REQUEST_CODE1){
            switch (resultCode){
                case UpdateActivity.RESULT_UPDATE:
                    boolean gioitinh=data.getBooleanExtra(UpdateActivity.GIOITINH,true);
                    String ten=data.getStringExtra(UpdateActivity.TEN);
                    int sdt=data.getIntExtra(UpdateActivity.GIOITINH,0);
                    Person psonupdate=new Person(gioitinh,ten,sdt);
                    object.set(vitri,psonupdate);
                    adt.notifyDataSetChanged();
                    break;
            }
        }
    }
}
