package edu.ifsp.hto.poo.torneio.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import edu.ifsp.hto.poo.torneio.GerenciadorTorneio;
import edu.ifsp.hto.poo.torneio.Partida;
import edu.ifsp.hto.poo.torneio.ui.TelaPrincipal.GenericCallback;

public class PanelTorneio extends JPanel {

	GerenciadorTorneio gerenTorneio;
	JFrame mainFrame;
	Iterator<Partida> p;
	PartidaPanel panelPartida;

	JLabel rodadaLabel;

	public PanelTorneio(GerenciadorTorneio gerenTorneio) {
		this.gerenTorneio = gerenTorneio;
		this.setLayout(new GridLayout(4, 0));
	}

	public void iniciarTorneio() {
		gerenTorneio.iniciarTorneio();
		rodadaLabel = new JLabel("Rodada 1", SwingConstants.CENTER);
		rodadaLabel.setBackground(Color.BLACK);
		rodadaLabel.setFont(new Font(rodadaLabel.getFont().getName(),
				Font.PLAIN, 100));
		JLabel selecionarVencedorLabel = new JLabel("Selecione o Vencedor",
				SwingConstants.CENTER);
		selecionarVencedorLabel.setBackground(Color.BLACK);
		selecionarVencedorLabel.setFont(new Font(rodadaLabel.getFont()
				.getName(), Font.PLAIN, 70));

		this.add(selecionarVencedorLabel, SwingConstants.CENTER);
		this.add(rodadaLabel, SwingConstants.CENTER);

		p = gerenTorneio.getRodadaAtual().getPartidas().iterator();
		Partida partida = (Partida) p.next();
		panelPartida = new PartidaPanel(new GenericCallback() {

			@Override
			public void callingBack(Object obj) {
				updatePartidaAtual();
			}
		});
		panelPartida.setPartidaAtual(partida);
		this.add(panelPartida);
		this.setVisible(true);
		this.repaint();
	}

	protected void updatePartidaAtual() {
		if (p.hasNext()) {
			Partida partida = (Partida) p.next();
			panelPartida.setPartidaAtual(partida);
		} else {
			gerenTorneio.gerarRodadaDosVencedoresAnteriores();
			p = gerenTorneio.getRodadaAtual().getPartidas().iterator();
			rodadaLabel.setText("Rodada " + gerenTorneio.getNumRodadaAtual());
			updatePartidaAtual();
		}
	}

}
