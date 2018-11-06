package g.acedemy.dialo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Dialog dialog;
private Button btdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btdialog=(Button)findViewById(R.id.iddialog);
        btdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showdialog();
                showarladilog();
            }
        });
    }
    public void showdialog(){
        dialog=new Dialog(MainActivity.this);
        dialog.setTitle("ban co muon thoat khong");
        dialog.setContentView(R.layout.dialog);
        dialog.show();
        Button btThoat=(Button)dialog.findViewById(R.id.idthoat);
        Button btkhong=(Button)dialog.findViewById(R.id.idkhong);
        btThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"thoat thanh cong",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        btkhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

    }
    public void showarladilog(){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("ban co muon thoat khong ");
        builder.setCancelable(false);
        builder.setNegativeButton("Thoat", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"da thoat",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        AlertDialog aler=builder.create();
        aler.show();
    }
}
