package model.dao;

import java.sql.DriverManager;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public abstract class DAO {
	private static final String PASSWORD = "root";
	private static final String USER = "root";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/teste";	
	private static Connection conn;
	
	protected final static Connection getConnection(){		
		if(conn == null){
			try{
					Class.forName(DRIVER);					
					conn = (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
					System.out.println("Conexao efetuada com sucesso");
			}
			catch(Exception e){
				System.out.println("Erro ao abrir conexao com banco: ");
				e.printStackTrace();
			}
		}
		return conn;
	}
	public abstract void insert(Object object);
	public abstract void update(Object object);
	public abstract void delete(Long id);
	public abstract Object findById(Long id);
	public abstract ArrayList<Object> findAll();
	
}
