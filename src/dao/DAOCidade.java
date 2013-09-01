package dao;

import model.Cidade;

import java.util.List;

public class DAOCidade extends DAOJPA<Cidade> {
    public DAOCidade() {
        super();
    }

    public List<Cidade> buscaPorEstado(String estado) {
        return super.findByField("estado", estado);
    }
    public Cidade buscaPorNome(String nome) {
        return super.findByField("estado", nome).get(0);
    }
}
