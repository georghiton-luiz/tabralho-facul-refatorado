package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class PesquisarPacienteController {

    @FXML
    private TextField txCPF;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnDeletar;

    @FXML
    private Tab tabDadosPaciente;

    @FXML
    private TableColumn<?, ?> colNome;

    @FXML
    private TableColumn<?, ?> colDataNasc;

    @FXML
    private TableColumn<?, ?> colRG;

    @FXML
    private TableColumn<?, ?> colOrgEmissor;

    @FXML
    private TableColumn<?, ?> colCPF;

    @FXML
    private TableColumn<?, ?> colNumSUS;

    @FXML
    private Tab tbContato;

    @FXML
    private TableColumn<?, ?> colFone;

    @FXML
    private TableColumn<?, ?> colCel;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private Tab tbEndereco;

    @FXML
    private TableColumn<?, ?> colLogradouro;

    @FXML
    private TableColumn<?, ?> colNum;

    @FXML
    private TableColumn<?, ?> colBairro;

    @FXML
    private TableColumn<?, ?> colCidade;

    @FXML
    private TableColumn<?, ?> colUF;

    @FXML
    private TableColumn<?, ?> colComp;

    @FXML
    private TableColumn<?, ?> colCEP;

    @FXML
    private Tab tbDadosVacina;

    @FXML
    private TableColumn<?, ?> colDataPriVac;

    @FXML
    private TableColumn<?, ?> colDataSegVac;

    @FXML
    private TableColumn<?, ?> colTipoVac;

}
