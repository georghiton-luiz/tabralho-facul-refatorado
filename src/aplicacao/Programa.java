package aplicacao;



import javax.swing.JOptionPane;
import servico.*;

public class Programa {

	/* static void main(String[] args) {

		CadastroPaciente cad = new CadastroPaciente();
		PesquisaBD pesquisa = new PesquisaBD();
		DeleteRegistroBD deletar = new DeleteRegistroBD();
		AlterarRegistroBD alter = new AlterarRegistroBD();
		RelatorioBD relatorio = new RelatorioBD();

		JOptionPane.showMessageDialog(null, "Bem-vindo ao cadastro de vacinação contra o COVID-19");
		String nome = JOptionPane.showInputDialog("Login");
		String senha = JOptionPane.showInputDialog("Senha");
		
		int op, op2;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(null, """
					Escolha a função desejada:
					[1] Cadastrar
					[2] Pesquisar
					[3] Alterar
					[4] Deletar
					[5] Relatório
					[0] Sair
					Digite sua opção:\s"""));

			switch (op) {
			case 1:
				op2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
					Escolha a função desejada:
					[1] Cadastrar Paciente
					[2] Cadastrar Funcionário
					[0] Sair
					Digite sua opção:\s"""));
				switch (op2) {
					case 1 -> {
						cad.CadastroPaciente();
					}
					case 2 -> {
						CadastroFuncionario.cadFun();
						JOptionPane.showMessageDialog(null, "Funcionario cadastrado");
					}
					case 0 -> JOptionPane.showMessageDialog(null, "Saindo do menu de cadastro");
					default -> JOptionPane.showMessageDialog(null, "Opção invalida!\nEscolha uma opção valida:");
				}
				break;
			case 2:
				pesquisa.pesquisarCadastro();
				JOptionPane.showMessageDialog(null, pesquisa.resultadoPesquisa());				
				break;
			case 3:
				alter.alterarCadastro();
				break;
			case 4:
				try {
					if(deletar.deletarCadastro()) {
						JOptionPane.showMessageDialog(null, "Cadastro do paciente deletado");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}				
				break;
				case 5:
					try {
						relatorio.relatorio();
					} catch (Exception e) {
						e.printStackTrace();

					}
					break;
			case 0:
				JOptionPane.showMessageDialog(null, "Saindo do aplicativo");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção invalida!\nEscolha uma opção valida:");
			}
		} while (op != 0);
	}*/
}
