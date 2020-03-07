package main;

import conexao.DB;
import telas.Login;

public class Main {

	public static void main(String[] args) {
		DB banco = new DB("BancoTeste01.db");

		banco.criarTabela();
		
		Login telaLogin = new Login(banco.getDbName());
		telaLogin.setVisible(true);
	}
}