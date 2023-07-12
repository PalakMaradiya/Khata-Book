package com.example.khatabook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.khatabook.R;

import java.util.ArrayList;

public class Adapter extends BaseAdapter
{

    String name[];
    Context context ;
    ArrayList list ;
    Adapter(Context context , ArrayList list)
    {

        this.context = context;
        this.list =list;

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_file_,null);
        TextView txtCategories = v.findViewById(R.id.txtCategories);
        txtCategories.setText(name[i]);

        return v;
    }
}
