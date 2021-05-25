package gui;

import entidades.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import servico.CadastroBd;

import javax.swing.*;

public class CadastroFunController {

    @FXML
    private TextField nome;

    @FXML
    private TextField doc;

    @FXML
    private PasswordField senha;

    @FXML
    private PasswordField confSenha;

    @FXML
    private TextField email;

    @FXML
    private Button btLogin;



    @FXML
    void btLogin(ActionEvent event) {

        if(senha.getText().equals(confSenha.getText())) {

            CadastroBd.cadastroFuncionario(new Funcionario(this.nome.getText(), this.senha.getText(), this.doc.getText(), this.email.getText()));
            Main.trocaTela("main");
            this.nome.clear();
            this.senha.clear();
            this.confSenha.clear();
            this.doc.clear();
            this.email.clear();
        }else{
            JOptionPane.showMessageDialog(null,"Senha não conrresponde!");
        }
    }

    @FXML
    void menuPrincipal(ActionEvent event) {
        Main.trocaTela("cadLogin");

    }
}
