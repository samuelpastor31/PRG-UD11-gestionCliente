package es.progcipfpbatoi;

import es.progcipfpbatoi.controlador.ChangeScene;
import es.progcipfpbatoi.controlador.FormularioUsuarioController;
import es.progcipfpbatoi.controlador.UsuariosControler;
import es.progcipfpbatoi.modelo.repositorios.InMemoryUsuariosRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
        UsuariosControler usuarioController = new UsuariosControler(inMemoryUsuariosRepository);
        ChangeScene.change(stage,usuarioController,"/vista/users_list.fxml" );

    }


    public static void main(String[] args) {
        launch();
    }

}