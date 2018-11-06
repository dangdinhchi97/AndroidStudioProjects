package g.acedemy.ontapthigk;

import android.content.Context;
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

public class psAdapter extends ArrayAdapter<Person> {
private Context context;
private int resource;
private ArrayList<Person>  person;

    public psAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Person> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.person=objects;
    }


    @NonNull
    @Override
    public View getView(int position,  @Nullable View convertView,  @NonNull ViewGroup parent) {
        convertView=LayoutInflater.from(context).inflate(R.layout.person_item,parent,false);
        ImageView img= (ImageView)convertView. findViewById(R.id.img);
        TextView tv_ten= (TextView)convertView. findViewById(R.id.tvten);
        TextView tv_sdt= (TextView)convertView. findViewById(R.id.tvsdt);
        Person pson=person.get(position);

        if(pson.isMale()){
            img.setImageResource(R.drawable.nam);

        }else {
            img.setImageResource(R.drawable.nu);
        }
        tv_ten.setText(pson.getTen());
        tv_sdt.setText(String.valueOf(pson.getSdt()));
        return convertView;
    }
}
