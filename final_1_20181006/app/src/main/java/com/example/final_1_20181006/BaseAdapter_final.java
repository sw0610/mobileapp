package com.example.final_1_20181006;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BaseAdapter_final extends BaseAdapter {

    Context mContext = null;
    ArrayList<SiteInfo> mData=null;
    LayoutInflater mLayoutInflater = null;

    public BaseAdapter_final(Context context, ArrayList<SiteInfo> data){
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {return mData.size();}

    @Override
    public Object getItem(int position) { return mData.get(position);}

    @Override
    public long getItemId(int position){ return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemLayout = mLayoutInflater.inflate(R.layout.key_list, null);

        TextView Tv_sitename = (TextView) itemLayout.findViewById(R.id.tv_sitename);
        TextView Tv_URL = (TextView) itemLayout.findViewById(R.id.tv_URL);
        TextView Tv_username = (TextView) itemLayout.findViewById(R.id.tv_username);

        Tv_sitename.setText(mData.get(position).site_name);
        Tv_URL.setText(mData.get(position).URL);
        Tv_username.setText(mData.get(position).user_account);

        return itemLayout;

    }

    public void add(int index, SiteInfo addData){
        mData.add(index, addData);
        notifyDataSetChanged();
    }

    public void delete(int index){
        mData.remove(index);
        notifyDataSetChanged();
    }

    public void edit(int index, SiteInfo data){
        mData.remove(index);
        mData.add(index, data);
        notifyDataSetChanged();
    }
}
