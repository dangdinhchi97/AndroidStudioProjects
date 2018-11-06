package iuh.exercise.andy.listfragmentbai4;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ListFragment extends android.support.v4.app.ListFragment {
    private ArrayList<Student> students;
    private MainActivity mainActivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        students = new ArrayList<>();
        students.add(new Student("Nguyễn Hiếu Đức Ân", "TP.HCM", "annguyen3520@gmail.com", 1997));
        students.add(new Student("Phan Minh Phụng", "TP.HCM", "phung@gmail.com", 1997));
        students.add(new Student("Dương Hông Anh", "TP.HCM", "anh@gmail.com", 1997));
        students.add(new Student("Phan Chuẩn", "TP.HCM", "chuan@gmail.com", 1997));
        students.add(new Student("Nguyễn Văn Hải", "TP.HCM", "hai@gmail.com", 1997));
        students.add(new Student("Trần Trung Nam", "TP.HCM", "nam@gmail.com", 1997));
        students.add(new Student("Ai đây", "TP.HCM", "ai@gmail.com", 1997));
        students.add(new Student("Phan Minh Nhật", "TP.HCM", "nhat@gmail.com", 1997));
        CustomAdapter adapter = new CustomAdapter(getActivity(), R.layout.custom_list, students);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void openNewActivity(Student student) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("student", student);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mainActivity = (MainActivity) context;
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        int orientation = getResources().getConfiguration().orientation;
        Student student = students.get(position);
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            openNewActivity(student);
        } else {
            mainActivity.sendDetailToB(student);
        }
    }
}
