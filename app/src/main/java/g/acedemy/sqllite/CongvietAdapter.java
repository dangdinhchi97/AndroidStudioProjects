package g.acedemy.sqllite;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CongvietAdapter extends ArrayAdapter<CongViec> {
    private MainActivity context;
    private int resource;
    private List<CongViec> objects;
    public CongvietAdapter( MainActivity context, int resource,  List<CongViec> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

   public class Viewholder{
        TextView tvtencv;
        ImageView imgx;
        ImageView imgedit;
   }
    @NonNull
    @Override
    public View getView(int position,  @Nullable View convertView, @NonNull ViewGroup parent) {
        Viewholder viewholder;
        if (convertView==null){
            viewholder=new Viewholder();
            convertView=LayoutInflater.from(context).inflate(R.layout.congviecform,parent,false);
            viewholder.tvtencv= (TextView)convertView. findViewById(R.id.tvtencv);
            viewholder.imgx= (ImageView) convertView.findViewById(R.id.imgx);
            viewholder.imgedit= (ImageView)convertView. findViewById(R.id.imgedit);
            convertView.setTag(viewholder);
        }
        else {
            viewholder= (Viewholder) convertView.getTag();
        }
        final  CongViec cv=objects.get(position);
        viewholder.tvtencv.setText(cv.getTencV());
        //bat su kien cho Update va Delete
        viewholder.imgedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogSuacongviec(cv.getID(),cv.getTencV());
            }
        });
        viewholder.imgx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogXoaCongviec(cv.getID(),cv.getTencV());
            }
        });
        return convertView;
    }
}
