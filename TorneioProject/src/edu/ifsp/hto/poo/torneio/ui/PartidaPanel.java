package edu.ifsp.hto.poo.torneio.ui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.ifsp.hto.poo.torneio.Partida;
import edu.ifsp.hto.poo.torneio.ui.TelaPrincipal.GenericCallback;

public class PartidaPanel extends JPanel {

	Partida partida;
	JButton jogador1Btn, jogador2Btn;

	public PartidaPanel(GenericCallback vitoriosoDefinido) {

		this.setLayout(new GridLayout(1, 3));
		this.setBorder(new EmptyBorder(10, 50, 10, 50));

		jogador1Btn = new JButton();
		jogador1Btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				partida.definirVencedor(partida.getJogadorUm());
				vitoriosoDefinido.callingBack(null);
			}
		});
		JLabel vsLabel = new JLabel("VS.", SwingConstants.CENTER);
		vsLabel.setFont(new Font(vsLabel.getFont().getName(), Font.PLAIN, 80));
		jogador2Btn = new JButton();
		jogador2Btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				partida.definirVencedor(partida.getJogadorDois());
				vitoriosoDefinido.callingBack(null);
			}
		});
		this.add(jogador1Btn);
		this.add(vsLabel);
		this.add(jogador2Btn);
		this.setVisible(true);
	}

	public void setPartidaAtual(Partida partida) {
		this.partida = partida;
		jogador1Btn.setText(partida.getJogadorUm().getNome());
		jogador2Btn.setText(partida.getJogadorDois().getNome());
	}
}
