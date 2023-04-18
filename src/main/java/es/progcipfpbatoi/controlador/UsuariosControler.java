package es.progcipfpbatoi.controlador;

import es.progcipfpbatoi.modelo.entidades.Usuario;
import es.progcipfpbatoi.modelo.repositorios.UsuariosRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UsuariosControler implements Initializable {

    private final UsuariosRepository usuariosRepository;

    public UsuariosControler(UsuariosRepository usuariosRepository) {

        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void addNewUser(MouseEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FormularioUsuarioController formularioUsuarioController = new FormularioUsuarioController();
            ChangeScene.change(stage, formularioUsuarioController, "/vista/insert_users.fxml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
