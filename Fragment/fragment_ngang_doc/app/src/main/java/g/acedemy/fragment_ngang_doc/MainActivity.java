package g.acedemy.fragment_ngang_doc;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements TruyenSinhVien{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void DataStudent(SinhVien sinhVien) {
        FragmentInfor fragmentInfor= (FragmentInfor) getFragmentManager().findFragmentById(R.id.fragmentinfor);
        Configuration configuration=getResources().getConfiguration();

       if (fragmentInfor!=null&&configuration.orientation==Configuration.ORIENTATION_LANDSCAPE) {
           fragmentInfor.Setinfor(sinhVien);
       }
       else {

           Intent intent=new Intent(this,FragmentAcitivity_infor.class);
           intent.putExtra("thongtinsinhvien ",  sinhVien);
           startActivity(intent);

       }
    }
}
