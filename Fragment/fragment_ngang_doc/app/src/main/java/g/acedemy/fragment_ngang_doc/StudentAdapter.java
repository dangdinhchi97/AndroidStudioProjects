package g.acedemy.fragment_ngang_doc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<SinhVien> {
    private Context context;
    private int resource;
    private List <SinhVien>objects;
    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<SinhVien> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }
public class ViewHolder{
        TextView tvten;
}

    @NonNull
    @Override
    public View getView(int position,  @Nullable View convertView,  @NonNull ViewGroup parent) {
       ViewHolder viewHolder;
       if (convertView==null){
           convertView=LayoutInflater.from(context).inflate(R.layout.rowstudent,parent,false);
           viewHolder=new ViewHolder();
           viewHolder.tvten= (TextView)convertView. findViewById(R.id.tvrowtensv);
           convertView.setTag(viewHolder);



       }else {
           viewHolder= (ViewHolder)convertView.getTag();
       }
       SinhVien sv=objects.get(position);
       viewHolder.tvten.setText(sv.getHoTen());
        return convertView;
    }
}
