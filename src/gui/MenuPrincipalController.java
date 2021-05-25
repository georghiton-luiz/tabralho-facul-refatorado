package gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;

public class MenuPrincipalController {
    
    @FXML
    public void cadPaciente (Event e){
        Main.trocaTela("cadPac");
    }

    @FXML
    public void inEdPac (Event e){
        Main.trocaTela("inEdPac");
    }

    @FXML
    void cadLogin(ActionEvent event) {
        Main.trocaTela("cadLogin");

    }

    @FXML
    public void inPeqPac (Event e){
        Main.trocaTela("inPeqPac");
    }
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
