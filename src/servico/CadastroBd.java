package servico;

import entidades.*;


public class CadastroBd {
	
	public static void cadastroPaciente(Paciente pac) {
		Conexao con = new Conexao();
		String sqlDadosPaciente, sqlEnderecoPaciente, sqlContatoPaciente, sqlVacinaPaciente;
		
		sqlDadosPaciente = "INSERT INTO dados_paciente (id_paciente,nome_paciente,data_nasc_paciente,"
				+ "rg_paciente,org_emissor_paciente,cpf_paciente,num_sus_paciente)values" + "(default,'"
				+ pac.getNomeCompleto() + "','" + pac.getDataNasc() + "','" + pac.getDoc().getRg() + "','" + pac.getDoc().getOrgEmissor() + "','"
				+ pac.getDoc().getCpfFormatado() + "','" + pac.getDoc().getNumSus() + "')";
		con.executaSQL(sqlDadosPaciente);
		
		sqlEnderecoPaciente = "INSERT INTO endereco_paciente (id_endereco,id_paciente,rua_paciente,num_paciente,"
				+ "bairro_paciente,cidade_paciente,uf_paciente,complemento_paciente,cep_paciente)values" + "(default,default,'"
				+ pac.getEndereco().getRua() + "','" + pac.getEndereco().getNum() + "','" + pac.getEndereco().getBairro() + "','" + pac.getEndereco().getCidade() + "','"
				+ pac.getEndereco().getUf() + "','" + pac.getEndereco().getComplemento() + "','" +pac.getEndereco().getCepFormatado() + "')";
		con.executaSQL(sqlEnderecoPaciente);
		
		sqlContatoPaciente = "INSERT INTO contato_paciente (id_contato,id_paciente,fone_paciente,celular_paciente,"
				+ "email_paciente)values" + "(default, default,'" + pac.getContatos().gerFoneFormatado() + "','" + pac.getContatos().getCelFormatado() + "','"
				+ pac.getContatos().getEmail() + "')";
		con.executaSQL(sqlContatoPaciente);
		
		sqlVacinaPaciente = "INSERT INTO vacina_paciente (id_vacina,id_paciente,tipo_vac_paciente,data1_vac_paciente,"
				+ "data2_vac_paciente)values" + "(default,default,'" + pac.getVacina().getTpVacina() + "','"	+ pac.getVacina().getDataVacina1()
				+ "','"	+ pac.getVacina().getDataVacina2() + "')";
		con.executaSQL(sqlVacinaPaciente);		
		con.fecharConexao();
	}

	public static void cadastroFuncionario(Funcionario fun) {
		Conexao con = new Conexao();

		String sqlFuncionario;

		sqlFuncionario = "INSERT INTO cad_funcionario (id_fun, nome_fun, doc_fun, user_name_fun, senha_fun, email_fun)"
				+ "values" + "(default,'" + fun.getNome() + "','" + fun.getDoc() + "','"
				+ fun.getUserName() + "','" + fun.getSenha() + "','" + fun.getEmail() + "')";
		con.executaSQL(sqlFuncionario);
		con.fecharConexao();

	}
		
}
