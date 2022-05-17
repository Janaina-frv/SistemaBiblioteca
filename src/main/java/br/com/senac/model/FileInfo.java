package br.com.senac.model;

public class FileInfo {
	
	private String nome;
	private String url;
	
	public FileInfo(String nome, String url) {
		this.nome = nome;
		this.url = url;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

}
