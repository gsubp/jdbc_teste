package test;

import java.util.ArrayList;
import model.dao.EditoraDAO;
import model.vo.Editora;

public class Teste {

	public static void main(String[] args) {
		EditoraDAO editoraDAO = EditoraDAO.getInstance();
		Editora editora = new Editora();
		ArrayList<Object> editoras = new ArrayList<>();
		editora.nome = "Guilherme";
		editora.cidade = "Cidade";
		
//		//inserir ediora
//		dao.insert(editora);
		//find id 11
		editora = (Editora) editoraDAO.findById(11L);
		System.out.println("id: " + editora.id + 
						   "\nnome: " + editora.nome + 
				           "\ncidade: " + editora.cidade);
		//update editora com id 11
		editora.cidade = "Serra Talhada";
		editoraDAO.update(editora);
//		//delete editoras com id 12 e 13
//		dao.delete(12L);
//		dao.delete(13L);
		
		//find all
		editoras = editoraDAO.findAll();
		for (Object obj : editoras){
			Editora ed = (Editora) obj;
			System.out.println("id: " + ed.id + 
					   "\nnome: " + ed.nome + 
			           "\ncidade: " + ed.cidade);
			
		}		
		
	}

}
