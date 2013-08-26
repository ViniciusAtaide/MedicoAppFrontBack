package model;

import java.util.ArrayList;

public class Consulta {

    private int id;
    private Medico medico;
    private Cliente cliente;
    private int result;
    private ArrayList<Comentario> comentarios = new ArrayList<Comentario>();


    public int getResult() {
        return result;
    }

    public Consulta(int id, Medico medico, Cliente cliente, int result) {
        this.id = id;
        this.medico = medico;
        this.cliente = cliente;
        this.result = result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
