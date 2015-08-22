package edu.ifsp.hto.poo.torneio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Torneio {

	private List<Jogador> jogadores;
	private List<Rodada> rodadas;
	private int rodada_atual = 0;
	private Jogador campeao;
	private boolean estaFinalizado = false;

	public int getRodadaAtual() {
		return rodada_atual;
	}

	public Torneio() {
		jogadores = new ArrayList<Jogador>();
		rodadas = new ArrayList<Rodada>();
	}

	public boolean adicionarJogador(Jogador jogador) {
		if (jogadores == null) {
			jogadores = new ArrayList<Jogador>();
		}
		if (jogadores.size() >= 16) {
			return false;
		}
		jogadores.add(jogador);
		return true;
	}

	public boolean cadastrarJogador() {
		Jogador jogador = new Jogador();
		System.out.println("Cadastrar novo Jogador: ");
		Scanner sc = new Scanner(System.in);
		System.out.print("Nome: ");
		jogador.setNome(sc.nextLine());
		System.out.print("CPF: ");
		jogador.setCpf(sc.nextLine());
		System.out.print("Endereco: ");
		jogador.setEndereco(sc.nextLine());
		System.out.print("Telefone: ");
		jogador.setTelefone(sc.nextLine());
		return adicionarJogador(jogador);
	}

	public static void main(String[] args) {

	}

	public int getNumJogadores() {
		return jogadores.size();
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void addRodada(Rodada rodada) {
		if (!estaFinalizado) {
			rodadas.add(rodada);
		}
	}

	public List<Jogador> iniciarRodada() {
		List<Jogador> vencedores = new ArrayList<Jogador>();
		Rodada rodadaAtualObj = rodadas.get(rodada_atual);
		rodadaAtualObj.iniciarPartidasDaRodada();
		vencedores = rodadaAtualObj.getVencedoresDaRodada();
		System.out.println("Rodada " + (rodada_atual + 1) + " finalizada.");
		if (vencedores.size() == 1) {
			campeao = vencedores.get(0);
			setFinished();
		} else {
			rodada_atual++;
		}
		return vencedores;
	}

	private void setFinished() {
		estaFinalizado = true;
	}

	public boolean hasProximaRodada() {
		return !estaFinalizado;
	}

	public Jogador getCampeao() {
		return campeao;
	}

}