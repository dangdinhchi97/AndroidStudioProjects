package g.acedemy.customlistviewtrenfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //lv_main= (ListView)findViewById(R.id.lv_main);
    }



    public void Fragment(View view){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragment fragment=null;
        switch (view.getId()){
            case R.id.btnfma:
                fragment=new GaigoiFragment();

                break;
            case R.id.btnfmb:
                fragment=new GaigoiFragmentB();

                break;
        }
        fragmentTransaction.replace(R.id.framlayout,fragment);
        fragmentTransaction.commit();
    }
       @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.examplemenu,menu);
    }
   /* @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }*/
}
