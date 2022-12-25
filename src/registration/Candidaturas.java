package registration;

import java.util.Scanner;
import entities.Candidato;
//import painel.PainelDeVotacao;

public class Candidaturas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
						
		int escolher = sc.nextInt();
		
		if (escolher == 22) {
		String nome = "Jair Bolsonaro";
		String partido = "PL";
		int numero = 22;
		int nVotos = 0;
		Candidato escolha = new Candidato(nome, partido, numero, nVotos);
		System.out.println(escolha + nome + partido + numero + nVotos);
		
		} else if (escolher == 13) {
			String nome = "Lula";
			String partido = "PT";
			int numero = 13;
			int nVotos = 0;
			Candidato escolha = new Candidato(nome, partido, numero, nVotos);
			System.out.println(escolha + nome + partido + numero + nVotos);
			
		} else if (escolher == 12) {
			String nome = "Ciro Gomes";
			String partido = "PDT";
			int numero = 12;
			int nVotos = 0;
			Candidato escolha = new Candidato(nome, partido, numero, nVotos);
			System.out.println(escolha + nome + partido + numero + nVotos);
			
		} else if (escolher == 15) {
			String nome = "Simone Tebet";
			String partido = "MDB";
			int numero = 15;
			int nVotos = 0;
			Candidato escolha = new Candidato(nome, partido, numero, nVotos);
			System.out.println(escolha + nome + partido + numero + nVotos);
			
		} else if (escolher == 30) {
				String nome = "Felipe d’Avila";
				String partido = "NOVO";
				int numero = 30;
				int nVotos = 0;
				Candidato escolha = new Candidato(nome, partido, numero, nVotos);
				System.out.println(escolha + nome + partido + numero + nVotos);
				
		} else if (escolher == 14) {
			String nome = "Roberto Jefferson";
			String partido = "PTB";
			int numero = 14;
			int nVotos = 0;
			Candidato escolha = new Candidato(nome, partido, numero, nVotos);
			System.out.println(escolha + nome + partido + numero + nVotos);
				
		}
		sc.close();
	}
}