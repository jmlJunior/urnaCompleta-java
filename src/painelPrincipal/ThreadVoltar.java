package painelPrincipal;


import java.lang.Thread;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ThreadVoltar extends Thread {
	
    JLabel candidato = painelPrimario.candidato;
    JLabel vcand = painelPrimario.vcand;
    JLabel choice = painelPrimario.choice;
    JLabel partido = painelPrimario.partido;
    JLabel confirmacao = painelPrimario.confirmacao;
    JEditorPane infoNumero = painelPrimario.infoNumero;
    JPasswordField passwordField = painelPrimario.passwordField;
    JTabbedPane tabbedPane = painelPrimario.tabbedPane;
    JTextField dezena = painelPrimario.dezena;
    JTextField unidade = painelPrimario.unidade;
	
    public String name;
    public int tempo;

    public ThreadVoltar(String name, int tempo) {
	this.name = name;
	this.tempo = tempo;
		
    }
	
    public void run() {
	    try {	        	
            Thread.sleep(tempo);	    		   
            tabbedPane.setEnabledAt(1, false);
            tabbedPane.setSelectedIndex(0);
            infoNumero.setText("");
            passwordField.setText("");
            infoNumero.requestFocus();
            candidato.setText("");
            vcand.setText("");
            choice.setText("");
            partido.setText("");
            confirmacao.setText("");
            dezena.setEditable(true);
            unidade.setEditable(true);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
