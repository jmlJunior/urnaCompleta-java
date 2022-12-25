package painelPrincipal;

public class RegistroDeVotacao {
	
	public static void contVotos() {
		
		int 
		    ciroGomes = painelPrimario.ciroGomes,
		    Lula = painelPrimario.Lula,
            robertoJefferson = painelPrimario.robertoJefferson,
            simoneTebet = painelPrimario.simoneTebet,
            Vera = painelPrimario.Vera,
            sofiaManzano = painelPrimario.sofiaManzano,
            jairBolsonaro = painelPrimario.jairBolsonaro,
            Eymael = painelPrimario.Eymael,
            Davila = painelPrimario.Davila,
            sorayaThronicke = painelPrimario.sorayaThronicke,
            leoPericles = painelPrimario.leoPericles,
            pabloMarcal = painelPrimario.pabloMarcal,
            votoNulo = painelPrimario.votoNulo,
		    blanck = painelPrimario.blanck,
	        nVotos = painelPrimario.confirm;
		
		System.out.println(
				"Total de Votos: " + nVotos
				+ "\n12 - CIRO GOMES (PDT) = " + ciroGomes
				+ "\n13 - LULA (PT) = " + Lula
				+ "\n14 - ROBERTO JEFFERSON (PTB) = " + robertoJefferson
				+ "\n15 - SIMONE TEBET (MDB) = " + simoneTebet
				+ "\n16 - VERA (PSTU) = " + Vera
				+ "\n21 - SOFIA MANZANO (PCB) = " + sofiaManzano
				+ "\n22 - JAIR BOLSONARO (PL) = " + jairBolsonaro
				+ "\n27 - CONSTITUINTE EYMAEL (DC) = " + Eymael
				+ "\n30 - FELIPE D'AVILA (NOVO) = " + Davila
				+ "\n44 - SORAYA THRONICKE (UNIÃO) = " + sorayaThronicke
				+ "\n80 - LÉO PÉRICLES (UP) = " + leoPericles
				+ "\n90 - PABLO MARÇAL (PROS) = " + pabloMarcal
				+ "\nVotos BRANCOS = " + blanck
				+ "\nVotos NULOS = " + votoNulo
				+ "\n\n"
				);

	}

	public static void main(String[] args) {
		
	}
}