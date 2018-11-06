package g.acedemy.kiemtragiuaki_contextmenu_themxoasua;

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

public class psonAdapter extends ArrayAdapter<Person> {
    private Context context;
    private int resource;
    private ArrayList<Person> objects;
    public psonAdapter( Context context, int resource,  @NonNull ArrayList<Person> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }


    @NonNull
    @Override
    public View getView(int position,  @Nullable View convertView,  @NonNull ViewGroup parent) {
        convertView=LayoutInflater.from(context).inflate(R.layout.layout_person_item,parent,false);
        ImageView imghinh= (ImageView)convertView. findViewById(R.id.imghinh);
        TextView tvten= (TextView) convertView.findViewById(R.id.tvten);
        TextView tvtuoi= (TextView) convertView.findViewById(R.id.tvtuoi);
        Person pson=objects.get(position);
        if(pson.isIsmale()){
            imghinh.setImageResource(R.drawable.nam);
        }else {
            imghinh.setImageResource(R.drawable.nu);
        }
        tvten.setText(objects.get(position).getTen());
        tvtuoi.setText(String.valueOf(objects.get(position).getTuoi()));
        return convertView;
    }
}
