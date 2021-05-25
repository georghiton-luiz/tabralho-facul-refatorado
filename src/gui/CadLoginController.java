package gui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CadLoginController {

    @FXML
    private TextField txt1;

    @FXML
    public void leiMais (Event e){
        Main.trocaTela("leiaMais");
    }

    @FXML
    public void cadFun (Event e){
        Main.trocaTela("cadFun");
    }

    @FXML
    public void menuPricipal (Event e){
        Main.trocaTela("menuPrincipal");
    }


}
