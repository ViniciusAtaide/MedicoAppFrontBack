package model;

public class Endereco {
	private int id;
	private String logradouro;
	private String tipologradouro;
	private String bairro;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getTipologradouro() {
		return tipologradouro;
	}
	public void setTipologradouro(String tipologradouro) {
		this.tipologradouro = tipologradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Endereco(int id, String logradouro, String tipologradouro,
			String bairro) {	
		this.id = id;
		this.logradouro = logradouro;
		this.tipologradouro = tipologradouro;
		this.bairro = bairro;
	}
	
	
}