package gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import servico.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CadLoginController {

    @FXML
    private Label lblErroLogin;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    public Button btnEsqueceuSenha;

    @FXML
    public Button btnLeiaMais;

    @FXML
    public Button btnEntrar;

    @FXML
    public void btnLeiMais (){
        Main.trocaTela("leiaMais");
    }

    //Login para cadastro de paciente
    @FXML
    public void btnEntrar (){

        String query = "select * from cad_funcionario";
        String tempUserName;
        String tempEmail;
        String tempSenha;

        ResultSet rs = Conexao.getInstance().executaBusca(query);

        //Login ADMIN para cadastro de paciente/funcionario
        if(txtLogin.getText().equals("admin") && txtSenha.getText().equals("root")){
            Main.trocaTela("menuPrincipalAdmin");
            txtLogin.clear();
            txtSenha.clear();
        //Login do funcionario para cadastro de paciente
        }else {
            if(txtLogin.getText() == null || txtLogin.getText().equals("")){
                lblErroLogin.setText("Preencha login e senha");
            }else {
                try {
                    while (rs.next()){
                        tempUserName = rs.getString("user_name_fun");
                        tempEmail = rs.getString("email_fun");
                        tempSenha = rs.getString("senha_fun");

                        if(txtLogin.getText().equals(tempUserName) || txtLogin.getText().equals(tempEmail) && txtSenha.getText().equals(tempSenha)){
                            Main.trocaTela("menuPrincipal");
                            lblErroLogin.setText("");
                            txtLogin.clear();
                            txtSenha.clear();
                        }else {
                            lblErroLogin.setText("Login e/ou senha invalido");
                        }
                    }
                } catch (SQLException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
        txtLogin.clear();
        txtSenha.clear();
    }

    //Simples recuperação de senha
    public void btnEsqueceuSenha(){

        Main.trocaTela("recSenha");
    }
}
