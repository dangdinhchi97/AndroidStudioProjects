package g.acedemy.fagment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void AddFragment(View view){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragment fragment=null;
        switch (view.getId()){
            case R.id.fragmenta:
                fragment=new fragment_form();

                break;
            case R.id.fragmentb:
                fragment=new fragment_formb();
                break;
        }
        fragmentTransaction.replace(R.id.framcontent,fragment);
        fragmentTransaction.commit();
    }
}
