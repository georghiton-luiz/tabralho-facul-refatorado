package gui;

import gui.Main;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrincipalEditPacienteController {

    @FXML
    private Button btMenuPrincipal;

    @FXML
    public void btMenuPrincipal (Event e){
        Main.trocaTela("menuPrincipal");
    }


}
