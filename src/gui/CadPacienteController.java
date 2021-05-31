package gui;

import entidades.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import servico.CadastroBd;

import java.awt.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class CadPacienteController implements Initializable {

    @FXML
    private Label lbNomeCompleto;

    @FXML
    private TextField txtNomeCompleto;

    @FXML
    private Label lbDataNasc;

    @FXML
    private TextField txtDataNasc;

    @FXML
    private Label lbCPF;

    @FXML
    private TextField txtCPF;

    @FXML
    private Label lbRG;

    @FXML
    private TextField txtRG;

    @FXML
    private Label lbOrgEmissor;

    @FXML
    private TextField txtOrgEmissor;

    @FXML
    private Label lbNumSUS;

    @FXML
    private TextField txtNumSUS;

    @FXML
    private Label lbFone;

    @FXML
    private TextField txtFone;

    @FXML
    private Label lbCelular;

    @FXML
    private TextField txtCelular;

    @FXML
    private Label lbEmail;

    @FXML
    private TextField txtEmail;

    @FXML
    private Label lbLogradouro;

    @FXML
    private TextField txtLogradouro;

    @FXML
    private Label lbNumero;

    @FXML
    private TextField txtNumCasa;

    @FXML
    private Label lbBairro;

    @FXML
    private TextField txtBairro;

    @FXML
    private Label lbCidade;

    @FXML
    private TextField txtCidade;

    @FXML
    private Label lbUF;

    @FXML
    private TextField txtUF;

    @FXML
    private Label lbCEP;

    @FXML
    private TextField txtCEP;

    @FXML
    private Label lbComplemento;

    @FXML
    private TextField txtComplemento;

    @FXML
    private ComboBox<String> cbxVacina;

    @FXML
    private Label lbVacina;

    @FXML
    private Label lbPrimeiraDose;

    @FXML
    private TextField txtDataPrimeiraVacina;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnCancelar;

    Alert dialogoConf = new Alert(Alert.AlertType.CONFIRMATION);
    Alert dialogoInf = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    public void btnCancelar(ActionEvent event) {
        Main.trocaTela("menuPrincipal");
        this.txtNomeCompleto.clear(); this.txtDataNasc.clear(); this.txtCPF.clear(); this.txtRG.clear(); this.txtOrgEmissor.clear();
        this.txtNumSUS.clear(); this.txtFone.clear(); this.txtCelular.clear(); this.txtEmail.clear(); this.txtLogradouro.clear();
        this.txtNumCasa.clear(); this.txtBairro.clear(); this.txtCidade.clear(); this.txtUF.clear(); this.txtCEP.clear(); this.txtComplemento.clear();
        this.txtDataPrimeiraVacina.clear();
    }

    @FXML
    public String Select(ActionEvent event) {
        return cbxVacina.getSelectionModel().getSelectedItem();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("CoronaVac",
                "Oxford/Astrazeneca");
        cbxVacina.setItems(list);
    }

    @FXML
    public void btnCadastrar(ActionEvent event) {

        Paciente paciente = new Paciente();
        Documentos doc = new Documentos();
        Contatos contato = new Contatos();
        Endereco end = new Endereco();
        Vacina vac = new Vacina();

        try {

            paciente.setNomeCompleto(txtNomeCompleto.getText());

            if (paciente.getNomeCompleto().equals("")) {
                dialogoInf.setTitle("Nome paciente");
                dialogoInf.setHeaderText("Campo Obrigatório!\nPreencha com nome completo: "
                        + "Digite o Nome Completo do paciente: ");
                dialogoInf.showAndWait();
            }

            DateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatBR.parse(txtDataNasc.getText());

            DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
            String dataConvertida = formatUS.format(date);
            LocalDate data = LocalDate.parse(dataConvertida);

            paciente.setDataNasc(data);

            doc.setCpf(txtCPF.getText());

            if (doc.pesquisarCpf()) {
                dialogoInf.setTitle("CPF paciente");
                dialogoInf.setHeaderText("CFP já cadastrado!\nDigitar um CPF valido não cadastrado\nDigite o CPF do paciente: ");
                dialogoInf.showAndWait();
            }else if (!doc.isCPF()) {
                dialogoInf.setTitle("CPF paciente");
                dialogoInf.setHeaderText("CFP já cadastrado!\nDigitar um CPF valido não cadastrado\nDigite o CPF do paciente: ");
                dialogoInf.showAndWait();
            } else {

                doc.setRg(txtRG.getText());

                doc.setOrgEmissor(txtOrgEmissor.getText().toUpperCase());

                doc.setNumSus(txtNumSUS.getText());
                paciente.setDoc(doc);

                contato.setFone(txtFone.getText());

                contato.setCelular(txtCelular.getText());

                contato.setEmail(txtEmail.getText());

                if (contato.getEmail() == null || contato.getEmail().equals("")) {
                    contato.setEmail("");
                } else if (!Contatos.isEmailValido(contato.getEmail())) {
                    dialogoInf.setTitle("E-mail paciente");
                    dialogoInf.setHeaderText("E-mail invalido!\nDigitar um E-mail valido:\nDigite seu E-mail: ");
                    dialogoInf.showAndWait();
                }

                paciente.setContatos(contato);

                end.setRua(txtLogradouro.getText());

                end.setNum(txtNumCasa.getText());

                end.setBairro(txtBairro.getText());

                end.setCidade(txtCidade.getText());

                end.setUf(txtUF.getText().toUpperCase());

                end.setComplemento(txtComplemento.getText());

                end.setCep(txtCEP.getText());
                paciente.setEndereco(end);

                vac.setTpVacina(cbxVacina.getSelectionModel().getSelectedItem());

                if (vac.getTpVacina().equals("CoronaVac")) {
                    formatBR = new SimpleDateFormat("dd/MM/yyyy");
                    date = formatBR.parse(txtDataPrimeiraVacina.getText());

                    formatUS = new SimpleDateFormat("yyyy-MM-dd");
                    dataConvertida = formatUS.format(date);
                    LocalDate dataVac = LocalDate.parse(dataConvertida);
                    vac.setDataVacina1(dataVac);
                    dataVac = vac.getDataVacina1().plusDays(21);
                    vac.setDataVacina2(dataVac);

                } else if (vac.getTpVacina().equals("Oxford/Astrazeneca")) {
                    formatBR = new SimpleDateFormat("dd/MM/yyyy");
                    date = formatBR.parse(txtDataPrimeiraVacina.getText());

                    formatUS = new SimpleDateFormat("yyyy-MM-dd");
                    dataConvertida = formatUS.format(date);
                    LocalDate dataVac = LocalDate.parse(dataConvertida);
                    vac.setDataVacina1(dataVac);
                    dataVac = vac.getDataVacina1().plusDays(90);
                    vac.setDataVacina2(dataVac);
                }

                paciente.setVacina(vac);

                CadastroBd.cadastroPaciente(paciente);

                dialogoConf.setTitle("Cadastro de paciente");
                dialogoConf.setHeaderText("Paciente cadastrado");
                dialogoConf.showAndWait();

                Main.trocaTela("menuPrincipal");
                this.txtNomeCompleto.clear(); this.txtDataNasc.clear(); this.txtCPF.clear(); this.txtRG.clear(); this.txtOrgEmissor.clear();
                this.txtNumSUS.clear(); this.txtFone.clear(); this.txtCelular.clear(); this.txtEmail.clear(); this.txtLogradouro.clear();
                this.txtNumCasa.clear(); this.txtBairro.clear(); this.txtCidade.clear(); this.txtUF.clear(); this.txtCEP.clear(); this.txtComplemento.clear();
                this.txtDataPrimeiraVacina.clear();

            }
        } catch (HeadlessException | NullPointerException | ParseException | NumberFormatException e) {
            dialogoConf.setTitle("Login Administrador");
            dialogoConf.setHeaderText(e.getMessage());
            dialogoConf.showAndWait();
        }
    }
}
