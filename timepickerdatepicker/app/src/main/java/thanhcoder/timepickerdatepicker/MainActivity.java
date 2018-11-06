package thanhcoder.timepickerdatepicker;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
private DatePicker dp;
private TimePicker tp;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp=(DatePicker)findViewById(R.id.idDP);
        tp=(TimePicker)findViewById(R.id.idTP);
        setupDatePicker();
        setupTimePicker();
    }
  //  @RequiresApi(api = Build.VERSION_CODES.N)
    public void setupDatePicker(){
        Calendar ca=Calendar.getInstance();
        int year=ca.get(ca.YEAR);
        final int  month=ca.get(ca.MONTH);
        int day=ca.get(ca.DAY_OF_MONTH);
        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(MainActivity.this,dayOfMonth+"-"+monthOfYear+"-"+year,Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void setupTimePicker(){
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this,hourOfDay+"-"+minute,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
