package entities;

public class Candidato {
	
	private String nome, partido;
	private int numero, nVotos;
	
	public Candidato() {
	}
	
	public Candidato (String nome, String partido, int numero, int nVotos) {
		this.nome = nome;
		this.partido = partido;
		this.numero = numero;
		this.nVotos = nVotos;
	}
	
	public void addVoto(int nVoto) {
		this.nVotos += nVoto;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPartido() {
		return partido;
	}
	
	public void setPartido(String partido) {
		this.partido = partido;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getResVotos() {
		return nVotos;
	}
}
