package dao;

import model.Usuario;

public class DAOUsuario extends DAOJPA<Usuario> {
	public DAOUsuario() {
		super();
	}

	public Usuario buscaPorLoginSenha(String login, String senha) {
		Usuario u = super.findByField("login", login).get(0);
		
		if (u.getSenha().equals(senha)) { 
			return u;
		}
		return null;
	}
}
