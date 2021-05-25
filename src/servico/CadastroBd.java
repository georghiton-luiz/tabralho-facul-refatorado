package servico;

import entidades.*;


public class CadastroBd {


	
	public static void cadastroPaciente(Paciente pac, Documentos doc, Endereco end, Contatos contato, Vacina vac) {
		Conexao con = new Conexao();
		String sqlDadosPaciente, sqlEnderecoPaciente, sqlContatoPaciente, sqlVacinaPaciente;
		
		sqlDadosPaciente = "INSERT INTO dados_paciente (id_paciente,nome_paciente,data_nasc_paciente,"
				+ "rg_paciente,org_emissor_paciente,cpf_paciente,num_sus_paciente)values" + "(default,'"
				+ pac.getNomeCompleto() + "','" + pac.getDataNasc() + "','" + doc.getRg() + "','" + doc.getOrgEmissor() + "','"
				+ doc.getCpfFormatado() + "','" + doc.getNumSus() + "')";
		con.executaSQL(sqlDadosPaciente);
		
		sqlEnderecoPaciente = "INSERT INTO endereco_paciente (id_endereco,id_paciente,rua_paciente,num_paciente,"
				+ "bairro_paciente,cidade_paciente,uf_paciente,complemento_paciente,cep_paciente)values" + "(default,default,'"
				+ end.getRua() + "','" + end.getNum() + "','" + end.getBairro() + "','" + end.getCidade() + "','"
				+ end.getUf() + "','" + end.getComplemento() + "','" + end.getCepFormatado() + "')";
		con.executaSQL(sqlEnderecoPaciente);
		
		sqlContatoPaciente = "INSERT INTO contato_paciente (id_contato,id_paciente,fone_paciente,celular_paciente,"
				+ "email_paciente)values" + "(default, default,'" + contato.gerFoneFormatado() + "','" + contato.getCelFormatado() + "','"
				+ contato.getEmail() + "')";
		con.executaSQL(sqlContatoPaciente);
		
		sqlVacinaPaciente = "INSERT INTO vacina_paciente (id_vacina,id_paciente,tipo_vac_paciente,data1_vac_paciente,"
				+ "data2_vac_paciente)values" + "(default,default,'" + vac.getTpVacina() + "','"	+ vac.getDataVacina1()
				+ "','"	+ vac.getDataVacina2() + "')";
		con.executaSQL(sqlVacinaPaciente);		
		con.fecharConexao();
	}

	public static void cadastroFuncionario(Funcionario fun) {
		Conexao con = new Conexao();

		String sqlFuncionario;

		sqlFuncionario = "INSERT INTO cad_funcionario (id_fun, doc_fun, nome_fun, pass_fun, email_fun)"
				+ "values" + "(default,'" + fun.getCpfFormatado() + "','"
				+ fun.getNome() + "','" + fun.getSenha() + "','" + fun.getEmail() + "')";
		con.executaSQL(sqlFuncionario);
		con.fecharConexao();

	}
		
}
