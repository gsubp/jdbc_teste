package model.vo;

import java.util.ArrayList;

public class Usuario {
	public Long id;
	public String nome;
	public String cpf;
	public String rua;
	public String numero;
	public String bairro;
	public String cidade;
	public String uf;
	public String pais;
	
	public ArrayList<Telefone> telefones;
}
