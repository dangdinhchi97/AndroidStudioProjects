package g.acedemy.baitap6;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TaikhoanAdapter extends ArrayAdapter<Taikhoan> {
    private Context context;
    private int resource;
    private ArrayList<Taikhoan> object;
    public TaikhoanAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Taikhoan> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.object=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.nguoidung,parent,false);
        TextView tvusername= (TextView) convertView.findViewById(R.id.tvusername);
        TextView tvpassword= (TextView) convertView.findViewById(R.id.tvpassword);
        tvusername.setText(object.get(position).getUsernam());
        tvpassword.setText(object.get(position).getPassword());

        return convertView;
    }
}
