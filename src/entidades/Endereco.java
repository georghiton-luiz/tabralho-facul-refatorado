package entidades;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class Endereco {
	
	private String rua;
	private String num;
	private String bairro;
	private String cidade;
	private String uf;
	private String complemento;
	private String cep;
	private static final String FormatoCep = "##.###-###";
	
	public Endereco() {
		
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf.toUpperCase();
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {		
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
		
	}	
	
	public String getCepFormatado() {
		MaskFormatter mask;
		try {
			
			mask = new MaskFormatter(FormatoCep);
			mask.setValueContainsLiteralCharacters(false);
			if(this.cep != null && !this.cep.equals("")) {
				return mask.valueToString(getCep());				
			}
			return this.cep = null;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return getCep();
		
	}
}
