package g.acedemy.themxoasualistview;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv_name;
    TextView tv_sx;
   public  static final String NAME="NAME";
     public static final String MADE_IN="MADE_IN";
    public  static final int  REQUESCODE=111;
    Dialog dialog;

    EditText et_name;
    EditText et_madein;
    ListView lv_listview;
    Button btnadd,bntupdate;

    sanphamAdapter adapter;
    ArrayList<SanPHam> sanPHams;
    int vitri=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       getListview();
        update();
        evenadd();

        evenremove();
    }

    private void update() {
       lv_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               vitri=position;
             //  if(!(et_name.getText().toString().equalsIgnoreCase(""))&&!et_madein.getText().toString().equalsIgnoreCase("")){
              // tv_name= (TextView)findViewById(R.id.tvten);
              // tv_sx= (TextView) findViewById(R.id.tvsx);
              // SanPHam sp=new SanPHam(Color.BLUE,tv_name,tv_sx);
                   Intent intent=new Intent(MainActivity.this,activityB.class);
                   String  nameinput=sanPHams.get(position).getTenSp();

                   String sxinput=sanPHams.get(position).getSxSp();
                   intent.putExtra(NAME,  nameinput);
                   intent.putExtra(MADE_IN,sxinput);
                   startActivityForResult(intent,REQUESCODE);
              // }

           }
       });
    }
    private void evenremove(){
        lv_listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                sanPHams.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
      /*  bntupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SanPHam sp=new SanPHam();

               String a=et_name.getText().toString();
                String b=et_madein.getText().toString();
                SanPHam sp=new SanPHam(Color.BLUE,a,b);
                sanPHams.set(vitri,sp);
                adapter.notifyDataSetChanged();

            }
        });*/




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUESCODE){
            switch (resultCode){
                case activityB.RESULT:
                    String nameresult=data.getStringExtra(activityB.NAME_UPDATE);
                    String madeinresult=data.getStringExtra(activityB.MADEIN_UPDATE);
                    SanPHam sp=new SanPHam(Color.BLACK,nameresult,madeinresult);
                    sanPHams.set(vitri,sp);
                    adapter.notifyDataSetChanged();
                    break;
                    default:break;
            }
        }
    }


    /*private void evenremove() {
        lv_listview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                dialog=new Dialog(MainActivity.this);
                dialog.setTitle("Do you wana delete?");

                dialog.setContentView(R.layout.dialog);
                dialog.show();
                Button btnxoa= (Button) dialog.findViewById(R.id.btnxoa);
                Button btnkhongxoa= (Button) dialog.findViewById(R.id.btnkhongxoa);
                btnxoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {



                            sanPHams.remove(vitri);
                            adapter.notifyDataSetChanged();
                            Toast.makeText(MainActivity.this, "Remove susses", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this, "Remove fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                btnkhongxoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Did exit", Toast.LENGTH_SHORT).show();
                    }
                });

                return false;
            }
        });

    }*/

    private void evenadd() {
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int ma=-1;
                String name=et_name.getText().toString();
                String sx=et_madein.getText().toString();


                if (name.equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "you  have to press name for product", Toast.LENGTH_SHORT).show();
                }
                else if (sx.equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "you have to press made in for product", Toast.LENGTH_SHORT).show();
                }
                else {
                    SanPHam sp = new SanPHam(ma, name, sx);
                    sanPHams.add(sp);
                    adapter.notifyDataSetChanged();

                }
            }
        });


    }

    private void getListview() {
        btnadd= (Button) findViewById(R.id.btnadd);


        bntupdate= (Button) findViewById(R.id.btnupdate);


        et_name= (EditText) findViewById(R.id.et_name);
        et_madein= (EditText) findViewById(R.id.et_sx);

        lv_listview= (ListView) findViewById(R.id.lvlistview);
        sanPHams=new ArrayList<SanPHam>();
        sanPHams.add(new SanPHam(Color.BLACK,"ABC","Ha Noi"));
        sanPHams.add(new SanPHam(Color.BLUE,"E","Ha Noi"));
        sanPHams.add(new SanPHam(Color.BLUE,"F","Ha Noi"));
        sanPHams.add(new SanPHam(Color.BLUE,"D","Ha Noi"));
        sanPHams.add(new SanPHam(Color.BLUE,"C","Ha Noi"));
        sanPHams.add(new SanPHam(Color.BLUE,"AC","Ha Noi"));
        sanPHams.add(new SanPHam(Color.BLUE,"BC","Ha Noi"));
        sanPHams.add(new SanPHam(Color.BLUE,"aABC","Ha Noi"));
        sanPHams.add(new SanPHam(Color.BLUE,"AbBC","Ha Noi"));
        sanPHams.add(new SanPHam(Color.BLUE,"ABcC","Ha Noi"));
        sanPHams.add(new SanPHam(Color.BLUE,"ABCd","Ha Noi"));
        sanPHams.add(new SanPHam(Color.BLUE,"ABCf","Ho Chi Minh"));

        adapter=new sanphamAdapter(this,R.layout.sanpham_layout,sanPHams);
        lv_listview.setAdapter(adapter);



    }

}
