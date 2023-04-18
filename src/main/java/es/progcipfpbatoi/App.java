package es.progcipfpbatoi;

import es.progcipfpbatoi.controlador.ChangeScene;
import es.progcipfpbatoi.controlador.UsuarioController;
import es.progcipfpbatoi.modelo.repositorios.InMemoryUsuariosRepository;
import es.progcipfpbatoi.modelo.repositorios.UsuariosRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader();

        InMemoryUsuariosRepository inMemoryUsuariosRepository= new InMemoryUsuariosRepository();
        UsuarioController usuarioController = new UsuarioController();
        ChangeScene.change(stage,usuarioController,"/vista/users_list.fxml" );

    }


    public static void main(String[] args) {
        launch();
    }

}