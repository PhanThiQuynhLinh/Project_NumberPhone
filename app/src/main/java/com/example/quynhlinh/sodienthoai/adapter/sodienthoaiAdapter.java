package com.example.quynhlinh.sodienthoai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quynhlinh.sodienthoai.R;
import com.example.quynhlinh.sodienthoai.model.sodienthoai;

import java.util.ArrayList;

/**
 * Created by QuynhLinh on 3/12/2018.
 */

public class sodienthoaiAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<sodienthoai> arrayList;

    public sodienthoaiAdapter(Context context, int layout, ArrayList<sodienthoai> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class Viewholder{
        TextView txtten,txtsdt;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewholder viewholder;
        if(view==null){
            viewholder=new Viewholder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            viewholder.txtsdt=(TextView) view.findViewById(R.id.txtsdt);
            viewholder.txtten=(TextView) view.findViewById(R.id.txtten);
            view.setTag(viewholder);
        }else {
            viewholder= (Viewholder) view.getTag();
        }
        sodienthoai sdt=arrayList.get(i);
        viewholder.txtten.setText(sdt.getTen());
        viewholder.txtsdt.setText(sdt.getSdt());
        return view;
    }
}
