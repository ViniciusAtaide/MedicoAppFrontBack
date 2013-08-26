package model;


import java.util.ArrayList;

public class Medico {

    private int id;
    private String nome;
    private ArrayList<Consulta> consultas = new ArrayList<Consulta>();
    private ArrayList<Cidade> cidades = new ArrayList<Cidade>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Medico(String nome) {
        this.nome = nome;
    }
    public Medico() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }
}
