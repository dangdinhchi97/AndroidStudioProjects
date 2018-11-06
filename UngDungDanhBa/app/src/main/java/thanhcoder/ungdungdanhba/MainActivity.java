package thanhcoder.ungdungdanhba;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import thanhcoder.ungdungdanhba.adapter.CustomAdapter;
import thanhcoder.ungdungdanhba.model.Contact;

public class MainActivity extends AppCompatActivity {
    private CustomAdapter adapter;
private List<Contact> arrayContact;
private EditText edtNumber;
private EditText edtName;
private RadioButton rbtnMale;
private RadioButton rbtnFemale;
private Button btnAddConTact;
private ListView lvContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setW();
        arrayContact=new ArrayList<>();
        //hihi
        adapter=new CustomAdapter(this,R.layout.itemcontext,arrayContact);
        ///
        lvContact.setAdapter(adapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                checkAndRequestPermissions();
                showDialogConfirm(position);

            }
        });
    }
//code xin quyen
    private void checkAndRequestPermissions() {
        String []permissions=new String[]{
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS
        };
        List <String>lispermisstionNeeded=new ArrayList<>();
        for (String permission:permissions){
            if(ContextCompat.checkSelfPermission(this,permission)!= PackageManager.PERMISSION_GRANTED){
                lispermisstionNeeded.add(permission);
            }
        }if(!lispermisstionNeeded.isEmpty()){
            ActivityCompat.requestPermissions(this,lispermisstionNeeded.toArray(new String[lispermisstionNeeded.size()]),1);
        }
    }

    private void intencall(int position) {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+arrayContact.get(position).getmNumber()));
        startActivity(intent);
    }
    private void intensent(int position) {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:"+arrayContact.get(position).getmNumber()));
        startActivity(intent);
    }

    public void setW(){
        edtName= (EditText) findViewById(R.id.etnam);
        edtNumber= (EditText) findViewById(R.id.etnumber);
        rbtnMale= (RadioButton) findViewById(R.id.rbmale);
        rbtnFemale= (RadioButton) findViewById(R.id.rbfemale);
        btnAddConTact= (Button) findViewById(R.id.btadd);
        lvContact= (ListView) findViewById(R.id.lv);
    }
    public void addContact(View view){
        if(view.getId()==R.id.btadd){
            String name=edtName.getText().toString().trim();
            String number=edtNumber.getText().toString().trim();
            boolean isMale=true;
            if(rbtnMale.isChecked()){
                isMale=true;
            }else isMale=false;
            if(TextUtils.isEmpty(name)||TextUtils.isEmpty(number)){
                Toast.makeText(this, "Please input number or name", Toast.LENGTH_SHORT).show();
            }else {
                Contact contact=new Contact(isMale,name,number);
                arrayContact.add(contact);
            }
            //hihi
            adapter.notifyDataSetChanged();
        }
    }
    public void showDialogConfirm(final int position){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        Button btnsend= (Button) dialog.findViewById(R.id.btsend);
        Button btncall= (Button) dialog.findViewById(R.id.btcall);
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intencall(position);
            }
        });
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intensent(position);
            }
        });
        dialog.show();
    }
}
