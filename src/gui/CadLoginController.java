package gui;

import javafx.event.Event;
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
    private Hyperlink lnkEsqueceuSenha;

    @FXML
    public void btnLeiMais (Event event){
        Main.trocaTela("leiaMais");
    }

    //Login ADMIN para cadastro de funcionario
    @FXML
    public void btnCadastrar (Event e){

        if(txtLogin.getText().equals("admin") && txtSenha.getText().equals("root")){
            Main.trocaTela("cadFun");
            txtLogin.clear();
            txtSenha.clear();
        }else{
            lblErroLogin.setText("Login de Administrador invalido!");
            txtLogin.clear();
            txtSenha.clear();
        }
    }

    //Login para cadastro de paciente
    @FXML
    public void btnEntrar (Event event){

        String query = "select * from cad_funcionario";
        String tempUserName;
        String tempEmail;
        String tempSenha;
        String auxUserName = null;
        String auxEmail = null;
        String auxSenha = null;

        ResultSet rs = Conexao.getInstance().executaBusca(query);

        //Login ADMIN para cadastro de paciente
        if(txtLogin.getText().equals("admin") && txtSenha.getText().equals("root")){
            Main.trocaTela("menuPrincipal");
            txtLogin.clear();
            txtSenha.clear();
        //Login do funcionario para cadastro de paciente
        }else if(txtLogin.getText() != null){
            try {
                while (rs.next()){
                    tempUserName = rs.getString("user_name_fun");
                    tempEmail = rs.getString("email_fun");
                    tempSenha = rs.getString("senha_fun");
                    if(txtLogin.getText().equals(tempUserName) || txtLogin.getText().equals(tempEmail) && txtSenha.getText().equals(tempSenha)){
                        auxUserName = tempUserName;
                        auxEmail = tempEmail;
                        auxSenha = tempSenha;
                    }
                }

                if(txtLogin.getText().equals(auxUserName) || txtLogin.getText().equals(auxEmail) && txtSenha.getText().equals(auxSenha)){
                    Main.trocaTela("menuPrincipal");
                    txtLogin.clear();
                    txtSenha.clear();
                }else {
                    lblErroLogin.setText("Login e/ou senha invalido");

                }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        }
    }
}
