package iuh.exercise.andy.listfragmentbai4;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView tvName,tvEmail,tvYear,tvAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendDetailToB(Student student) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DetailsFragment detailsFragment = (DetailsFragment) fragmentManager.findFragmentById(R.id.frag_details);
        if (detailsFragment != null && detailsFragment.isAdded()) {
            detailsFragment.applyDetail(student);
        }
    }
}
