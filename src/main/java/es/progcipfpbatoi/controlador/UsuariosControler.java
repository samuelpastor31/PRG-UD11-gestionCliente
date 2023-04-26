package es.progcipfpbatoi.controlador;

import es.progcipfpbatoi.modelo.entidades.Usuario;
import es.progcipfpbatoi.modelo.repositorios.UsuariosRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UsuariosControler implements Initializable {

    private final UsuariosRepository usuariosRepository;

    @FXML
    private ListView<Usuario> usuarioListView;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchButton;

    public UsuariosControler(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usuarioListView.setItems(getData());

    }

    private ObservableList<Usuario> getData(){
        return FXCollections.observableArrayList(usuariosRepository.findAll());
    }

    @FXML
    private void addNewUser(MouseEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FormularioUsuarioController formularioUsuarioController = new FormularioUsuarioController(usuariosRepository);
            ChangeScene.change(stage, formularioUsuarioController, "/vista/insert_users.fxml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private String searchTasks() {
        return searchBar.getText();
        }

    @FXML
    private void buttonSearch(){
        usuarioListView.getItems().clear();
        ArrayList<Usuario> usuariosFiltrados = usuariosRepository.findAll(searchTasks());
        usuarioListView.getItems().addAll(usuariosFiltrados);
    }
}
