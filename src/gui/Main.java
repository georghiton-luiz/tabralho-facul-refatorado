package gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

import static javafx.fxml.FXMLLoader.load;

public class Main extends Application {

    private static Stage stage;
    private static Scene cadastroLgin;
    private static Scene menuPrincipal;
    private static Scene menuPrincipalAdmin;
    private static Scene leiaMais;
    private static Scene cadastroFun;
    private static Scene cadPaciente;
    private static Scene editarPaciente;
    private static Scene recuperarSenha;
    private static Scene editarPacienteAdmin;



    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;

        primaryStage.setTitle("CadVacina");

        Parent fxmlCadLogin = load(Objects.requireNonNull(getClass().getResource("telaCadLogin.fxml")));
        cadastroLgin = new Scene(fxmlCadLogin, 1031, 613);

        Parent fxmlLeia = load(Objects.requireNonNull(getClass().getResource("telaLeiaMais.fxml")));
        leiaMais = new Scene(fxmlLeia, 1031, 613);

        Parent fxmlCadFun = load(Objects.requireNonNull(getClass().getResource("telaCadastroFuncionario.fxml")));
        cadastroFun = new Scene(fxmlCadFun, 1031, 613);

        Parent fxmlCadPac = load(Objects.requireNonNull(getClass().getResource("telaCadastroPaciente.fxml")));
        cadPaciente = new Scene(fxmlCadPac, 1031, 613);

        Parent fxmlMenuPrincipal = load(Objects.requireNonNull(getClass().getResource("telaMenuPrincipal.fxml")));
        menuPrincipal = new Scene(fxmlMenuPrincipal, 1031, 613);

        Parent fxmlMenuPrincipalAdmin = load(Objects.requireNonNull(getClass().getResource("telaMenuPrincipalAdmin.fxml")));
        menuPrincipalAdmin = new Scene(fxmlMenuPrincipalAdmin, 1031, 613);

        Parent fxmlEditarPaciente = load(Objects.requireNonNull(getClass().getResource("telaEditarCadastroPaciente.fxml")));
        editarPaciente = new Scene(fxmlEditarPaciente, 1031, 613);

        Parent fxmlEditarPacienteAdmin = load(Objects.requireNonNull(getClass().getResource("telaEditarCadastroPacienteAdmin.fxml")));
        editarPacienteAdmin = new Scene(fxmlEditarPacienteAdmin, 1031, 613);

        Parent fxmlRecuperarSenha = load(Objects.requireNonNull(getClass().getResource("telaFormRecuperarSenha.fxml")));
        recuperarSenha = new Scene(fxmlRecuperarSenha, 1031, 613);

        primaryStage.setScene(cadastroLgin);
        primaryStage.show();
    }

    public static void trocaTela(String scr){
        switch (scr) {
            case "cadLogin" -> stage.setScene(cadastroLgin);
            case "menuPrincipal" -> stage.setScene(menuPrincipal);
            case "menuPrincipalAdmin" -> stage.setScene(menuPrincipalAdmin);
            case "leiaMais" -> stage.setScene(leiaMais);
            case "cadFun" -> stage.setScene(cadastroFun);
            case "cadPac" -> stage.setScene(cadPaciente);
            case "editPac" -> stage.setScene(editarPaciente);
            case "editPacAdmin" -> stage.setScene(editarPacienteAdmin);
            case "recSenha" -> stage.setScene(recuperarSenha);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
