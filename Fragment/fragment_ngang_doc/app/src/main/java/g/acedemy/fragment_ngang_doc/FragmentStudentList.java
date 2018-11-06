package g.acedemy.fragment_ngang_doc;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentStudentList extends ListFragment {
    private ArrayList<SinhVien> sinhviens;
    private StudentAdapter adapter;



    private TruyenSinhVien truyenSinhVien;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //
        truyenSinhVien= (TruyenSinhVien) getActivity();
        //


        sinhviens=new ArrayList<>();
        addlist();
        adapter=new StudentAdapter(getActivity(),R.layout.rowstudent,sinhviens);
        setListAdapter(adapter);
        return inflater.inflate(R.layout.fragmentstudentlist,container,false);
    }

    private void addlist(){
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Vo Minh A",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Linh Do Minh",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));
        sinhviens.add(new SinhVien("Dang Dinh Chi",19,"Long An", "dangdinhchi97@gmail.com"));



    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        truyenSinhVien.DataStudent(sinhviens.get(position));
    }
}
