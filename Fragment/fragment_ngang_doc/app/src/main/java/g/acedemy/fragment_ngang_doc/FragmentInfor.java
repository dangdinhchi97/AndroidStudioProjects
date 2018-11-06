package g.acedemy.fragment_ngang_doc;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentInfor extends Fragment {
public TextView tvten,tvnam,tvdiachi,tvemail;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  @Nullable ViewGroup container, Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.fragment_infor,container,false);
         anhxa();
        Bundle bundle =this.getArguments();
        SinhVien student= (SinhVien) bundle.getSerializable("student");

        tvten.setText(student.getHoTen());

        tvnam.setText(student.getNam());
        tvdiachi.setText(student.getDiachi());
        tvemail.setText(student.g());
        return view;
    }
//    public void Setinfor(SinhVien sv){
//
//        tvten.setText("Ten: "+sv.getHoTen());
//
//        tvnam.setText("Nam sinh: "+sv.getNam());
//        tvdiachi.setText("Dia chi: "+sv.getDiachi());
//        tvemail.setText("Email: "+sv.getEmail());
//
//    }
    private void anhxa(){
        tvten= (TextView) view.findViewById(R.id.tv_ten);
        tvnam= (TextView)view. findViewById(R.id.tv_nam);
        tvdiachi= (TextView) view.findViewById(R.id.tv_diachi);
        tvemail= (TextView) view.findViewById(R.id.tv_email);
    }
}
