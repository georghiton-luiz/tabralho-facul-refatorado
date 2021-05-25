package servico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {

	private Connection con;
	
	public Conexao(){
		String url = "jdbc:postgresql://localhost:5432/bd_trabalho";
		String usuario = "postgres";
		String senha = "root";
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void executaSQL(String sql) {
		
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
			//con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fecharConexao() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet executaBusca(String sql) {
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			return rs;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
