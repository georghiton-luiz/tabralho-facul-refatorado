package gui;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuPrincipalController {


    @FXML
    private Button btnCadastro;

    @FXML
    private Button bntEditar;

    @FXML
    private Button bntRelatorio;

    @FXML
    private Label lbUsuario;

    @FXML
    private Label lbCargo;

    @FXML
    private Button btnLogout;

    @FXML
    public void btnCadastro (Event e){
        Main.trocaTela("cadPac");
    }

    @FXML
    public void bntEditar (Event e){
        Main.trocaTela("inEdPac");
    }

    @FXML
    void btnLogout(ActionEvent event) {
        Main.trocaTela("cadLogin");
    }

//    @FXML
//    public void btInicialPesquisaPaciente (Event e){
//        Main.trocaTela("inPeqPac");
//    }
//
//    @FXML
//    public void cadPaciente (Event e){
//        Main.trocaTela("cadPac");
//    }
//
//    @FXML
//    public void cadPaciente (Event e){
//        Main.trocaTela("cadPac");
//    }
//
//    @FXML
//    public void cadPaciente(Event e){
//        Main.trocaTela("cadPac");
//    }
}
