package iuh.exercise.andy.listfragmentbai4;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {
    private TextView tvName,tvYear,tvEmail,tvAddress;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_details, container, false);
        tvName = view.findViewById(R.id.tvName);
        tvAddress = view.findViewById(R.id.tvAddress);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvYear = view.findViewById(R.id.tvYear);
        return view;
    }

    public void applyDetail(Student student) {
        tvName.setText(student.getName());
        tvYear.setText(student.getYear()+"");
        tvEmail.setText(student.getEmail());
        tvAddress.setText(student.getAddress());
    }
}
