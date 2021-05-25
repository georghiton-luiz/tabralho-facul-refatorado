package servico;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import entidades.Documentos;

public class PesquisaBD {
	
	private String sql;
	
	Documentos doc = new Documentos();
	Conexao con = new Conexao();

	public PesquisaBD() {
		super();
	}

	public void pesquisarCadastro() {

		doc.setCpf(JOptionPane.showInputDialog("Digite o CPF do paciente:"));		
		while (!doc.isCPF()) {
			doc.setCpf(JOptionPane.showInputDialog("CFP invalido!\nDigitar um CPF valido:\nDigite o CPF do paciente: "));
		}

		sql = "SELECT nome_paciente, data_nasc_paciente, rg_paciente,"
				+ "org_emissor_paciente, cpf_paciente, num_sus_paciente, rua_paciente, num_paciente, "
				+ "bairro_paciente, cidade_paciente, uf_paciente, complemento_paciente, cep_paciente, "
				+ "fone_paciente, celular_paciente, email_paciente,	tipo_vac_paciente, data1_vac_paciente,"
				+ "data2_vac_paciente FROM dados_paciente AS DADOS INNER JOIN endereco_paciente AS ENDERECO "
				+ "ON DADOS.id_paciente = ENDERECO.id_paciente INNER JOIN contato_paciente AS CONTATO "
				+ "ON DADOS.id_paciente = CONTATO.id_paciente INNER JOIN vacina_paciente AS VACINA "
				+ "ON DADOS.id_paciente = VACINA.id_paciente WHERE DADOS.cpf_paciente LIKE '" +  doc.getCpfFormatado() + "'";
		con.executaBusca(sql);
	}
	
	public String resultadoPesquisa(){

		ResultSet rs = con.executaBusca(sql);
		String nome = "";
		Date dataNasc;
		String dataNasConvertida = "";
		String rg = "";
		String org = "";
		String cpf = "";
		String numSus = "";
		String rua = "";
		String num = "";
		String bairro = "";
		String cidade = "";
		String uf = "";
		String comp = "";
		String cep = "";
		String fone = "";
		String cel = "";
		String email = "";
		String tpVacina = "";
		Date data1Vac;
		String dataVac1Convertida = "";
		Date data2Vac;
		String dataVac2Convertida = "";
		try {
			while (rs.next()){
				nome = rs.getString("nome_paciente");
				dataNasc = rs.getDate("data_nasc_paciente");
				rg = rs.getString("rg_paciente");
				org = rs.getString("org_emissor_paciente");
				cpf = rs.getString("cpf_paciente");
				numSus = rs.getString("num_sus_paciente");
				rua = rs.getString("rua_paciente");
				num = rs.getString("num_paciente");
				bairro = rs.getString("bairro_paciente");
				cidade = rs.getString("cidade_paciente");
				uf = rs.getString("uf_paciente");
				comp = rs.getString("complemento_paciente");
				cep = rs.getString("cep_paciente");
				fone = rs.getString("fone_paciente");
				cel = rs.getString("celular_paciente");
				email = rs.getString("email_paciente");
				tpVacina = rs.getString("tipo_vac_paciente");
				data1Vac = rs.getDate("data1_vac_paciente");
				data2Vac = rs.getDate("data2_vac_paciente");
				
				DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");		
				dataNasConvertida = formatUS.format(dataNasc);				
				LocalDate data = LocalDate.parse(dataNasConvertida);
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				dataNasConvertida = fmt.format(data);
				
				formatUS = new SimpleDateFormat("yyyy-MM-dd");		
				dataVac1Convertida = formatUS.format(data1Vac);				
				data = LocalDate.parse(dataVac1Convertida);
				fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				dataVac1Convertida = fmt.format(data);
				
				formatUS = new SimpleDateFormat("yyyy-MM-dd");		
				dataVac2Convertida = formatUS.format(data2Vac);				
				data = LocalDate.parse(dataVac2Convertida);
				fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				dataVac2Convertida = fmt.format(data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(cpf.equals("")) {
			return "CPF não cadastrado";
		}else {
			return "Nome: " + nome +
					"\nData de Nascimento: " + dataNasConvertida + 
					"\nR.G.: " + rg + "\nOrg. Emissor: " + org + "\nCPF: " + cpf +
					"\nNúmero SUS: "+ numSus +"\nRua: " + rua + "\nNº: " + num +
					"\nBairro: " + bairro + "\nCidade: " + cidade + "\nUF: " + uf +
					"\nComplemento: " + comp + "\nCEP: " + cep + "\nFone: " + fone +
					"\nCelular: " + cel + "\nE-mail: " + email + "\nTipo de Vacina: " + tpVacina +
					"\nData da primeira dose ou dose única: " + dataVac1Convertida + "\nData da segunda dose: " + dataVac2Convertida;			
		}
	}	
}
