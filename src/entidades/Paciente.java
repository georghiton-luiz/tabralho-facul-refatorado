package entidades;

import java.time.LocalDate;

public class Paciente {
	
	private String nomeCompleto;
	private LocalDate dataNasc;
	private Documentos doc;
	private Endereco endereco;
	private Contatos contatos;
	private Vacina vacina;
	
	public Paciente() {
		
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Documentos getDoc() {
		return doc;
	}

	public void setDoc(Documentos doc) {
		this.doc = doc;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contatos getContatos() {
		return contatos;
	}

	public void setContatos(Contatos contatos) {
		this.contatos = contatos;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}		
}
