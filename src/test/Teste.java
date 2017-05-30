package test;

import java.util.ArrayList;
import model.dao.EditoraDAO;
import model.dao.UsuarioDAO;
import model.vo.Editora;
import model.vo.Telefone;
import model.vo.Usuario;

public class Teste {

	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		ArrayList<Telefone> telefones = new ArrayList<>();
		Telefone telefone1 = new Telefone();
		Telefone telefone2 = new Telefone();
		
		telefone1.telefone = "t123";
		telefone2.telefone = "t234";
		telefones.add(telefone1);
		telefones.add(telefone1);
		
		Usuario usuario = new Usuario();
		usuario.cpf = "187";
		usuario.nome = "Guilherme";
		usuario.rua = "sda";
		usuario.numero = "15A";
		usuario.bairro = "dasd";
		usuario.cidade = "csad";
		usuario.uf = "CU";
		usuario.pais = "aooa";
		usuario.telefones = telefones;
		
		usuarioDAO.insert(usuario);
		
		
		
	}

}
