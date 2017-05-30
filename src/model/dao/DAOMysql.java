package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DAOMysql {
	private static final String PASSWORD = "root";
	private static final String USER = "root";
	//private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/teste?autoReconnect=true";	
	private static Connection conn = null;
	
	protected final static Connection getConnection(){		
		if(conn == null){
			try{
					//Class.forName(DRIVER);					
					conn = DriverManager.getConnection(URL,USER,PASSWORD);
					System.out.println("Conexao efetuada com sucesso");
			}
			catch(Exception e){
				System.out.println("Erro ao abrir conexao com banco: ");
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	
}
