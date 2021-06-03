package gui;

import entidades.Funcionario;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import servico.CadastroBd;
import servico.Conexao;

import java.sql.ResultSet;

public class CadastroFunController {

    @FXML
    public Label lblNomeCompleto;

    @FXML
    private TextField txtNomeCompleto;

    @FXML
    public Label lblDoc;

    @FXML
    private TextField txtDoc;

    @FXML
    public Label lblCargo;

    @FXML
    private TextField txtCargo;

    @FXML
    public Label lblUserName;

    @FXML
    private TextField txtUserName;

    @FXML
    public Label lblEmail;

    @FXML
    private TextField txtEmail;

    @FXML
    public Label lblSenha;

    @FXML
    private PasswordField txtSenha;

    @FXML
    public Label lblConfirmaSenha;

    @FXML
    private PasswordField txtConfirmarSenha;

    @FXML
    private Label lblErroConfSenha;

    @FXML
    public Button btnCadastrar;

    @FXML
    public Button btnCancelar;



    //Cadastra funcionario se todas as condições forem true
    @FXML
    void btnCadastrar() {

        String query = "select * from cad_funcionario";
        String userName = "";
        String email = "";
        String doc = "";

        ResultSet rs = Conexao.getInstance().executaBusca(query);
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);

        try {
            while (rs.next()){
                userName = rs.getString("user_name_fun");
                email = rs.getString("email_fun");
                doc = rs.getString("doc_fun");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //verificar se ja existe o usename e email
        if(this.txtUserName.getText().equals(userName) || this.txtEmail.getText().equals(email) || this.txtDoc.getText().equals(doc)){
            dialogoInfo.setTitle("Login usuário");
            dialogoInfo.setHeaderText("Nome de usuario e/ou email e/ou documento já existem");
            dialogoInfo.showAndWait();
        }

        //confimação de cadastro da senha do funcionario
        if(this.txtSenha.getText().equals(this.txtConfirmarSenha.getText())) {

            CadastroBd.cadastroFuncionario(new Funcionario(this.txtNomeCompleto.getText(), this.txtUserName.getText(), this.txtSenha.getText(), this.txtDoc.getText(), this.txtEmail.getText(), this.txtCargo.getText()));
            Main.trocaTela("cadLogin");
            this.txtNomeCompleto.clear();
            this.txtUserName.clear();
            this.txtSenha.clear();
            this.txtConfirmarSenha.clear();
            this.txtDoc.clear();
            this.txtEmail.clear();
        }else{
            lblErroConfSenha.setText("Senha não conrresponde!");
        }
    }

    //Chama a tela de login ao clicar em Logout
    @FXML
    void btnCancelar() {
        Main.trocaTela("menuPrincipalAdmin");
    }
}
