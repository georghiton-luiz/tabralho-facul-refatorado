package gui;

import javafx.fxml.FXML;

public class MenuPrincipalAdminController {

    @FXML
    public void btnCadastroPaciente (){
        Main.trocaTela("cadPac");
    }

    @FXML
    public void btnLogout() {
        Main.trocaTela("cadLogin");
    }

    @FXML
    public void btnEditarPaciente(){
        Main.trocaTela("editPacAdmin");
    }

    @FXML
    public void btnCadastrarFuncionario (){
            Main.trocaTela("cadFun");
    }
}
