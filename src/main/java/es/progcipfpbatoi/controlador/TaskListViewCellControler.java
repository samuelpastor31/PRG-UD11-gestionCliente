package es.progcipfpbatoi.controlador;

import es.progcipfpbatoi.modelo.entidades.Usuario;
import es.progcipfpbatoi.modelo.repositorios.UsuariosRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class TaskListViewCellControler extends ListCell<Usuario> {

    @FXML
    private AnchorPane root;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Hyperlink detailLink;

    private UsuariosRepository usuariosRepository;

    private Usuario usuario;

    public TaskListViewCellControler(UsuariosRepository usuariosRepository){
        this.usuariosRepository = usuariosRepository;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/vista/list_item.fxml"));
        loader.setController(this);

        try {
            loader.load();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    @Override
    protected void updateItem(Usuario user, boolean empty){
        super.updateItem(user, empty);

        if (empty) {
            setGraphic(null);
        }else{
            usuario = user;
            descriptionLabel.setText(user.toString());
            setGraphic(root);
        }
    }

    private String getPathImage(String fileName) throws URISyntaxException {

        return getClass().getResource(fileName).toURI().toString();
    }


    @FXML
    private void handleSelectedItemViewDetail(MouseEvent event){
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Usuario user = usuario;
            UsuariosDetalle userViewFormComplete = new UsuariosDetalle(user,usuariosRepository);
            ChangeScene.change(stage, userViewFormComplete, "/vista/UsuariosDetalle.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





}
