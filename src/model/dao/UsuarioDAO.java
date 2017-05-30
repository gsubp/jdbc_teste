package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.DAOfactory;
import model.vo.Usuario;

public class UsuarioDAO extends DAOPostgree implements DAOfactory{
	private static UsuarioDAO UsuarioDAO = null;
	
	private UsuarioDAO() {}
	
	public static UsuarioDAO getInstance(){
		if(UsuarioDAO == null)
			UsuarioDAO = new UsuarioDAO();
		return UsuarioDAO;
	}
	
	@Override
	public void insert(Object object) {
		Usuario usuario = (Usuario) object;
		Connection conn = getConnection();
		String sql = "insert into usuario (cpf, nome, rua, numero, bairro, cidade, uf, pais) values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.cpf);
			statement.setString(2, usuario.nome);
			statement.setString(3, usuario.rua);
			statement.setString(4, usuario.numero);
			statement.setString(5, usuario.bairro);
			statement.setString(6, usuario.cidade);
			statement.setString(7, usuario.uf);
			statement.setString(8, usuario.pais);
			statement.executeUpdate();
			
			if(usuario.telefones != null){
				if(usuario.id == null)
					usuario.id = findId(usuario.cpf);
				TelefoneDAO telefoneDAO = new TelefoneDAO();
				telefoneDAO.insert(usuario);
			}
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	public Long findId(String cpf){
		Long id = null;
		Connection conn = getConnection();
		String sql = "select id from usuario where cpf = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, cpf);
			ResultSet rs = statement.executeQuery();
			if(rs.next())
				id = rs.getLong("id");
			statement.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

}
