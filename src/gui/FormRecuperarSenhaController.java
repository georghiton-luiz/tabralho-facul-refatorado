package gui;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import servico.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FormRecuperarSenhaController {


    @FXML
    private TextField txtNomeCompleto;

    @FXML
    private TextField txtDoc;

    @FXML
    private TextField txtEmail;

    @FXML
    private Label lblCamposObrig;



    @FXML
    public void btnEnviar() {
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);

        String query = "select * from cad_funcionario where nome_fun = '"+ txtNomeCompleto.getText() +"' and email_fun = '"+ txtEmail.getText() +"'";
        String tempNome = null;
        String tempDoc = null;
        String tempUserName = null;
        String tempEmail = null;
        String tempSenha = null;

        ResultSet rs = Conexao.getInstance().executaBusca(query);

        try {
            while (rs.next()) {

                tempNome = rs.getString("nome_fun");
                tempDoc = rs.getString("doc_fun");
                tempUserName = rs.getString("user_name_fun");
                tempEmail = rs.getString("email_fun");
                tempSenha = rs.getString("senha_fun");


            }
            if (txtEmail.getText().equals(tempEmail) && txtDoc.getText().equals(tempDoc) && txtNomeCompleto.getText().equals(tempNome)) {
                dialogoInfo.setTitle("Recuperar senha");
                dialogoInfo.setHeaderText("Seu eu username: " + tempUserName + "\nSua senha : " + tempSenha);
                dialogoInfo.showAndWait();
                txtNomeCompleto.clear();
                txtDoc.clear();
                txtEmail.clear();
                Main.trocaTela("cadLogin");

            } else if (txtEmail.getText().equals("") || txtDoc.getText().equals("") || txtNomeCompleto.getText().equals("")){
                lblCamposObrig.setText("Todos os campos são obrigatórios");
                txtNomeCompleto.clear();
                txtDoc.clear();
                txtEmail.clear();

            }else{
                dialogoInfo.setTitle("Recuperar senha");
                dialogoInfo.setHeaderText("Cadastro não existe");
                dialogoInfo.showAndWait();
                txtNomeCompleto.clear();
                txtDoc.clear();
                txtEmail.clear();
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnCancelar() {
        Main.trocaTela("cadLogin");
    }

}
