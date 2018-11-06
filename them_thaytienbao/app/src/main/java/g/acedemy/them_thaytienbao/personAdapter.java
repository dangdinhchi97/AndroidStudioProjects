package g.acedemy.them_thaytienbao;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class personAdapter extends ArrayAdapter<Person> {
    private Context context;
    private int resource;
    private ArrayList<Person> objects;
    public personAdapter( Context context, int resource,  ArrayList<Person> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }


    @NonNull
    @Override
    public View getView(int position,  @Nullable View convertView,  ViewGroup parent) {
        convertView=LayoutInflater.from(context).inflate(R.layout.person_item,parent,false);
        ImageView imggioitinh= (ImageView) convertView.findViewById(R.id.imggioitinh);
        TextView tvma= (TextView)convertView. findViewById(R.id.tvma);
        TextView tvten= (TextView)convertView. findViewById(R.id.tvten);

        Person pson=objects.get(position);

        int ma=pson.getMa();
        String ten=pson.getTen();
        if(pson.isMale()){
            imggioitinh.setImageResource(R.drawable.nam);

        }else imggioitinh.setImageResource(R.drawable.nu);
        tvma.setText(String.valueOf(ma));
        tvten.setText(ten);

        return convertView;
    }
}
