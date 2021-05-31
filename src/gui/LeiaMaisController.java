package gui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LeiaMaisController {

    @FXML
    private Button btnLogin;

    @FXML
    public void btnLogin (Event e){
        Main.trocaTela("cadLogin");
    }
}
