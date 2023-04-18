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

public class FormularioUsuarioController implements Initializable {
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
    private Button guardarButton;

    private UsuariosRepository usuariosRepository;

    public void setUsuariosRepository(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public ObservableList<Usuario> getData(){
        return FXCollections.observableArrayList(usuariosRepository.findAll());
    }

    @FXML
    void guardarUsuario() {


        String nombre = nombreTextField.getText();
        String apellidos = apellidosTextField.getText();
        //String dni = dniTextField.getText();
        String correoElectronico = correoTextField.getText();
        String codigoPostal = codigoPostalTextField.getText();
        String telefonoMovil = telefonoTextField.getText();
        LocalDate fechaNacimiento = fechaNacimientoDatePicker.getValue();
        String password = passwordPasswordField.getText();
        String repetirPassword = repetirPasswordField.getText();

        if (nombre.isEmpty() || apellidos.isEmpty() || correoElectronico.isEmpty()
                || codigoPostal.isEmpty() || telefonoMovil.isEmpty() || password.isEmpty() || repetirPassword.isEmpty()) {
            mostrarAlertaError("Debe completar todos los campos");
            return;
        }

        if (!password.equals(repetirPassword)) {
            mostrarAlertaError("Las contraseñas no coinciden");
            return;
        }

        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{5,20}$")) {
            mostrarAlertaError("La contraseña debe contener al menos 1 letra mayúscula, 1 letra minúscula, 1 carácter especial y tener entre 5 y 20 caracteres");
            return;
        }


        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
       // usuario.setDni(dni);
        usuario.setEmail(correoElectronico);
        usuario.setCodigoPostal(codigoPostal);
        usuario.setTelefonoMovil(telefonoMovil);
        usuario.setFecha(fechaNacimiento);
        usuario.setPassword(password);


        usuariosRepository.save(usuario);

    }

    private void mostrarAlertaError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }



    //
}
