package g.acedemy.chuyendoigiuacacfragmentvoinhau;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmenta,container,false);
        Button btnb= (Button)view. findViewById(R.id.btnb);
        Button btna= (Button)view. findViewById(R.id.btna);
       final  EditText eta= (EditText)view.findViewById(R.id.eta);
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etb= (EditText)getActivity(). findViewById(R.id.etb);

                etb.setText(eta.getText().toString());
            }
        });
        return view;
    }
}
