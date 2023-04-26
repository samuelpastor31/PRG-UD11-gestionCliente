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

    @Override
    public ArrayList<Usuario> findAll(String text) {
        ArrayList<Usuario>usuariosFiltrados = new ArrayList<>();
        for (Usuario usuario: usuarios) {
            if (usuario.empiezaPor(text)) {
                usuariosFiltrados.add(usuario);
            }
        }

        return usuariosFiltrados;
    }

    private void init(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Samuel");
        usuario.setApellidos("Pastor Pinillos");
        usuario.setEmail("samuelpastorpinillos@gmail.com");
        this.usuarios.add(usuario);
    }


}
