package conexao;

import java.sql.SQLException;

public class DB extends CriarConexaoDB {

	public DB(String dbName) {
		super(dbName);
	}

	public boolean criarTabela() {
		String infoTabela = "CREATE TABLE IF NOT EXISTS " 
							+ "usuarios" 
							+ "(" 
							+ "id integer PRIMARY KEY AUTOINCREMENT,"
							+ "usuario text NOT NULL UNIQUE,"
							+ "senha text NOT NULL,"
							+ "email text NOT NULL,"
							+ "idade integer" 
							+ ");";

		boolean conectou = false;

		try {
			conectou = this.connect();
			this.connection.createStatement().execute(infoTabela);
			System.out.printf("Tabela %s criada!\n", "usuarios");
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
	

}
