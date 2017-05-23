package test;

import java.util.ArrayList;

import factory.DAOfactory;
import model.dao.DAO;
import model.dao.EditoraDAO;
import model.vo.Editora;

public class Teste {

	public static void main(String[] args) {
		DAO dao = DAOfactory.EditoraDaoFactory();
		Editora editora = new Editora();
		ArrayList<Object> editoras = new ArrayList<>();
		editora.nome = "Guilherme";
		editora.cidade = "Cidade";
		
//		//inserir ediora
//		dao.insert(editora);
		//find id 11
		editora = (Editora) dao.findById(11L);
		System.out.println("id: " + editora.id + 
						   "\nnome: " + editora.nome + 
				           "\ncidade: " + editora.cidade);
		//update editora com id 11
		editora.cidade = "Serra Talhada";
		dao.update(editora);
		//delete editoras com id 12 e 13
		dao.delete(12L);
		dao.delete(13L);
		
		//find all
		editoras = dao.findAll();
		for (Object obj : editoras){
			Editora ed = (Editora) obj;
			System.out.println("id: " + ed.id + 
					   "\nnome: " + ed.nome + 
			           "\ncidade: " + ed.cidade);
			
		}
		
		
	}

}
