package com.example.unifood.Repository;

import com.example.unifood.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario implements IRepositorioUsuario{
    private ArrayList<Usuario> usuarioArrayList;
    private static RepositorioUsuario instance;

    public static RepositorioUsuario getInstance() {
        if (instance ==null){
            instance = new RepositorioUsuario();
        }

        return instance;
    }

    private RepositorioUsuario() {
        if(this.usuarioArrayList == null){
            this.usuarioArrayList = new ArrayList<>();
        }
    }



    @Override
    public void cadastrarUsuario(Usuario usuario) {
        this.usuarioArrayList.add(usuario);
    }

    @Override
    public void atualizarUsuario(Usuario usuario) {
        for (int i = 0; i <this.usuarioArrayList.size() ; i++) {
            if (this.usuarioArrayList.get(i).getNome().equals(usuario)){
                this.usuarioArrayList.set(i, usuario);
                break;
            }
            
        }
    }

    @Override
    public void deletarUsuario(Usuario usuario) {
        for (int i = 0; i <usuarioArrayList.size() ; i++) {
            if (usuarioArrayList.get(i).getEmail().equals(usuario.getEmail())){
                usuarioArrayList.remove(i);
            }
        }
    }

    @Override
    public Usuario pesquisaUsuario(String email) {
        Usuario usuario= null;
        for (int i = 0;i <this.usuarioArrayList.size() ; i++) {
            if ((this.usuarioArrayList.get(i).getEmail().equals(email))){
                usuario = usuarioArrayList.get(i);
                break;
            }
        }
        if (usuario == null){
            System.out.println("Usuario nao encontrado");
        }
        return null;
    }


    public Boolean acharUsuario (Usuario usuario){

        for (int i = 0; i <usuarioArrayList.size() ; i++) {
            if (usuarioArrayList.get(i).getNome().equals(usuario.getNome()) && usuarioArrayList.get(i).getSenha().equals(usuario.getSenha())){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }



    @Override
    public ArrayList listarUsuarios() {
        return usuarioArrayList;
    }

}
