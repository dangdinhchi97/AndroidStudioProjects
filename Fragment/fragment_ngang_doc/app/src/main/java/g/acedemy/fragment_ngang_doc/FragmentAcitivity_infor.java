package g.acedemy.fragment_ngang_doc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FragmentAcitivity_infor extends AppCompatActivity {
TextView ten,nam,diachi,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_acitivity_infor);
//        ten= (TextView) findViewById(R.id.tv_tenn);
//        nam= (TextView) findViewById(R.id.tv_namm);
//        diachi= (TextView) findViewById(R.id.tv_diachii);
//        email= (TextView) findViewById(R.id.tv_emaill);
//        Intent intent=getIntent();
//      SinhVien sinhVien= (SinhVien) intent.getSerializableExtra("thongtinsinhvien");
//
//nam.setText(sinhVien.getNam());
//diachi.setText(sinhVien.getDiachi());
//email.setText(sinhVien.getEmail());
//        ten.setText(sinhVien.getHoTen());
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        SinhVien student= (SinhVien) bundle.getSerializable("student");

        Bundle bundle1 = new Bundle();
        bundle1.putSerializable("student", student);
        FragmentInfor frag= new FragmentInfor();
        frag.setArguments(bundle1);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag).commit();
        /*FragmentInfor infor= (FragmentInfor) getFragmentManager().findFragmentById(R.id.fragmentchitiet);
        infor.Setinfor(sinhVien);*/
    }
}
