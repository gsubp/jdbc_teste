package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import factory.DAOfactory;
import model.vo.Departamento;

public class DepartamentoDAO extends DAOPostgree implements DAOfactory{
	private static DepartamentoDAO departamentoDAO = null;
	
	private DepartamentoDAO() {}
	
	public synchronized static DepartamentoDAO getInstance(){
		if(departamentoDAO == null)
			departamentoDAO = new DepartamentoDAO();
		return departamentoDAO;
	}

	@Override
	public void insert(Object object) {
		Departamento departamento = (Departamento) object;
		Connection conn = (Connection) getConnection();
		String sql = "insert into departamento (nome) values (?)";		
		try{
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
			statement.setString(1, departamento.nome);
			statement.executeUpdate();
			statement.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
