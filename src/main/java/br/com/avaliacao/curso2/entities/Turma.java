package br.com.avaliacao.curso2.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="turma")
public class Turma{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "idturma")
	private Integer idTurma;
	
	@Column(name= "semestre",length=50, nullable=false)
	private Integer semestre;
	
	@Column(name= "ano", nullable=false)
	private Integer ano;


	public Turma() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Turma(Integer idTurma, Integer semestre, Integer ano) {
		super();
		this.idTurma = idTurma;
		this.semestre = semestre;
		this.ano = ano;
	}

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
}