package conexao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarConexaoDB{
	protected Connection connection = null;
	protected Statement statement = null;
	protected ResultSet resultSet = null;
	private String dbName;

	
	public String getDbName() {
		return dbName;
	}

	public CriarConexaoDB(String dbName) {
		this.dbName = dbName;
	}
	
	private boolean checkDB() {
		Path path = Paths.get(this.dbName);
		System.out.println("File exists: " + Files.exists(path));
		if (Files.exists(path)) {
			return true;
		}
		else {
			try {
				File file = new File(this.dbName);
				System.out.println("Create new file: " + file.createNewFile());
			} catch(IOException e) {
				System.out.println(e.getMessage());
				return false;
			}
			return true;
		}
	}

	public boolean connect() {
		boolean check = checkDB();
		System.out.println("Entrar na condicao: " + check);
		if (check) {
			try {
				connection = DriverManager.getConnection("jdbc:sqlite:" + this.dbName);
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
			System.out.println("Conectado!");
			return true;
		} else {
		System.out.println("Erro ao criar o banco.");
		return false;
		}
	}
	
	public boolean disconnect() {
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		System.out.println("Desconectado");
		return true;
	}

	public ResultSet query(String strQuery) {
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(strQuery);
			return resultSet;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return resultSet;
	}

	public boolean execQuery(String strQuery) {
		try {
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.execute(strQuery);
			statement.close();
			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

}
