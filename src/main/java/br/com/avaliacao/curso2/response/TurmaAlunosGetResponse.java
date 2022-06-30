package br.com.avaliacao.curso2.response;

import java.util.ArrayList;
import java.util.List;

public class TurmaAlunosGetResponse {
private Integer semestre;
private List<String> nomesAlunos= new ArrayList();
public TurmaAlunosGetResponse() {
	super();
	// TODO Auto-generated constructor stub
}
public TurmaAlunosGetResponse(Integer semestre, List<String> nomesAlunos) {
	super();
	this.semestre = semestre;
	this.nomesAlunos = nomesAlunos;
}
public Integer getSemestre() {
	return semestre;
}
public void setSemestre(Integer semestre) {
	this.semestre = semestre;
}
public List<String> getNomesAlunos() {
	return nomesAlunos;
}
public void setNomesAlunos(List<String> nomesAlunos) {
	this.nomesAlunos = nomesAlunos;
}
	
}
