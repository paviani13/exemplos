package com.example.rogerpaviani.aula41;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> nameList = new ArrayList<String>();
        nameList.add("Bill Gates");
        nameList.add("Amancio Ortega");
        nameList.add("Warren Buffet");
        nameList.add("Carlos Slim Helu");
        nameList.add("Jeff Bezos");
        nameList.add("Mark Zuckerberg");
        nameList.add("Larry Ellison");
        nameList.add("Michael Bloomberg");
        nameList.add("Charles Koch");
        nameList.add("David Koch");
        nameList.add("Liliane Bittencout");
        nameList.add("Larry Page");
        nameList.add("Sergey Brin");
        nameList.add("Bernard Arnault");
        nameList.add("Jim Walton");
        nameList.add("Alice Walton");
        nameList.add("S. Robson Walton");
        nameList.add("Wang Jianlin");
        nameList.add("Jorge Paulo Lemann");
        nameList.add("Li Ka-shing");

        ListView listView = (ListView) findViewById(R.id.lst_names_list_view);

        if (false) {
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(
                    this,
                    R.layout.list_item,
                    nameList
            );

            listView.setAdapter(stringArrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Log.e("App.4.1", "Clicado no item: " + nameList.get(i));
                }
            });
        }
        else{
            NameAdapter nameAdapter = new NameAdapter(nameList, this);

            listView.setAdapter(nameAdapter);
        }
    }
}
