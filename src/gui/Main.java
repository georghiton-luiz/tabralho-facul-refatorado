package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    private static Stage stage;
    private static Scene cadastroLgin;
    private static Scene menuPrincipal;
    private static Scene leiaMais;
    private static Scene cadastroFun;
    private static Scene cadPaciente;
    private static Scene inicialPesquisaPaciente;
    private static Scene pesquisarPaciente;
    private static Scene inicialEditPaciente;
    private static Scene principalEditPaciente;


    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;

        primaryStage.setTitle("CadVacina");

        Parent fxmlCadLogin = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telaCadLogin.fxml")));
        cadastroLgin = new Scene(fxmlCadLogin, 1031, 613);

        Parent fxmlLeia = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telaLeiaMais.fxml")));
        leiaMais = new Scene(fxmlLeia, 1031, 613);

        Parent fxmlCadFun = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telaCadastroFuncionario.fxml")));
        cadastroFun = new Scene(fxmlCadFun, 1031, 613);

        Parent fxmlCadPac = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telaCadastroPaciente.fxml")));
        cadPaciente = new Scene(fxmlCadPac, 1031, 613);

        Parent fxmlMenuPrincipal = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telaMenuPrincipal.fxml")));
        menuPrincipal = new Scene(fxmlMenuPrincipal, 1031, 613);

        primaryStage.setScene(cadastroLgin);
        primaryStage.show();
    }

    public static void trocaTela(String scr){
        switch (scr) {
            case "cadLogin" -> stage.setScene(cadastroLgin);
            case "menuPrincipal" -> stage.setScene(menuPrincipal);
            case "leiaMais" -> stage.setScene(leiaMais);
            case "cadFun" -> stage.setScene(cadastroFun);
            case "cadPac" -> stage.setScene(cadPaciente);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
