package com.deptrai.minhnhat.onthigiuaky;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class personAdapter extends ArrayAdapter<person> {
    private Context context;
    private int resource;
    private List<person> objects;
    public personAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<person> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        //convertView= LayoutInflater.from(context).inflate(R.layout.person_list.);
        convertView = LayoutInflater.from(context).inflate(resource, parent, false);

        TextView tvname = (TextView) convertView.findViewById(R.id.txtName);

        TextView tvage = (TextView) convertView.findViewById(R.id.txtAge);

        ImageView image = (ImageView) convertView.findViewById(R.id.imgAvatar);
        ImageView ensign = (ImageView) convertView.findViewById(R.id.imgEnsign);

        tvname.setText(objects.get(position).getName());
        tvage.setText(objects.get(position).getAge()+ "");
        image.setImageResource(objects.get(position).getImages());
        ensign.setImageResource(objects.get(position).getEnsign());

        return convertView;
        //super.getView(position, convertView, parent);
    }
}