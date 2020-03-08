package conexao;

import java.sql.SQLException;

public class DB extends CriarConexaoDB {
	boolean admin = false;

	public DB(String dbName) {
		super(dbName);
		criarTabelaUsuario();
		adminUser();
		criarTabelaUsuarioDentro();
	}

	public boolean executaComandoSql(String tabela) {
		boolean conectou = false;
		try {
			conectou = this.connect();
			this.connection.createStatement().execute(tabela);
			System.out.printf("Comando executado: %s \n", tabela);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		} finally {
			if (conectou) {
				this.disconnect();
			}
		}
		return true;
	}

	public boolean criarTabelaUsuario() {
		String infoTabela = "CREATE TABLE IF NOT EXISTS " + "usuarios" + "("
				+ "id_usuario integer PRIMARY KEY AUTOINCREMENT," + "usuario text NOT NULL UNIQUE,"
				+ "senha text NOT NULL," + "email text NOT NULL," + "idade integer" + ");";
		return executaComandoSql(infoTabela);
	}

	public boolean adminUser() {
		if (!admin) {
			String contaAdmin = "INSERT INTO usuarios values (null," + "'admin'," + "'admin'," + "'admin'," + "0);";
			this.admin = true;
			return executaComandoSql(contaAdmin);
		} else {
			return false;
		}

	}

	public boolean criarTabelaUsuarioDentro() {
		String tabela = "Create table if not exists user_inside(" + "id_usuario integer NOT NULL,"
				+ "suport boolean not null," + "chat boolean not null," + "admin boolean not null,"
				+ "constraint fk_usuarios_id foreign key (id_usuario) references usuarios(id_usuario)" + ");";
		return executaComandoSql(tabela);
	}

}
