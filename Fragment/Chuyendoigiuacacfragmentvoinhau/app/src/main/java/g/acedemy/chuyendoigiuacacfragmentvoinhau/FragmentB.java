package g.acedemy.chuyendoigiuacacfragmentvoinhau;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class FragmentB extends Fragment {
    EditText etb;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmentb,container,false);
         etb= (EditText)view. findViewById(R.id.etb);
        return view;
    }
    public void thaydoi(String noidung){

        etb.setText(noidung);
    }
}
