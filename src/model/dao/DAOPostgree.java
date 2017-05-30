package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


public abstract class DAOPostgree {
	private static final String PASSWORD = "1234";
	private static final String USER = "postgres";
	//private static final String DRIVER = org.postgresql.jdbc;
	private static final String URL = "jdbc:postgresql://localhost:5432/Biblioteca";	
	private static Connection conn = null;
	
	protected final static Connection getConnection(){		
		if(conn == null){
			try{
					//Class.forName(DRIVER);					
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
