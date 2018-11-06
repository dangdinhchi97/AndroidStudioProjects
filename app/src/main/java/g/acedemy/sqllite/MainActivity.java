package g.acedemy.sqllite;

import android.app.Dialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Database database;
    private ListView lvcongviec;
    private List<CongViec> ds;
    private CongvietAdapter congvietAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       lvcongviec= (ListView) findViewById(R.id.lvdscongviec);
        ds=new ArrayList<CongViec>();
        congvietAdapter=new CongvietAdapter(this,R.layout.congviecform,ds);
        lvcongviec.setAdapter(congvietAdapter);


        //tao database
        database=new Database(this,"ghichu.sqlite",null,1);
        //tao bang
        database.QueryDatabase("create table if not exists CongViec (Id Integer primary key autoincrement,TenCV varchar(200))");
        //them vao database
       // database.QueryDatabase("insert into CongViec values(null,'di choi voi huong')");
        //truy xuat database
        getdatabase();
    }
    public void DialogXoaCongviec(final int Id, final String tencv){
        final Dialog dialog=new Dialog(this);

        dialog.setContentView(R.layout.dialog_xoa);
        dialog.setCancelable(false);
        dialog.show();
        Button btnxoa= (Button)dialog. findViewById(R.id.btnxoa);
        final Button btnhuyxoa= (Button)dialog. findViewById(R.id.btnhuyxoa);
        btnhuyxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.QueryDatabase("delete from CongViec where Id='"+Id+"'");
                Toast.makeText(MainActivity.this, "Susess delete"+tencv, Toast.LENGTH_SHORT).show();
                getdatabase();
                dialog.dismiss();
            }
        });

    }
    public void DialogSuacongviec(final int Id, String tencv){
        final Dialog dialog=new Dialog(this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_update);
        final EditText etten= (EditText) dialog.findViewById(R.id.dialogtencv);
        Button btnXacnhan= (Button) dialog.findViewById(R.id.btndalxacnhan);
        Button btnHuy= (Button) dialog.findViewById(R.id.btndalhuy);
        etten.setText(tencv);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tencv=etten.getText().toString().trim();
                if (tencv.equals("")){
                    Toast.makeText(MainActivity.this, "Ban phai nhap noi dung update!!", Toast.LENGTH_SHORT).show();

                }else {
                    database.QueryDatabase("update CongViec set TenCV ='"+tencv+"' where Id='"+Id+"'");
                    Toast.makeText(MainActivity.this, "Susses", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    getdatabase();

                }
            }
        });
        dialog.show();


    }
    public void getdatabase(){
        Cursor databaseCV=database.GetDatabase("select * from CongViec");
        ds.clear();
        while(databaseCV.moveToNext()){
            String ten=databaseCV.getString(1);
            int id=databaseCV.getInt(0);
            ds.add(new CongViec(id,ten));
        }
        congvietAdapter.notifyDataSetChanged();
    }
    //add cai menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.menuAdd){
            DialogAdd();
        }
        return super.onOptionsItemSelected(item);
    }
    private void DialogAdd(){

        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog_themcv);
        dialog.setCancelable(false);
        final EditText etTen= (EditText) dialog.findViewById(R.id.ettieude);
        Button btnAdd= (Button) dialog.findViewById(R.id.btnadd);
        Button btnHuy= (Button) dialog.findViewById(R.id.btnHuy);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tencv=etTen.getText().toString();
                if (tencv.equals("")){
                    Toast.makeText(MainActivity.this, "Vui long nhap ten cong viec!!!X", Toast.LENGTH_SHORT).show();

                }else {
                    database.QueryDatabase("insert into CongViec values(null,'"+ tencv +"')");
                    Toast.makeText(MainActivity.this, "Susses", Toast.LENGTH_SHORT).show();

                    getdatabase();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }
}
