package iuh.exercise.andy.listfragmentbai4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView tvName,tvYear,tvAddress,tvEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tvName = findViewById(R.id.tvName);
        tvYear = findViewById(R.id.tvYear);
        tvAddress = findViewById(R.id.tvAddress);
        tvEmail = findViewById(R.id.tvEmail);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        Student student = (Student) bundle.getSerializable("student");
        tvName.setText(student.getName());
        tvYear.setText(student.getYear()+"");
        tvAddress.setText(student.getAddress());
        tvEmail.setText(student.getEmail());
    }
}
