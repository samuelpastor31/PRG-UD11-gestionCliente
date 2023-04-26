package es.progcipfpbatoi.modelo.repositorios;

import es.progcipfpbatoi.modelo.entidades.Usuario;

import java.util.ArrayList;

public interface UsuariosRepository {

    ArrayList<Usuario>findAll();
    boolean save(Usuario usuario);
    ArrayList<Usuario> findAll(String text);


}
