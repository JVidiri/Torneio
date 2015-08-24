package edu.ifsp.hto.poo.torneio.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ifsp.hto.poo.torneio.GerenciadorTorneio;
import edu.ifsp.hto.poo.torneio.Jogador;

public class TelaPrincipal {

	private JFrame frame;
	private GerenciadorTorneio gerenTorneio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		gerenTorneio = new GerenciadorTorneio();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Toneio");
		frame.setSize(800, 600);
		JPanel mainPanel = new JPanel();
		frame.add(mainPanel);
		PanelTorneio torneioPanel = new PanelTorneio(gerenTorneio);
		mainPanel.setLayout(new BorderLayout());
		JPanel controlersPanel = new JPanel();
		controlersPanel.setLayout(new GridLayout(0, 3, 30, 30));
		controlersPanel.setBorder(new EmptyBorder(0, 10, 0, 10));

		mainPanel.add(torneioPanel, BorderLayout.CENTER);
		mainPanel.add(controlersPanel, BorderLayout.SOUTH);

		JButton finishButton = new JButton("Finalizar");
		finishButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		JButton initButton = new JButton("Iniciar Torneio");
		initButton.setEnabled(false);
		initButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				torneioPanel.iniciarTorneio();
				initButton.setEnabled(false);
			}
		});

		JButton cadastrarButton = new JButton("Cadastar novo Jogador("
				+ gerenTorneio.getNumJogadoresAtual() + " de "
				+ gerenTorneio.getQtdMaxJogadores() + ")");
		cadastrarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!gerenTorneio.torneioEstaCheio()) {
					FormCadastro formCadastro = new FormCadastro(frame);
					GenericCallback callback = new GenericCallback() {

						@Override
						public void callingBack(Object obj) {
							if (obj != null) {
								gerenTorneio
										.cadastrarJogadorNoTorneio((Jogador) obj);
								if (gerenTorneio.torneioEstaCheio()) {
									cadastrarButton.setEnabled(false);
									initButton.setEnabled(true);
								}
								cadastrarButton
										.setText("Cadastar novo Jogador("
												+ gerenTorneio
														.getNumJogadoresAtual()
												+ " de "
												+ gerenTorneio
														.getQtdMaxJogadores()
												+ ")");

							}
						}

					};
					formCadastro.showForm(callback);
				}

			}
		});
		controlersPanel.add(finishButton);
		controlersPanel.add(initButton);
		controlersPanel.add(cadastrarButton);

	}

	public interface GenericCallback {

		void callingBack(Object obj);
	}

}
