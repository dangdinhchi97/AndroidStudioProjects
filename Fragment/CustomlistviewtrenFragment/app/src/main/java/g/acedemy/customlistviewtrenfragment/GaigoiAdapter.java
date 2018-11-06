package g.acedemy.customlistviewtrenfragment;

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

public class GaigoiAdapter extends ArrayAdapter<Gaigoi> {
    private Context context;
    private int resource;
    private ArrayList<Gaigoi>objects;
    public GaigoiAdapter( Context context, int resource,  ArrayList<Gaigoi> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }




    @NonNull
    @Override
    public View getView(int position,  @Nullable View convertView,  @NonNull ViewGroup parent) {
        convertView=LayoutInflater.from(context).inflate(R.layout.gaigoiform,parent,false);
        //anh xa
        TextView posittion= (TextView)convertView. findViewById(R.id.positton);
        ImageView img_genral= (ImageView)convertView. findViewById(R.id.image_genaral);
        TextView tv_name= (TextView)convertView .findViewById(R.id.tv_ten);
        TextView tv_age= (TextView) convertView.findViewById(R.id.tv_tuoi);
        ImageView img_country= (ImageView)convertView. findViewById(R.id.img_country);
        //set
        Gaigoi gg= objects.get(position);
        posittion.setText(""+(position+1));
        if (gg.isMale()){
            img_genral.setImageResource(R.drawable.traigoi);
        }else img_genral.setImageResource(R.drawable.gaigoi);
        tv_name.setText(gg.getTen());

        tv_age.setText(String.valueOf(gg.getTuoi()));
        img_country.setImageResource(gg.getImg_country());
        return convertView;
    }
}
