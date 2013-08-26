package model;

import java.util.ArrayList;

public class Comentario {
    private int id;
    private String comentario;

    private Comentario resposta;


    public Comentario(int id, String comentario) {
        this.id = id;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Comentario getResposta() {
        return resposta;
    }

    public void setResposta(Comentario resposta) {
        this.resposta = resposta;
    }
}
