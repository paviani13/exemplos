package com.example.rogerpaviani.aula41;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roger.paviani on 12/12/2016.
 */

public class NameAdapter extends BaseAdapter {

    private List<String> nameList;
    private Activity activity;

    public NameAdapter(List<String> nameList, Activity activity) {
        this.nameList = nameList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return this.nameList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.nameList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
        View viewItem = layoutInflater.inflate(R.layout.list_item, parent, false);

        viewItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.w("app.4.1", "row item LOOOOOONNNNNG clicked!");
                return false;
            }
        });

        TextView nameItem = (TextView) viewItem.findViewById(R.id.textname);
        if (i % 2 == 0) {
            nameItem.setTextColor(Color.parseColor("#336699"));
        }
        else{
            nameItem.setTextColor(Color.parseColor("#660066"));
        }

        String currentName = String.format("%02d", i+1) + " - " + this.nameList.get(i);

        nameItem.setText(currentName);

        return viewItem;
    }
}
