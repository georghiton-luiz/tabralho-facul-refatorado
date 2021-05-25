package entidades;

import java.sql.ResultSet;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import servico.Conexao;

public class Documentos {
	
	private String cpf;
	private String rg;
	private String orgEmissor;
	private String numSus;
	private static final String FormatoCpf = "###.###.###-##";
	
	public Documentos() {
		
	}

	public String getCpf() {		
		return cpf;
	}


	public void setCpf(String cpf) {		
		this.cpf = cpf.replaceAll("[^0-9]", "");			
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getOrgEmissor() {
		return orgEmissor;
	}


	public void setOrgEmissor(String orgEmissor) {
		this.orgEmissor = orgEmissor.toUpperCase();
	}


	public String getNumSus() {
		return numSus;
	}


	public void setNumSus(String numSus) {
		this.numSus = numSus;
	}	
	
	//Validador de CPF
	public boolean isCPF() {
		
		String[] invalidoCpf = {"00000000000","11111111111","22222222222","33333333333","44444444444","55555555555","66666666666",
                         "77777777777","88888888888","99999999999"};

		for (String s : invalidoCpf) {
			if (this.cpf.contains(s) || this.cpf.length() != 11)
				return (false);
		}

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			// Valida o primeiro Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = this.cpf.charAt(i) - 48;
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			// Valida o primeiro Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = this.cpf.charAt(i) - 48;
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			return (dig10 == this.cpf.charAt(9)) && (dig11 == this.cpf.charAt(10));
		} catch (Exception e) {
			e.printStackTrace();
			return (false);
		}
	}

	public String getCpfFormatado() {
		MaskFormatter mask;
		try {
			mask = new MaskFormatter(FormatoCpf);
			mask.setValueContainsLiteralCharacters(false);
			if(isCPF()) {
				return mask.valueToString(getCpf());				
			}
			return "CPF invalido!";
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return getCpf();
	}
	
	public boolean pesquisarCpf() {
		String cpf = "";
		try {
			Conexao con = new Conexao();
			String sql = "SELECT cpf_paciente FROM dados_paciente AS DADOS WHERE DADOS.cpf_paciente LIKE '"
					+ getCpfFormatado() + "'";
			ResultSet rs = con.executaBusca(sql);			

			while (rs.next()) {
				cpf = rs.getString("cpf_paciente");
			}
			return cpf.equals(getCpfFormatado());

		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}
}
