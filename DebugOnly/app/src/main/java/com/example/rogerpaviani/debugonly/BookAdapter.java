package com.example.rogerpaviani.debugonly;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by roger.paviani on 19/12/2016.
 */

public class BookAdapter extends BaseAdapter
{
    private List<Book> books;
    private Activity activity;

    public BookAdapter(List<Book> books, Activity activity) {
        this.books = books;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return this.books.size();
    }

    @Override
    public Object getItem(int i) {
        return this.books.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
        View viewItem = layoutInflater.inflate(R.layout.lst_item, viewGroup, false);

        viewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity.getApplicationContext(), "Editando item...", Toast.LENGTH_SHORT).show();
                if (activity instanceof OnItemClickedListener)
                {
                    ((OnItemClickedListener) activity).OnItemClicked((Book) getItem(i));
                }
            }
        });

        TextView nameItem = (TextView) viewItem.findViewById(R.id.txt_item);
        if (i % 2 == 0) {
            nameItem.setTextColor(Color.parseColor("#336699"));
        }
        else{
            nameItem.setTextColor(Color.parseColor("#660066"));
        }

        String currentName = String.format("%02d", i+1) + " - " + this.books.get(i).Name;
        nameItem.setText(currentName);

        return viewItem;
    }

    public interface OnItemClickedListener {
        public void OnItemClicked(Book i);
    }
}
