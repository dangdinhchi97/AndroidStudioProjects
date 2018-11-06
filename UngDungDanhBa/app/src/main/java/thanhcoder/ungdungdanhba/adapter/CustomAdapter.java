package thanhcoder.ungdungdanhba.adapter;

import android.content.Context;
import android.graphics.Color;
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

import thanhcoder.ungdungdanhba.R;
import thanhcoder.ungdungdanhba.model.Contact;

public class CustomAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private int resource;
    private List<Contact>arrcontact;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrcontact=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.itemcontext,parent,false);
            viewHolder.imgAvatar= (ImageView) convertView.findViewById(R.id.img_avatar);
            viewHolder.tvName= (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tvNumber= (TextView) convertView.findViewById(R.id.tv_number);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        Contact contact=arrcontact.get(position);
        viewHolder.tvName.setText(contact.getmName());
        viewHolder.tvNumber.setText(contact.getmNumber());

        if(contact.isMale()){
            viewHolder  .imgAvatar.setBackgroundResource(R.drawable.nam);
        }else {
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.nu                        );
        }

        return convertView;
    }
    public class  ViewHolder{
        ImageView imgAvatar;
        TextView tvName;
        TextView tvNumber;
    }
}
