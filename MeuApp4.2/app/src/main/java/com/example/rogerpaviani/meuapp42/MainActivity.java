package com.example.rogerpaviani.meuapp42;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listview_item);

        List<Pessoa> pessoaList = new ArrayList<Pessoa>();
        pessoaList.add(new Pessoa(false, Pessoa.MULHER, "A", "Amanda"));
        pessoaList.add(new Pessoa(true, Pessoa.MULHER, "B", "Bianca"));
        pessoaList.add(new Pessoa(true, Pessoa.MULHER, "A", "Caroline"));
        pessoaList.add(new Pessoa(false, Pessoa.MULHER, "O", "Didi"));
        pessoaList.add(new Pessoa(true, Pessoa.MULHER, "O", "Elen"));
        pessoaList.add(new Pessoa(true, Pessoa.MULHER, "B", "Fabi"));

        pessoaList.add(new Pessoa(true, Pessoa.HOMEM, "A", "Antonio"));
        pessoaList.add(new Pessoa(true, Pessoa.HOMEM, "B", "Beto"));
        pessoaList.add(new Pessoa(false, Pessoa.HOMEM, "A", "Carlos"));
        pessoaList.add(new Pessoa(true, Pessoa.HOMEM, "0", "Dudu"));
        pessoaList.add(new Pessoa(true, Pessoa.HOMEM, "0", "Edu"));
        pessoaList.add(new Pessoa(false, Pessoa.HOMEM, "0", "Flavio"));

        //pessoaList.sor

        PessoaAdapter pessoaAdapter = new PessoaAdapter(pessoaList, this);
        listView.setAdapter(pessoaAdapter);
    }
}
