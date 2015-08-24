package edu.ifsp.hto.poo.torneio.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Handler;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import edu.ifsp.hto.poo.torneio.Jogador;
import edu.ifsp.hto.poo.torneio.ui.TelaPrincipal.GenericCallback;

public class FormCadastro extends JFrame {

	private JFormattedTextField tfCpf, tfTelefone;
	private JTextField tfEndereco, tfNome;
	private JPanel formPanel;
	private GenericCallback cadastroCallback;
	MaskFormatter maskCpf = null;
	MaskFormatter maskTel = null;

	public FormCadastro(Component parentComponent) {
		this.setLayout(new BorderLayout());
		this.setTitle("Cadastro");
		this.setSize(500, 300);
		tfNome = new JTextField();

		tfCpf = new JFormattedTextField();

		try {
			maskCpf = new MaskFormatter("###.###.###-##");
			maskTel = new MaskFormatter("(##) ####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		maskCpf.setPlaceholderCharacter("_".charAt(0));
		maskCpf.install(tfCpf);

		tfEndereco = new JTextField();

		tfTelefone = new JFormattedTextField();

		maskTel.setPlaceholderCharacter("_".charAt(0));
		maskTel.install(tfTelefone);

		formPanel = new JPanel(new GridLayout(0, 1));
		formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		JLabel titulo = new JLabel("Novo Jogador", SwingConstants.CENTER);
		formPanel.add(titulo);
		formPanel.add(new JLabel("Nome:"));
		formPanel.add(tfNome);
		formPanel.add(new JLabel("CPF:"));
		formPanel.add(tfCpf);
		formPanel.add(new JLabel("Endereço:"));
		formPanel.add(tfEndereco);
		formPanel.add(new JLabel("Telefone: "));
		formPanel.add(tfTelefone);
		this.add(formPanel, BorderLayout.CENTER);
		JPanel buttonPannel = new JPanel(new GridLayout());
		JButton okBtn = new JButton("Cadastrar");
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean invalid = false;
				if (tfEndereco.getText().isEmpty()) {
					tfEndereco.setBackground(Color.RED);
					invalid = true;
				}
				String cpf = tfCpf.getText().replaceAll("[\\s.\\-_]", "");
				if (cpf.length() <= 0) {
					tfCpf.setBackground(Color.RED);
					invalid = true;
				}
				if (tfNome.getText().isEmpty()) {
					tfNome.setBackground(Color.RED);
					invalid = true;
				}
				String tel = tfTelefone.getText()
						.replaceAll("[\\s.\\-_()]", "");
				if (tel.isEmpty()) {
					tfTelefone.setBackground(Color.RED);
					invalid = true;
				}
				if (!invalid) {
					Jogador jogador = new Jogador();
					jogador.setCpf(cpf);
					jogador.setNome(tfNome.getText());
					jogador.setTelefone(tfTelefone.getText());
					jogador.setEndereco(tfEndereco.getText());
					cadastroCallback.callingBack(jogador);
					FormCadastro.this.setVisible(false);
				}
			}
		});
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormCadastro.this.setVisible(false);
			}
		});
		buttonPannel.add(okBtn);
		buttonPannel.add(cancelBtn);
		buttonPannel.setBorder(new EmptyBorder(0, 10, 10, 10));
		this.add(buttonPannel, BorderLayout.SOUTH);

	}

	public void showForm(GenericCallback callback) {
		this.setVisible(true);
		this.cadastroCallback = callback;
	}

}
