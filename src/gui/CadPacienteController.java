package gui;

import entidades.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import servico.CadastroBd;

import javax.swing.*;
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
    private TextField nome;

    @FXML
    private TextField dataNasc;

    @FXML
    private TextField CPF;

    @FXML
    private TextField RG;

    @FXML
    private TextField orgEmissor;

    @FXML
    private TextField numSUS;

    @FXML
    private TextField foneFixo;

    @FXML
    private TextField celular;

    @FXML
    private TextField email;

    @FXML
    private TextField logradouro;

    @FXML
    private TextField numCasa;

    @FXML
    private TextField bairro;

    @FXML
    private TextField cidade;

    @FXML
    private TextField UF;

    @FXML
    private TextField complemento;

    @FXML
    private TextField CEP;

    @FXML
    private ComboBox<?> vacina;

    @FXML
    private TextField dataPrimeirdaDose;

    @FXML
    private Button btLogin;

    @FXML
    private ComboBox<String> tpVacina;

    @FXML
    public TextField getNome() {
        return nome;
    }

    @FXML
    public TextField getDataNasc() {
        return dataNasc;
    }

    @FXML
    public TextField getCPF() {
        return CPF;
    }

    @FXML
    public TextField getRG() {
        return RG;
    }

    @FXML
    public TextField getOrgEmissor() {
        return orgEmissor;
    }

    @FXML
    public TextField getNumSUS() {
        return numSUS;
    }

    @FXML
    public TextField getFoneFixo() {
        return foneFixo;
    }

    @FXML
    public TextField getCelular() {
        return celular;
    }

    @FXML
    public TextField getEmail() {
        return email;
    }

    @FXML
    public TextField getLogradouro() {
        return logradouro;
    }

    @FXML
    public TextField getNumCasa() {
        return numCasa;
    }

    @FXML
    public TextField getBairro() {
        return bairro;
    }

    @FXML
    public TextField getCidade() {
        return cidade;
    }

    @FXML
    public TextField getUF() {
        return UF;
    }

    @FXML
    public TextField getComplemento() {
        return complemento;
    }

    @FXML
    public TextField getCEP() {
        return CEP;
    }

    @FXML
    public TextField getDataPrimeirdaDose() {
        return dataPrimeirdaDose;
    }

    @FXML
    void menuPrincipal(ActionEvent event) {
        Main.trocaTela("menuPrincipal");
        this.nome.clear(); this.dataNasc.clear(); this.CPF.clear(); this.RG.clear(); this.orgEmissor.clear();
        this.numSUS.clear(); this.foneFixo.clear(); this.celular.clear(); this.email.clear(); this.logradouro.clear();
        this.numCasa.clear(); this.bairro.clear(); this.cidade.clear(); this.UF.clear(); this.CEP.clear(); this.complemento.clear();
        this.dataPrimeirdaDose.clear();
    }

    @FXML
    public String Select(ActionEvent event) {
        return tpVacina.getSelectionModel().getSelectedItem().toString();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("CoronaVac",
                "Oxford/Astrazeneca");
        tpVacina.setItems(list);
    }

    @FXML
    public void btLogin(ActionEvent event) {

        Paciente paciente = new Paciente();
        Documentos doc = new Documentos();
        Contatos contato = new Contatos();
        Endereco end = new Endereco();
        Vacina vac = new Vacina();

        try {

            paciente.setNomeCompleto(getNome().getText());

            if (paciente.getNomeCompleto().equals("")) {
                JOptionPane.showMessageDialog(null, "Campo Obrigatório!\nPreencha com nome completo: "
                        + "Digite o Nome Completo do paciente: ");
            }

            DateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatBR.parse(getDataNasc().getText());

            DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
            String dataConvertida = formatUS.format(date);
            LocalDate data = LocalDate.parse(dataConvertida);

            paciente.setDataNasc(data);

            doc.setCpf(getCPF().getText());

            if (doc.pesquisarCpf()) {
                JOptionPane.showMessageDialog(null, "CFP já cadastrado!\nDigitar um CPF valido não cadastrado\nDigite o CPF do paciente: ");
            }else if (!doc.isCPF()) {
                JOptionPane.showMessageDialog(null, "CFP invalido!\nDigitar um CPF valido!\nDigite o CPF do paciente: ");
            } else {

                doc.setRg(getRG().getText());

                doc.setOrgEmissor(getOrgEmissor().getText().toUpperCase());

                doc.setNumSus(getNumSUS().getText());
                paciente.setDoc(doc);

                contato.setFone(getFoneFixo().getText());

                contato.setCelular(getCelular().getText());

                contato.setEmail(getEmail().getText());

                if (contato.getEmail() == null || contato.getEmail().equals("")) {
                    contato.setEmail("");
                } else if (!Contatos.isEmailValido(contato.getEmail())) {
                    JOptionPane.showMessageDialog(null, "E-mail invalido!\nDigitar um E-mail valido:\nDigite seu E-mail: ");
                }

                paciente.setContatos(contato);

                end.setRua(getLogradouro().getText());

                end.setNum(getNumCasa().getText());

                end.setBairro(getBairro().getText());

                end.setCidade(getCidade().getText());

                end.setUf(getUF().getText().toUpperCase());

                end.setComplemento(getComplemento().getText());

                end.setCep(getCEP().getText());
                paciente.setEndereco(end);

                vac.setTpVacina(tpVacina.getSelectionModel().getSelectedItem().toString());

                if (vac.getTpVacina().equals("CoronaVac")) {
                    formatBR = new SimpleDateFormat("dd/MM/yyyy");
                    date = formatBR.parse(getDataPrimeirdaDose().getText());

                    formatUS = new SimpleDateFormat("yyyy-MM-dd");
                    dataConvertida = formatUS.format(date);
                    LocalDate dataVac = LocalDate.parse(dataConvertida);
                    vac.setDataVacina1(dataVac);
                    dataVac = vac.getDataVacina1().plusDays(21);
                    vac.setDataVacina2(dataVac);

                } else if (vac.getTpVacina().equals("Oxford/Astrazeneca")) {
                    formatBR = new SimpleDateFormat("dd/MM/yyyy");
                    date = formatBR.parse(getDataPrimeirdaDose().getText());

                    formatUS = new SimpleDateFormat("yyyy-MM-dd");
                    dataConvertida = formatUS.format(date);
                    LocalDate dataVac = LocalDate.parse(dataConvertida);
                    vac.setDataVacina1(dataVac);
                    dataVac = vac.getDataVacina1().plusDays(90);
                    vac.setDataVacina2(dataVac);
                }

                paciente.setVacina(vac);

                CadastroBd.cadastroPaciente(paciente, doc, end, contato, vac);

                JOptionPane.showMessageDialog(null, "Paciente cadastrado");

                Main.trocaTela("menuPrincipal");
                this.nome.clear(); this.dataNasc.clear(); this.CPF.clear(); this.RG.clear(); this.orgEmissor.clear();
                this.numSUS.clear(); this.foneFixo.clear(); this.celular.clear(); this.email.clear(); this.logradouro.clear();
                this.numCasa.clear(); this.bairro.clear(); this.cidade.clear(); this.UF.clear(); this.CEP.clear(); this.complemento.clear();
                this.dataPrimeirdaDose.clear();

            }
        } catch (HeadlessException | NullPointerException | ParseException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
