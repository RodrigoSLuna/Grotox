package model1;

import java.io.BufferedWriter;
import java.io.FileWriter;

import action.Obrigatorio;

public class Turma {

	@Obrigatorio(parametros = false)
	private String nome = "empty";
	
	@Obrigatorio(parametros = true)
	private String professor = "empty";
	
	@Obrigatorio(parametros = true)
	private String disciplina = "empty";
	@Obrigatorio(parametros = true)
	private String sala = "empty";
	@Obrigatorio(parametros = true)
	private String horario = "empty";

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
