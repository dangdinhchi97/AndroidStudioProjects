package g.acedemy.contextmenu_phanbietnamnu;

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

public class personAdapter extends ArrayAdapter<PerSon> {
    private Context context;
    private int resource;
    private List<PerSon> objects;
    public personAdapter( @NonNull Context context, int resource,  @NonNull List<PerSon> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position,  @Nullable View convertView,  @NonNull ViewGroup parent) {
        convertView=LayoutInflater.from(context).inflate(R.layout.person_item,parent,false);
        ImageView imageView= (ImageView)convertView.findViewById(R.id.imgnamnu);
        TextView tv_ten= (TextView) convertView.findViewById(R.id.tvten);
        TextView tv_sdt= (TextView) convertView.findViewById(R.id.tvsdt);
        PerSon perSon=objects.get(position);
        if(perSon.isMale()){
            imageView.setImageResource(R.drawable.nam);
        }else {
            imageView.setImageResource(R.drawable.nu);
        }
        tv_ten.setText(perSon.getTen());
        tv_sdt.setText(String.valueOf( perSon.getSdt()));

        return convertView;
    }
}
