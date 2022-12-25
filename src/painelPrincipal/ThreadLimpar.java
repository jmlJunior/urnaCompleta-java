package painelPrincipal;

import java.awt.Image;
import java.lang.Thread;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ThreadLimpar extends Thread {
	
    String dn = painelPrimario.dn;
    String un = painelPrimario.un;
    JLabel candidato = painelPrimario.candidato;
    JLabel vice = painelPrimario.vice;
    JLabel vcand = painelPrimario.vcand;
    JLabel choice = painelPrimario.choice;
    JLabel partido = painelPrimario.partido;
    JLabel confirmacao = painelPrimario.confirmacao;
    JTextField dezena = painelPrimario.dezena;
    JTextField unidade = painelPrimario.unidade;
    
	public String nome;
	
	public ThreadLimpar(String nome) {
		this.nome = nome;
	}
	
	public void run() {
	    Image img = new ImageIcon(this.getClass().getResource("")).getImage()
                                                 .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
	    candidato.setIcon(new ImageIcon(img));
	    vice.setIcon(new ImageIcon(img));
	    candidato.setText("FIM");
	    vcand.setText("");
            choice.setText("");
            partido.setText("");
            dezena.setEditable(false);
            unidade.setEditable(false);
            dezena.setText("");
            unidade.setText("");
	    dn = "";
	    un = "";
            confirmacao.setText("VOTOU");   
	}
}
