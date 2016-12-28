package com.example.rogerpaviani.meuapp42;

import android.app.Activity;
import android.graphics.Color;
import android.text.Layout;
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

public class PessoaAdapter extends BaseAdapter{

    private List<Pessoa> pessoaList;
    private Activity activity;

    public PessoaAdapter(List<Pessoa> pessoaList, Activity activity) {
        this.pessoaList = pessoaList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return this.pessoaList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.pessoaList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
        View viewItem = layoutInflater.inflate(R.layout.list_pessoa, viewGroup, false);

        TextView textNome = (TextView) viewItem.findViewById(R.id.txt_nome);
        TextView textGenero = (TextView) viewItem.findViewById(R.id.txt_genero);
        TextView textSangue = (TextView) viewItem.findViewById(R.id.txt_sangue);

        Pessoa pessoa = this.pessoaList.get(i);

        textNome.setText(pessoa.Nome);
        textGenero.setText(pessoa.Genero);
        textSangue.setText(pessoa.TipoSanguineo);

        if (pessoa.isDoador == false)
        {
            viewItem.setVisibility(View.GONE);
            //viewItem.getParent().
        }

        if (pessoa.Genero == Pessoa.HOMEM)
        {
            viewItem.setBackgroundColor(Color.parseColor("fuchsia"));
        }
        else {
            viewItem.setBackgroundColor(Color.parseColor("blue"));
        }

        return viewItem;
    }
}
