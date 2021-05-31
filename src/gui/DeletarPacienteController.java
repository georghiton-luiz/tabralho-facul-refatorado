package gui;

import entidades.Documentos;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import servico.Conexao;

import javax.swing.*;

public class DeletarPacienteController {

    @FXML
    private Button btDeletarCadastro;

    Documentos doc = new Documentos();

    public DeletarPacienteController() {

    }

    @FXML
    public boolean btDeletarCadastro() {
        Conexao con = new Conexao();
        doc.setCpf(JOptionPane.showInputDialog("Digite o CPF do paciente:"));
        try {
            if (!doc.isCPF()) {
                doc.setCpf(JOptionPane.showInputDialog("CFP invalido!\nDigitar um CPF valido: "));
            }
            if(!doc.pesquisarCpf()) {
                JOptionPane.showMessageDialog(null, "CPF não encontrado");
            }else {
                String sql = "delete from dados_paciente where cpf_paciente = '" + doc.getCpfFormatado() + "'";
                con.executaSQL(sql);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

}
