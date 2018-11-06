package g.acedemy.themxoasualistview;

import android.content.Context;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class sanphamAdapter extends ArrayAdapter<SanPHam> {
    Context context;
    int resource;
    ArrayList<SanPHam> objects;
    public sanphamAdapter(@NonNull Context context, int resource, @NonNull ArrayList<SanPHam> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }


    @NonNull
    @Override
    public View getView(int position,  @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView=LayoutInflater.from(context).inflate(R.layout.sanpham_layout,parent,false);
        TextView tv_ma= (TextView) convertView.findViewById(R.id.tvma);
        TextView tv_ten= (TextView) convertView.findViewById(R.id.tvten);
        TextView tv_sx= (TextView) convertView.findViewById(R.id.tvsx);

       tv_ma.setBackgroundColor(objects.get(position).getColor());
       tv_ma.setText((position+1)+"");
        tv_ten.setText(objects.get(position).getTenSp());
        tv_sx.setText(objects.get(position).getSxSp());
        return convertView;
    }
}
