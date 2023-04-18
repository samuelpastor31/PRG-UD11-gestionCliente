package es.progcipfpbatoi.modelo.repositorios;

import es.progcipfpbatoi.modelo.entidades.Usuario;

import java.util.ArrayList;

public class InMemoryUsuariosRepository implements UsuariosRepository{
    private ArrayList<Usuario> usuarios;

    public InMemoryUsuariosRepository(){
        this.usuarios = new ArrayList<>();
        init();
    }
    @Override
    public ArrayList<Usuario> findAll() {
        return usuarios;
    }

    @Override
    public boolean save(Usuario usuario) {
        return usuarios.add(usuario);
    }

    private void init(){
        this.usuarios.add(new Usuario());
    }


}
