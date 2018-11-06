package g.acedemy.fragmentbuble;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnmain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnmain= (Button) findViewById(R.id.btnmain);
        FragmentManager fragmentManager=getFragmentManager();
        final FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        btnmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentA fragmentA=new FragmentA();
                Bundle bundle=new Bundle();
                bundle.putString("ho va ten", "Dang Dinh Chi");
                fragmentA.setArguments(bundle);
                fragmentTransaction.add(R.id.linearfragment,fragmentA);
                fragmentTransaction.commit();
            }
        });
    }
}
