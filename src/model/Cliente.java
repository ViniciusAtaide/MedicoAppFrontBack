package model;

public class Cliente {

    private int id;

    private String nome;
    private String login;
    private String email;
    private String senha;
    private String CPF;
    private String plano;
    private Consulta consulta;




    public Cliente(int id, String nome, String plano, Consulta consulta) {
        this.id = id;
        this.nome = nome;
        this.plano = plano;
        this.consulta = consulta;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
