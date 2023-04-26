package es.progcipfpbatoi.controlador;

import es.progcipfpbatoi.modelo.entidades.Usuario;
import es.progcipfpbatoi.modelo.repositorios.UsuariosRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UsuariosDetalle implements Initializable {
    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField apellidosTextField;

    @FXML
    private TextField correoTextField;

    @FXML
    private TextField codigoPostalTextField;

    @FXML
    private TextField telefonoTextField;

    @FXML
    private DatePicker fechaNacimientoDatePicker;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private PasswordField repetirPasswordField;

    @FXML
    private TableView<Usuario> usuariosTableView;

    @FXML
    private ListView<Usuario> usuarioListView;

    @FXML
    private Button guardarButton;

    private Usuario usuario;


    private UsuariosRepository usuariosRepository;

    public UsuariosDetalle( Usuario usuario,UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
        this.usuario = usuario;
    }

    public void setNombreTextField(){
        nombreTextField.getText();
    }
    public void setUsuariosRepository(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nombreTextField.setText(usuario.getNombre());
        nombreTextField.setEditable(false);
        apellidosTextField.setText(usuario.getApellidos());
        apellidosTextField.setEditable(false);
        correoTextField.setText(usuario.getEmail());
        correoTextField.setEditable(false);
        telefonoTextField.setText(usuario.getTelefonoMovil());
        telefonoTextField.setEditable(false);
        fechaNacimientoDatePicker.setValue(usuario.getFecha());
        fechaNacimientoDatePicker.setEditable(false);
        codigoPostalTextField.setText(usuario.getCodigoPostal());
        codigoPostalTextField.setEditable(false);
        passwordPasswordField.setText(usuario.getPassword());
        passwordPasswordField.setEditable(false);
        repetirPasswordField.setText(usuario.getPassword());
        repetirPasswordField.setEditable(false);

    }


    public ObservableList<Usuario> getData(){
        return FXCollections.observableArrayList(usuariosRepository.findAll());
    }

    @FXML
    void listaUsuarios(MouseEvent event){

        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            UsuariosControler usuariosControler = new UsuariosControler(usuariosRepository);
            ChangeScene.change(stage, usuariosControler, "/vista/users_list.fxml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
