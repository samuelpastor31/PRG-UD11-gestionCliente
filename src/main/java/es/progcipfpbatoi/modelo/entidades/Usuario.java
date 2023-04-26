package es.progcipfpbatoi.modelo.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Usuario {

    private String nombre;
    private String apellidos;
    private String dni;

    private String email;
    private String codigoPostal;
    private String telefonoMovil;
    private LocalDate fecha;
    private String password;

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getPassword() {
        return password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean empiezaPor(String text) {
        return this.nombre.startsWith(text);
    }

    @Override
    public String toString() {
        return "Nombre y apellidos: "+nombre +" "+apellidos +"  Email: "+ email +"  Fecha: "+ fecha +"  Codigo Postal: "+ codigoPostal + " Telefono: "+telefonoMovil;
    }
}
