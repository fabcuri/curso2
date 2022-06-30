package br.com.avaliacao.curso2.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="curso")
public class Curso{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "idcurso")
	private Integer idCurso;
	
	@Column(name= "nome",length=50, nullable=false)
	private String nome;
	
	@Column(name= "sigla", nullable=false)
	private String sigla;

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(Integer idCurso, String nome, String sigla) {
		super();
		this.idCurso = idCurso;
		this.nome = nome;
		this.sigla = sigla;
	}


	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}