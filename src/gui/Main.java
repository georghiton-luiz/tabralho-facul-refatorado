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

        Parent fxmlCadLogin = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cadLogin.fxml")));
        cadastroLgin = new Scene(fxmlCadLogin, 1031, 613);

        Parent fxmlLeia = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("leiaMais.fxml")));
        leiaMais = new Scene(fxmlLeia, 1031, 613);

        Parent fxmlCadFun = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cadastroFun.fxml")));
        cadastroFun = new Scene(fxmlCadFun, 1031, 613);

        Parent fxmlCadPac = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cadPaciente.fxml")));
        cadPaciente = new Scene(fxmlCadPac, 1031, 613);

        Parent fxmlInEdPac = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inicialEditPaciente.fxml")));
        inicialEditPaciente = new Scene(fxmlInEdPac, 1031, 613);

        Parent fxmlPrincEditPac = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("principalEditPaciente.fxml")));
        principalEditPaciente = new Scene(fxmlPrincEditPac, 1031, 613);

        Parent fxmlMenuPrincipal = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menuPrincipal.fxml")));
        menuPrincipal = new Scene(fxmlMenuPrincipal, 1031, 613);

        Parent fxmlInicialPesquisarPac = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inicialPesquisa.fxml")));
        inicialPesquisaPaciente = new Scene(fxmlInicialPesquisarPac, 1031, 613);

        Parent fxmlPesquisarPac = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pesquisarPaciente.fxml")));
        pesquisarPaciente = new Scene(fxmlPesquisarPac, 1031, 613);


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
            case "inPeqPac" -> stage.setScene(inicialPesquisaPaciente);
            case "peqPac" -> stage.setScene(pesquisarPaciente);
            case "inEdPac" -> stage.setScene(inicialEditPaciente);
            case "princEdPac" -> stage.setScene(principalEditPaciente);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
