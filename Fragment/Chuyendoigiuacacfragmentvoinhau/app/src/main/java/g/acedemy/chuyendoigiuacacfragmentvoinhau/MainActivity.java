package g.acedemy.chuyendoigiuacacfragmentvoinhau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btna= (Button) findViewById(R.id.btna);
        final TextView tvmain= (TextView) findViewById(R.id.tvmain);
        final EditText etb= (EditText) findViewById(R.id.etb);
        final EditText eta= (EditText) findViewById(R.id.eta);
        Button btnmain= (Button) findViewById(R.id.btnmain);
        Button btnb= (Button) findViewById(R.id.btnb);
       /* btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               etb.setText(eta.getText().toString());
            }
        });*/
       btnb.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvmain.setText(etb.getText().toString());
           }
       });
       btnmain.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
        String a=tvmain.getText().toString();
               FragmentB fragmentB= (FragmentB) getFragmentManager().findFragmentById(R.id.frb);
               fragmentB.thaydoi(a);
           }
       });


    }
}
