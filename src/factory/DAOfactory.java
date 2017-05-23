package factory;

import model.dao.EditoraDAO;

public class DAOfactory {
	public static EditoraDAO EditoraDaoFactory(){
		return new EditoraDAO();
	}
}
