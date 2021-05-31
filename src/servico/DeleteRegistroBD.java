package servico;

import javax.swing.JOptionPane;

import entidades.Documentos;

public class DeleteRegistroBD {
	
	Documentos doc = new Documentos();

	public DeleteRegistroBD() {

	}

	public boolean deletarCadastro() {

		doc.setCpf(JOptionPane.showInputDialog("Digite o CPF do paciente:"));
		try {
			while (!doc.isCPF()) {
				doc.setCpf(JOptionPane.showInputDialog("CFP invalido!\nDigitar um CPF valido: "));
			}
			if(!doc.pesquisarCpf()) {
				JOptionPane.showMessageDialog(null, "CPF não encontrado");
			}else {
				String sql = "delete from dados_paciente where cpf_paciente = '" + doc.getCpfFormatado() + "'";
				Conexao.getInstance().executaSQL(sql);
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

}
