package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.DAOfactory;
import model.vo.Telefone;
import model.vo.Usuario;

public class TelefoneDAO extends DAOPostgree implements DAOfactory{
	
	@Override
	public void insert(Object object) {
		Usuario usuario = (Usuario) object;
		Connection conn = getConnection();
		String sql = "insert into telefone (telefone, id_usuario) values (?,?)";		
		for(Telefone telefone : usuario.telefones){			
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, telefone.telefone);
				statement.setLong(2, usuario.id);
				statement.executeUpdate();
				statement.close();				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
