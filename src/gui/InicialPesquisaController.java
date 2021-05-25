package gui;

import entidades.Documentos;
import javafx.event.Event;
import javafx.fxml.FXML;
import servico.Conexao;

import javax.swing.*;

public class InicialPesquisaController {

    protected String sql;

    Documentos doc = new Documentos();
    Conexao con = new Conexao();

    public InicialPesquisaController() {
        super();
    }

    @FXML
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

    @FXML
    public void peqPac (Event e){
        Main.trocaTela("peqPac");
    }

    @FXML
    public void menuPrincipal(Event e) {
        Main.trocaTela("menuPrincipal");
    }
}
