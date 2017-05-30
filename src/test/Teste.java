package test;

import model.dao.DepartamentoDAO;

import model.vo.Departamento;

public class Teste {

	public static void main(String[] args) {
		Departamento departamento = new Departamento();
		departamento.nome = "Dep 4";
		DepartamentoDAO dao = DepartamentoDAO.getInstance();
		dao.insert(departamento);
	}

}
