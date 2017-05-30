package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import factory.DAOfactory;
import model.vo.Editora;

public class EditoraDAO extends DAOMysql implements DAOfactory{
	private static EditoraDAO editoraDAO = null;
	
	private EditoraDAO() {}
	
	public synchronized static EditoraDAO getInstance(){
		if(editoraDAO == null)
			editoraDAO = new EditoraDAO();
		return editoraDAO;
	}
	
	
	@Override
	public void insert(Object object) {
		// TODO Auto-generated method stub
		Editora editora = (Editora) object;
		Connection conn = (Connection) getConnection();
		String sql = "insert into editora (nome, cidade) values (?,?)";		
		try{
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
			statement.setString(1, editora.nome);
			statement.setString(2, editora.cidade);
			statement.executeUpdate();
			statement.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		Editora editora = (Editora) object;
		Connection conn = (Connection) getConnection();
		String sql = "update editora set id = ?, nome = ?, cidade = ? where id = ?";
		try{
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
			statement.setString(1, editora.id.toString());
			statement.setString(2, editora.nome);
			statement.setString(3, editora.cidade);
			statement.setString(4, editora.id.toString());
			statement.executeUpdate();
			statement.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Long id) {
		Connection conn = (Connection) getConnection();
		String sql = "delete from editora where id = ?";
		try{
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
			statement.setString(1, id.toString());
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Object findById(Long id) {
		// TODO Auto-generated method stub
		Connection conn = (Connection) getConnection();
		String sql = "select * from editora where id = ?";
		Editora editora = new Editora();
		try {
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
			statement.setString(1, id.toString());
			ResultSet result = statement.executeQuery();
			if(result.next()){
				editora.id = (result.getLong("id"));
				editora.nome = result.getString("nome");
				editora.cidade = result.getString("cidade");
			}
			result.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return editora;
	}

	@Override
	public ArrayList<Object> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Object> editoras = new ArrayList<>();
		Connection conn = (Connection) getConnection();
		String sql = "select * from editora";
		
		try {
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()){
				Editora editora = new Editora();
				editora.id = Long.decode(result.getString("id"));
				editora.nome = result.getString("nome");
				editora.cidade = result.getString("cidade");				
				editoras.add(editora);
			}
			result.close();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return editoras;
	}

}
