package cn.edu.gdmec.android.mobileguard.m3communicationguard.adapter;

/**
 * Created by asus on 2017/11/5.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.edu.gdmec.android.mobileguard.R;
import cn.edu.gdmec.android.mobileguard.m2theftguard.entity.ContactInfo;

/**
 * Created by Dell on 2017/10/20.
 */

public class ContactAdapter extends BaseAdapter {
    private List<ContactInfo> contactInfos;
    private Context context;
    public ContactAdapter(List<ContactInfo> contactInfos, Context context){
        super();
        this.contactInfos = contactInfos;
        this.context = context;
    }
    @Override
    public int getCount(){
        return contactInfos.size();
    }
    @Override
    public Object getItem(int i){
        return contactInfos.get(i);

    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        ViewHolder holder = null;
        if (view == null){
            view = View.inflate(context,R.layout.item_list_contact_select,null);
            holder = new ViewHolder();
            holder.mNameTV = (TextView) view.findViewById(R.id.tv_name);
            holder.mPhoneTV = (TextView) view.findViewById(R.id.tv_phone);
            holder.mContactImgv = view.findViewById(R.id.view1);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.mNameTV.setText(contactInfos.get(i).name);
        holder.mPhoneTV.setText(contactInfos.get(i).phone);
        holder.mNameTV.setTextColor(context.getResources().getColor(R.color.bright_purple));
        holder.mPhoneTV.setTextColor(context.getResources().getColor(R.color.bright_purple));
        holder.mContactImgv.setBackgroundResource(R.drawable.brightpurple_contact_icon);
        return view;
    }
    static class ViewHolder{
        TextView mNameTV;
        TextView mPhoneTV;
        View mContactImgv;
    }

}
