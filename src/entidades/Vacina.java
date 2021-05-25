package entidades;

import java.time.LocalDate;

public class Vacina {

	private LocalDate dataVacina1;
	private LocalDate dataVacina2;
	private Integer resp;
	private int id;
	private String tpVacina;

	public Vacina() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTpVacina() {
		return tpVacina;
	}

	public void setTpVacina(String tpVacina) {
		this.tpVacina = tpVacina;
	}

	public LocalDate getDataVacina1() {
		return dataVacina1;
	}

	public void setDataVacina1(LocalDate dataVacina1) {
		this.dataVacina1 = dataVacina1;
	}

	public LocalDate getDataVacina2() {
		return dataVacina2;
	}

	public void setDataVacina2(LocalDate dataVacina2) {
		this.dataVacina2 = dataVacina2;
	}

	public Integer getResp() {
		return resp;
	}

	public void setResp(Integer resp) {
		this.resp = resp;
	}
}
