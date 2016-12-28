package com.example.rogerpaviani.meuapp42;

/**
 * Created by roger.paviani on 12/12/2016.
 */
public class Pessoa {

    final static String HOMEM = "M";
    final static String MULHER = "F";

    public boolean isDoador;

    public String Genero;

    public String TipoSanguineo;

    public String Nome;

    public Pessoa(boolean isDoador, String genero, String tipoSanguineo, String nome) {
        this.isDoador = isDoador;
        this.Genero = genero;
        this.TipoSanguineo = tipoSanguineo;
        this.Nome = nome;
    }
}
