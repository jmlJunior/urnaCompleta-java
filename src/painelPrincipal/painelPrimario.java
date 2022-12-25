package painelPrincipal;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

public class painelPrimario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField dezena;
	public static JTextField unidade;
	
	public static JLabel candidato;
	public static JLabel vice;
	public static JLabel vcand;
	public static JLabel choice;
	public static JLabel partido;
	public static JLabel confirmacao;
	
	public static JPanel panelMesario;
	public static JPanel panelVotacao;
	
	public static JTabbedPane tabbedPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					painelPrimario frame = new painelPrimario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static String dn, un, dnun;
	public static int voto, confirm, blanck, ciroGomes, Lula, robertoJefferson, simoneTebet, Vera, sofiaManzano,
			          jairBolsonaro, Eymael, Davila, sorayaThronicke, leoPericles, pabloMarcal, votoNulo;

	public static JEditorPane infoNumero;
	public static String[] titulo = new String[14];
	public static JPasswordField passwordField;

	// Create the frame.
	public painelPrimario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 676, 371);
		contentPane.add(tabbedPane);

		panelMesario = new JPanel();
		tabbedPane.addTab("Tela do Mesário", null, panelMesario, null);
		panelMesario.setLayout(null);

		infoNumero = new JEditorPane();
		infoNumero.setBounds(43, 58, 204, 20);
		panelMesario.add(infoNumero);
		infoNumero.requestFocus();

		JLabel justicaEleitoralpM = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Justiça Eleitoral - Brasão.jpg")).getImage()
				                                 .getScaledInstance(230, 245, Image.SCALE_SMOOTH);
		justicaEleitoralpM.setIcon(new ImageIcon(img));
		justicaEleitoralpM.setBounds(420, 21, 230, 245);
		panelMesario.add(justicaEleitoralpM);

		JButton btnLimpar = new JButton("CORRIGE");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoNumero.setText("");
				passwordField.setText("");
				infoNumero.requestFocus();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnLimpar.setBackground(Color.ORANGE);
		btnLimpar.setBounds(443, 288, 94, 36);
		panelMesario.add(btnLimpar);

		JLabel lblNewLabel = new JLabel("N\u00FAmero do T\u00EDtulo de Eleitor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(43, 33, 187, 14);
		panelMesario.add(lblNewLabel);

		JLabel Senha = new JLabel("SENHA do MES\u00C1RIO - Liberar Vota\u00E7\u00E3o");
		Senha.setFont(new Font("Tahoma", Font.BOLD, 12));
		Senha.setBounds(43, 120, 240, 14);
		panelMesario.add(Senha);

		passwordField = new JPasswordField();
		passwordField.setBounds(43, 145, 204, 20);
		panelMesario.add(passwordField);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.setBounds(24, 21, 371, 245);
		panelMesario.add(panel_2);

		panelVotacao = new JPanel();
		tabbedPane.addTab("Painel de Votação", null, panelVotacao, null);
		panelVotacao.setLayout(null);

		tabbedPane.setEnabledAt(1, false);

		JButton btnEntrar = new JButton("CONFIRMA");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = new String(passwordField.getPassword());
				if (!senha.equals("123")) {
					JOptionPane.showMessageDialog(null, "SENHA INCORRETA!");
					passwordField.setText("");
					passwordField.requestFocus();
				}
				if (infoNumero.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo TÍTULO DE ELEITOR deve ser preenchido!");
				}
				if (!infoNumero.getText().equals("") && senha.equals("123")) {
					tabbedPane.setEnabledAt(1, true);
					tabbedPane.setSelectedIndex(1);
					dn = "";
					dezena.requestFocus();
				}
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEntrar.setBackground(Color.GREEN);
		btnEntrar.setBounds(544, 279, 93, 45);
		panelMesario.add(btnEntrar);
		
		JButton btnResulado = new JButton("PRINT");
		btnResulado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = new String(passwordField.getPassword());
				if (!senha.equals("123")) {
					JOptionPane.showMessageDialog(null, "SENHA INCORRETA!");
					passwordField.setText("");
					passwordField.requestFocus();
				}
				if (senha.equals("123")) {
				    RegistroDeVotacao.contVotos();
				    
				    FileWriter arq;
					try {
						arq = new FileWriter("D:\\RESULTADOS.txt");
						PrintWriter gravarArq = new PrintWriter(arq);
						
						gravarArq.println(
								"Total de Votos: " + confirm
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
						
						JOptionPane.showMessageDialog(null, "Resultado de Urna gerado com sucesso no Diretório D:\\!!!");

						arq.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					passwordField.setText("");
				}
			}
		});
		btnResulado.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnResulado.setBackground(Color.WHITE);
		btnResulado.setBounds(347, 288, 86, 36);
		panelMesario.add(btnResulado);

		JLabel justicaEleitoral = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/Justiça Eleitoral.jpg")).getImage()
				                                  .getScaledInstance(180, 68, Image.SCALE_SMOOTH);
		justicaEleitoral.setIcon(new ImageIcon(img1));
		justicaEleitoral.setBounds(445, 33, 180, 68);
		panelVotacao.add(justicaEleitoral);

		candidato = new JLabel("");
		candidato.setFont(new Font("Arial", Font.BOLD, 65));
		candidato.setBounds(278, 21, 120, 160);
		panelVotacao.add(candidato);

		vice = new JLabel("");
		vice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		vice.setHorizontalAlignment(SwingConstants.RIGHT);
		vice.setBounds(338, 185, 60, 75);
		panelVotacao.add(vice);

		vcand = new JLabel("");
		vcand.setHorizontalAlignment(SwingConstants.RIGHT);
		vcand.setFont(new Font("Tahoma", Font.PLAIN, 10));
		vcand.setBounds(159, 246, 169, 14);
		panelVotacao.add(vcand);

		choice = new JLabel("");
		choice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		choice.setBounds(88, 204, 310, 14);
		panelVotacao.add(choice);

		partido = new JLabel("");
		partido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		partido.setBounds(98, 228, 94, 14);
		panelVotacao.add(partido);

		confirmacao = new JLabel("");
		confirmacao.setFont(new Font("Tahoma", Font.PLAIN, 30));
		confirmacao.setBounds(108, 171, 112, 30);
		panelVotacao.add(confirmacao);

		dezena = new JTextField();
		dezena.setHorizontalAlignment(SwingConstants.CENTER);
		dezena.setFont(new Font("Tahoma", Font.PLAIN, 38));
		dezena.setColumns(10);
		dezena.setBounds(120, 105, 33, 55);
		panelVotacao.add(dezena);
		dezena.requestFocus();

		unidade = new JTextField();
		unidade.setHorizontalAlignment(SwingConstants.CENTER);
		unidade.setFont(new Font("Tahoma", Font.PLAIN, 38));
		unidade.setColumns(10);
		unidade.setBounds(155, 105, 33, 55);
		panelVotacao.add(unidade);	

		JButton btnN11 = new JButton("1");
		btnN11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dezena.getText().equals("")) {
					dezena.setText("1");
					unidade.requestFocus();
					unidade.setText("");
					dn = "1";
				}
			}
		});
		btnN11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (unidade.getText().equals("")) {
					unidade.setText("1");
					un = "1";

					if ((dn.equals("2")) && (un.equals("1"))) {
						Image img21 = new ImageIcon(this.getClass().getResource("/21.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidato.setIcon(new ImageIcon(img21));
						choice.setText("SOFIA MANZANO");
						partido.setText("PCB");
						vcand.setText("Vice: Antonio Alves");

						Image imgv21 = new ImageIcon(this.getClass().getResource("/v21.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						vice.setIcon(new ImageIcon(imgv21));
					}
				}
			}
		});
		btnN11.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnN11.setBounds(464, 123, 39, 30);
		panelVotacao.add(btnN11);

		JButton btnN12 = new JButton("2");
		btnN12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dezena.getText().equals("")) {
					dezena.setText("2");
					unidade.requestFocus();
					unidade.setText("");
					dn = "2";
				}
			}
		});
		btnN12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (unidade.getText().equals("")) {
					unidade.setText("2");
					un = "2";

					if ((dn.equals("1")) && (un.equals("2"))) {
						Image img12 = new ImageIcon(this.getClass().getResource("/12.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidato.setIcon(new ImageIcon(img12));
						choice.setText("CIRO GOMES");
						partido.setText("PDT");
						vcand.setText("Vice: Ana Paula Matos");

						Image imgv12 = new ImageIcon(this.getClass().getResource("/v12.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						vice.setIcon(new ImageIcon(imgv12));

					}

					if ((dn.equals("2")) && (un.equals("2"))) {
						Image img22 = new ImageIcon(this.getClass().getResource("/22.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidato.setIcon(new ImageIcon(img22));
						choice.setText("JAIR BOLSONARO");
						partido.setText("PL");
						vcand.setText("Vice: Braga Netto");

						Image imgv22 = new ImageIcon(this.getClass().getResource("/v22.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						vice.setIcon(new ImageIcon(imgv22));
					}
				}
			}
		});
		btnN12.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnN12.setBounds(516, 123, 39, 30);
		panelVotacao.add(btnN12);

		JButton btnN13 = new JButton("3");
		btnN13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dezena.getText().equals("")) {
					dezena.setText("3");
					unidade.requestFocus();
					unidade.setText("");
					dn = "3";
				}
			}
		});
		btnN13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (unidade.getText().equals("")) {
					unidade.setText("3");
					un = "3";

					if ((dn.equals("1")) && (un.equals("3"))) {
						Image img13 = new ImageIcon(this.getClass().getResource("/13.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidato.setIcon(new ImageIcon(img13));
						choice.setText("LULA");
						partido.setText("PT");
						vcand.setText("Vice: Geraldo Alckmin");

						Image imgv13 = new ImageIcon(this.getClass().getResource("/v13.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						vice.setIcon(new ImageIcon(imgv13));
					}
				}
			}
		});
		btnN13.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnN13.setBounds(565, 123, 39, 30);
		panelVotacao.add(btnN13);

		JButton btnN14 = new JButton("4");
		btnN14.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnN14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dezena.getText().equals("")) {
					dezena.setText("4");
					unidade.requestFocus();
					unidade.setText("");
					dn = "4";
				}
			}
		});
		btnN14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (unidade.getText().equals("")) {
					unidade.setText("4");
					un = "4";

					if ((dn.equals("1")) && (un.equals("4"))) {
						Image img14 = new ImageIcon(this.getClass().getResource("/14.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidato.setIcon(new ImageIcon(img14));
						choice.setText("ROBERTO JEFFERSON");
						partido.setText("PTB");
						vcand.setText("Vice: Padre Kelmon");

						Image imgv14 = new ImageIcon(this.getClass().getResource("/v14.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						vice.setIcon(new ImageIcon(imgv14));
					}

					if ((dn.equals("4")) && (un.equals("4"))) {
						Image img44 = new ImageIcon(this.getClass().getResource("/44.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidato.setIcon(new ImageIcon(img44));
						choice.setText("SORAYA THRONICKE");
						partido.setText("UNIÃO");
						vcand.setText("Vice: Marcos Cintra");

						Image imgv44 = new ImageIcon(this.getClass().getResource("/v44.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						vice.setIcon(new ImageIcon(imgv44));
					}
				}
			}
		});
		btnN14.setBounds(464, 164, 39, 30);
		panelVotacao.add(btnN14);

		JButton btnN15 = new JButton("5");
		btnN15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dezena.getText().equals("")) {
					dezena.setText("5");
					unidade.requestFocus();
					unidade.setText("");
					dn = "5";
				}
			}
		});
		btnN15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (unidade.getText().equals("")) {
					unidade.setText("5");
					un = "5";

					if ((dn.equals("1")) && (un.equals("5"))) {
						Image img15 = new ImageIcon(this.getClass().getResource("/15.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidato.setIcon(new ImageIcon(img15));
						choice.setText("SIMONE TEBET");
						partido.setText("MDB");
						vcand.setText("Vice: Mara Babrilli");

						Image imgv15 = new ImageIcon(this.getClass().getResource("/v15.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						vice.setIcon(new ImageIcon(imgv15));
					}
				}
			}
		});
		btnN15.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnN15.setBounds(516, 164, 39, 30);
		panelVotacao.add(btnN15);

		JButton btnN16 = new JButton("6");
		btnN16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dezena.getText().equals("")) {
					dezena.setText("6");
					unidade.requestFocus();
					unidade.setText("");
					dn = "6";
				}
			}
		});
		btnN16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (unidade.getText().equals("")) {
					unidade.setText("6");
					un = "6";

					if ((dn.equals("1")) && (un.equals("6"))) {
						Image img16 = new ImageIcon(this.getClass().getResource("/16.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidato.setIcon(new ImageIcon(img16));
						choice.setText("VERA");
						partido.setText("PSTU");
						vcand.setText("Vice: Raquel Tremenbé");

						Image imgv16 = new ImageIcon(this.getClass().getResource("/v16.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						vice.setIcon(new ImageIcon(imgv16));
					}
				}
			}
		});
		btnN16.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnN16.setBounds(565, 164, 39, 30);
		panelVotacao.add(btnN16);

		JButton btnN17 = new JButton("7");
		btnN17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dezena.getText().equals("")) {
					dezena.setText("7");
					unidade.requestFocus();
					unidade.setText("");
					dn = "7";
				}
			}
		});
		btnN17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (unidade.getText().equals("")) {
					unidade.setText("7");
					un = "7";

					if ((dn.equals("2")) && (un.equals("7"))) {
						Image img27 = new ImageIcon(this.getClass().getResource("/27.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidato.setIcon(new ImageIcon(img27));
						choice.setText("CONSTITUINTE EYMAEL");
						partido.setText("DC");
						vcand.setText("Vice: Professor Bravo");

						Image imgv27 = new ImageIcon(this.getClass().getResource("/v27.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						vice.setIcon(new ImageIcon(imgv27));
					}
				}
			}
		});
		btnN17.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnN17.setBounds(464, 205, 39, 30);
		panelVotacao.add(btnN17);

		JButton btnN18 = new JButton("8");
		btnN18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dezena.getText().equals("")) {
					dezena.setText("8");
					unidade.requestFocus();
					unidade.setText("");
					dn = "8";
				}
			}
		});
		btnN18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (unidade.getText().equals("")) {
					unidade.setText("8");
					un = "8";
				}
			}
		});
		btnN18.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnN18.setBounds(516, 205, 39, 30);
		panelVotacao.add(btnN18);

		JButton btnN19 = new JButton("9");
		btnN19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dezena.getText().equals("")) {
					dezena.setText("9");
					unidade.setText("");
					dn = "9";
				}
			}
		});
		btnN19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (unidade.getText().equals("")) {
					unidade.setText("9");
					un = "9";
				}
			}
		});
		btnN19.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnN19.setBounds(565, 205, 39, 30);
		panelVotacao.add(btnN19);

		JButton btnN10 = new JButton("0");
		btnN10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dezena.getText().equals("")) {
					dezena.setText("0");
					unidade.requestFocus();
					unidade.setText("");
					dn = "0";
				}
			}
		});
		btnN10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (unidade.getText().equals("")) {
					unidade.setText("0");
					un = "0";

					if ((dn.equals("3")) && (un.equals("0"))) {
						Image img30 = new ImageIcon(this.getClass().getResource("/30.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidato.setIcon(new ImageIcon(img30));
						choice.setText("FELIPE D'AVILA");
						partido.setText("NOVO");
						vcand.setText("Vice: Tiago Mitraud");

						Image imgv30 = new ImageIcon(this.getClass().getResource("/v30.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						vice.setIcon(new ImageIcon(imgv30));
					}

					if ((dn.equals("8")) && (un.equals("0"))) {
						Image img80 = new ImageIcon(this.getClass().getResource("/80.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidato.setIcon(new ImageIcon(img80));
						choice.setText("LÉO PÉRICLES");
						partido.setText("UP");
						vcand.setText("Vice: Samara Martins");

						Image imgv80 = new ImageIcon(this.getClass().getResource("/v80.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						vice.setIcon(new ImageIcon(imgv80));
					}

					if ((dn.equals("9")) && (un.equals("0"))) {
						Image img90 = new ImageIcon(this.getClass().getResource("/90.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidato.setIcon(new ImageIcon(img90));
						choice.setText("PABLO MARÇAL");
						partido.setText("PROS");
						vcand.setText("Vice: Fátima Pérola Neggra");

						Image imgv90 = new ImageIcon(this.getClass().getResource("/v90.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						vice.setIcon(new ImageIcon(imgv90));
					}
				}
			}
		});

		btnN10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnN10.setBounds(516, 246, 39, 30);
		panelVotacao.add(btnN10);
	
		JButton btnCorrige = new JButton("CORRIGE");
		btnCorrige.setBackground(Color.ORANGE);
		btnCorrige.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!candidato.getText().equals("FIM")) {
				    Image img = new ImageIcon(this.getClass().getResource("")).getImage()
				    		                                 .getScaledInstance(120, 160,Image.SCALE_SMOOTH);
				    dezena.setText("");
				    unidade.setText("");
				    dn = "";
				    un = "";
				    candidato.setIcon(new ImageIcon(img));
				    vice.setIcon(new ImageIcon(img));
				    candidato.setText("");
				    vcand.setText("");
				    choice.setText("");
				    partido.setText("");
				    confirmacao.setText("");
				    dezena.requestFocus();
				}
			}
		});
		btnCorrige.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCorrige.setBounds(463, 299, 94, 36);
		panelVotacao.add(btnCorrige);

		JButton btnBranco = new JButton("BRANCO");
		btnBranco.setBackground(Color.WHITE);
		btnBranco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!candidato.getText().equals("FIM")) {
					blanck++;
				    confirm++;
				    RegistroDeVotacao.contVotos();
				
				    ThreadLimpar limpar = new ThreadLimpar("Limpar");
				    limpar.start();
				
				    ThreadVoltar voltar = new ThreadVoltar("Voltar", 7000);
				    voltar.start();
				}
		    }			
		});
		btnBranco.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBranco.setBounds(367, 299, 86, 36);
		panelVotacao.add(btnBranco);

		JButton btnConfirma = new JButton("CONFIRMA");
		btnConfirma.setBackground(Color.GREEN);
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if ((!dezena.getText().equals("")) && (!unidade.getText().equals(""))) {			
					dnun = (dn + un);
					voto = Integer.parseInt(dnun);
					confirm++;
					
				    switch (voto) {
					    case 12: ciroGomes++; break;
					    case 13: Lula++; break;
					    case 14: robertoJefferson++; break;
					    case 15: simoneTebet++; break;
					    case 16: Vera++; break;
					    case 21: sofiaManzano++; break;
					    case 22: jairBolsonaro++; break;
					    case 27: Eymael++; break;
					    case 30: Davila++; break;
					    case 44: sorayaThronicke++; break;
					    case 80: leoPericles++; break;
					    case 90: pabloMarcal++; break;
					    default: votoNulo++; break;
				    }
				    
					ThreadLimpar limpar = new ThreadLimpar("Limpar");
					limpar.start();
				    
                    RegistroDeVotacao.contVotos();
    		    }
				
				ThreadVoltar voltar = new ThreadVoltar("Voltar", 7000);
				voltar.start();
			}
		});

		btnConfirma.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnConfirma.setBounds(567, 290, 93, 45);
		panelVotacao.add(btnConfirma);

		JLabel head = new JLabel("SEU VOTO PARA");
		head.setFont(new Font("Tahoma", Font.BOLD, 12));
		head.setBounds(43, 33, 100, 14);
		panelVotacao.add(head);

		JLabel cargo = new JLabel("PRESIDENTE");
		cargo.setFont(new Font("Calibri", Font.BOLD, 22));
		cargo.setBounds(100, 79, 120, 23);
		panelVotacao.add(cargo);

		JLabel number = new JLabel("N\u00FAmero:");
		number.setFont(new Font("Tahoma", Font.BOLD, 10));
		number.setBounds(43, 123, 46, 14);
		panelVotacao.add(number);

		JLabel name = new JLabel("Nome:");
		name.setFont(new Font("Tahoma", Font.BOLD, 12));
		name.setBounds(43, 205, 46, 14);
		panelVotacao.add(name);

		JLabel group = new JLabel("Partido:");
		group.setFont(new Font("Tahoma", Font.BOLD, 12));
		group.setBounds(43, 230, 60, 14);
		panelVotacao.add(group);

		JLabel instrucao = new JLabel("Aperte a tecla");
		instrucao.setBounds(30, 290, 298, 14);
		panelVotacao.add(instrucao);

		JLabel verde = new JLabel("VERDE para CONFIRMAR");
		verde.setBounds(30, 305, 298, 14);
		panelVotacao.add(verde);

		JLabel laranja = new JLabel("LARANJA para CORRIGIR");
		laranja.setBounds(30, 321, 298, 14);
		panelVotacao.add(laranja);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBounds(10, 11, 401, 265);
		panelVotacao.add(panel_1);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(23, 11, 398, 259);
	}
}