package g.acedemy.customlistviewtrenfragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.ContextMenu;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GaigoiFragment extends Fragment {
    public static final int REQUEST_CODE=100;
    public static final int REQUEST_CODE1=101;
    public static final String NAM="NAM";
    public static final String TEN="TEN";
    public static final String TUOI="TUOI";
    public static final String IMG_COUNTRY="IMG_COUNTRY";
ListView lva;
public int vitri=-1;
    GaigoiAdapter adapter;
    ArrayList<Gaigoi> object;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.gaigoifragment,container,false);

        lva= (ListView)view. findViewById(R.id.lva);
        object=new ArrayList<>();
        object.add(new Gaigoi(false,"Tran thu Tam",19,R.drawable.gg2));
        object.add(new Gaigoi(true,"Dang Minh Nhut",20,R.drawable.tg2));
        object.add(new Gaigoi(false,"Dao Tuong Vi",16,R.drawable.gg3));
        object.add(new Gaigoi(false,"Nhung MiHo",25,R.drawable.gg4));
        object.add(new Gaigoi(false,"Bang Do Nhi",23,R.drawable.gg1));
        object.add(new Gaigoi(true,"Kin Kong Do Rang",22,R.drawable.tg5));
        object.add(new Gaigoi(false,"Be Thao Nhi",21,R.drawable.gg3));
        object.add(new Gaigoi(true,"Be Quan Que",18,R.drawable.tg1));
        object.add(new Gaigoi(false,"Tran thu Tam",29,R.drawable.gg1));

       adapter=new GaigoiAdapter(getActivity(),R.layout.gaigoiform,object);
        lva.setAdapter(adapter);
        registerForContextMenu(lva);
        layvitri();
        return view;
    }
    public void layvitri(){
        lva.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                vitri=position;
                return false;
            }
        });
    }
     /* @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.examplemenu,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }*/

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.detail:
                Intent intent=new Intent(getActivity(),ActivityDetail.class);
                intent.putExtra(NAM,object.get(vitri).isMale());
                intent.putExtra(TEN,object.get(vitri).getTen());
                intent.putExtra(TUOI,object.get(vitri).getTuoi());
                intent.putExtra(IMG_COUNTRY,object.get(vitri).getImg_country());
                startActivity(intent);
                break;
            case R.id.add:
                Intent intent1=new Intent(getActivity(),ActivityAdd.class);
                startActivityForResult(intent1,REQUEST_CODE);
                break;
            case R.id.update:
                Intent intent2=new Intent(getActivity(),ActivityUpdate.class);
                intent2.putExtra(NAM,object.get(vitri).isMale());
                intent2.putExtra(TEN,object.get(vitri).getTen());
                intent2.putExtra(TUOI,object.get(vitri).getTuoi());
                intent2.putExtra(IMG_COUNTRY,object.get(vitri).getImg_country());
                startActivityForResult(intent2,REQUEST_CODE1);
                break;
            case R.id.delete:
                final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                builder.setTitle("Ban co muon xoa khong ne!");
                builder.setMessage("@chicua(i love you");
                builder.setCancelable(true);
                //true kich ben ngoai bi mat va flase nguoc lai
                builder.setPositiveButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                             dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Xoa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.remove(object.get(vitri));
                        Toast.makeText(getActivity(), "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog aler=builder.create();
                aler.show();
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE){
            switch (resultCode){
                case ActivityAdd.KQ_ADD:
                    boolean gioitinh=data.getBooleanExtra(ActivityAdd.TEN_ADD,true);
                    String name=data.getStringExtra(ActivityAdd.TEN_ADD);
                    int tuoi=data.getIntExtra(ActivityAdd.TUOI_ADD,1);
                    Gaigoi gg_add=new Gaigoi(gioitinh,name,tuoi,R.drawable.gg2);
                    object.add(gg_add);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }else if (requestCode==REQUEST_CODE1){
            switch (resultCode){
                case ActivityUpdate.KQ_UPDATE:
                    boolean gioitinh=data.getBooleanExtra(ActivityUpdate.GIOITINH_UPDATE,true);
                    String name=data.getStringExtra(ActivityUpdate.TEN_UPDATE);
                    int tuoi=data.getIntExtra(ActivityUpdate.TUOI_UPDATE,1);
                   // int hinh=data.getIntExtra(ActivityUpdate.IMG__CT_UPDATE,33);
                    int hinh=R.drawable.gg4;
                    Gaigoi gg_update=new Gaigoi(gioitinh,name,tuoi,hinh);
                    object.set(vitri,gg_update);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }
}
