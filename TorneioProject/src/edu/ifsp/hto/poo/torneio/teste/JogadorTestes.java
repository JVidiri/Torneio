package edu.ifsp.hto.poo.torneio.teste;

import edu.ifsp.hto.poo.torneio.Jogador;
import edu.ifsp.hto.poo.torneio.Torneio;

/**
 * modulo de testes classe jogador
 * 
 * @author Jvidiri Thiagol
 *
 */
public class JogadorTestes {

	public static void main(String[] args) {
		// iniciando testes!!!!!
		if (!teste1()) {
			// Teste Caminho Feliz - armazenamento jogador
			System.out.println("ERRO TESTE1");
		}

	}

	/**
	 * criação, 1. Good path AC - Criar um jogador normal RE - Verificar se não
	 * há erro
	 * 
	 * @param jogador
	 */
	private static boolean teste1() {
		try {
			cadastrarJogadorGenerico("Thiago Luiz", "45382030847", "1939331144", "Rua Antônio Ferro, 195");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 1. Bad path AC - Criar jogador com erros -nome menor que 3 letras RE -
	 * Verificar se retorna devido erro
	 * 
	 * @param jogador
	 * @return
	 */
	private static boolean teste2() {
		try {
			cadastrarJogadorGenerico("t", "44916411889", "38324586", "rua teste, 2");
			cadastrarJogadorGenerico("ti", "44916411889", "38324586", "rua teste, 2");
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	/**
	 * 1. Bad path AC - Criar jogador com erros -cpf inválido RE - Verificar se
	 * retorna devido erro
	 * 
	 * @param jogador
	 * @return
	 */
	private static boolean teste3() {
		try {
			cadastrarJogadorGenerico("thiago", "5555555555555", "38324586", "rua teste, 2");
			cadastrarJogadorGenerico("thiago", "555", "38324586", "rua teste, 2");
			cadastrarJogadorGenerico("thiago", "44916411855", "38324586", "rua teste, 2");
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	/**
	 * 2. Good path AC - Cadastrar 16 jogadores RE - Verificar se não há erros
	 */
	private static boolean teste4() {
		try {
			Torneio torneio = new Torneio();
			adicionarNJogadores(16, torneio);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 2. BadPath AC - Cadastrar 17 jogadores e iniciar torneio RE - Verificar
	 * erro esperado
	 */
	private static boolean teste5() {
		try {
			Torneio torneio = new Torneio();
			adicionarNJogadores(17, torneio);
			torneio.iniciarRodada();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static void adicionarNJogadores(int n, Torneio t) {
		for (int i = 0; i < n; i++) {
			Jogador jog = cadastrarJogadorGenerico("thiago", "45382030847", "39331147", "rua teste, 1");
			t.adicionarJogador(jog);
		}
	}

	/**
	 * 2. BadPath AC - Cadastrar 15 jogadores e iniciar torneio RE - Verificar
	 * erro esperado
	 */
	private static boolean teste6() {
		try {
			Torneio torneio = new Torneio();
			adicionarNJogadores(15, torneio);
			torneio.iniciarRodada();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	/**
	 * 2. BadPath AC - Iniciar torneio a sem jogadores RE - Verificar erro
	 * esperado
	 */
	private static boolean teste7() {
		try {
			Torneio torneio = new Torneio();
			// adicionarNJogadores(n, t);
			torneio.iniciarRodada();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	/**
	 * 3. Good path AC - Cadastrar um jogador, ler e verificar se o jogador é
	 * ele mesmo RE - O jogador é ele mesmo.
	 */
	private static boolean teste8() {
		try {
			Jogador thiago = cadastrarJogadorGenerico("Thiagol", "45382030847", "39331147", "rua z");
			if (thiago.getNome().equals("Thiagol") && thiago.getCpf().equals("45382030847")
					&& thiago.getTelefone().equals("39331147") && thiago.getEndereco().equals("rua z")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 3. BadPath AC - Cadastrar 16 jogadores e verificar se os 16 são os
	 * cadastrados RE - Jogadores são os mesmos, se não não passar no teste.
	 */
	private static boolean teste9() {
		try {
			for (int i = 0; i < 16; i++) {
				Jogador thiago = cadastrarJogadorGenerico("Thiagol;" + i, "45382030847", "39331147", "rua z");
				if (!thiago.getNome().equals("Thiagol;" + i) && !thiago.getCpf().equals("45382030847")
						&& !thiago.getTelefone().equals("39331147") && !thiago.getEndereco().equals("rua z")) {
					return false;
				}				
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static Jogador cadastrarJogadorGenerico(String nome, String cpf, String telefone, String endereco) {
		Jogador jogador = new Jogador();
		jogador.setNome(nome);
		jogador.setCpf(cpf);
		jogador.setTelefone(telefone);
		jogador.setEndereco(endereco);
		return jogador;
	}
}
