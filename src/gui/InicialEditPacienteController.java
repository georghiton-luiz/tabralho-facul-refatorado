package gui;

import javafx.event.Event;
import javafx.fxml.FXML;

public class InicialEditPacienteController {

    @FXML
    public void menuPrincipal (Event e){
        Main.trocaTela("menuPrincipal");
    }

    @FXML
    public void princEdPac (Event e){
        Main.trocaTela("princEdPac");
    }
}
