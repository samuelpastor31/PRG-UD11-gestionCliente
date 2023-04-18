package es.progcipfpbatoi.controlador;

import es.progcipfpbatoi.modelo.entidades.Usuario;
import es.progcipfpbatoi.modelo.repositorios.UsuariosRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UsuarioDetailControler implements Initializable {

    private Usuario usuario;
    private final UsuariosRepository usuariosRepository;

    public UsuarioDetailControler(Usuario usuario, UsuariosRepository usuariosRepository) {
        this.usuario = usuario;
        this.usuariosRepository = usuariosRepository;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void handleButtonNewUser(ActionEvent event){
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            UsuarioController usuarioController = new UsuarioController();
            ChangeScene.change(stage, usuarioController, "/vista/insert_users.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
