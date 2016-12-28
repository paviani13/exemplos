package com.example.rogerpaviani.debugonly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BookAdapter.OnItemClickedListener {

    private ListView listView;
    private LinearLayout linearForm;
    private List<Book> bookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookList = new ArrayList<Book>();
        bookList.add(new Book("Pai Rico, Pai Pobre", "1234"));
        bookList.add(new Book("Segredos da Mente Milionária", "2345"));
        bookList.add(new Book("Startup Enxuta", "3456"));
        bookList.add(new Book("O poder do hábito", "4567"));
        bookList.add(new Book("EU S/A", "5678"));

        linearForm = (LinearLayout) findViewById(R.id.linear_form);
        listView = (ListView) findViewById(R.id.lst_items);

        BookAdapter bookAdapter = new BookAdapter(bookList, this);

        listView.setAdapter(bookAdapter);
        listView.setVisibility(View.VISIBLE);
        linearForm.setVisibility(View.GONE);
    }

    @Override
    public void OnItemClicked(Book book) {
        AbreEdicao(book);
    }

    private void AbreEdicao(Book book)
    {
        listView.setVisibility(View.GONE);
        linearForm.setVisibility(View.VISIBLE);

        //
    }
}
