package br.com.avaliacao.curso2.response;

import java.util.ArrayList;
import java.util.List;

public class CursoProfessoresGetResponse {
private String nome;
private List<String> nomesProfessores= new ArrayList();
public CursoProfessoresGetResponse() {
	super();
	// TODO Auto-generated constructor stub
}
public CursoProfessoresGetResponse(String nome, List<String> nomesProfessores) {
	super();
	this.nome = nome;
	this.nomesProfessores = nomesProfessores;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public List<String> getNomesProfessores() {
	return nomesProfessores;
}
public void setNomesProfessores(List<String> nomesProfessores) {
	this.nomesProfessores = nomesProfessores;
}
}
