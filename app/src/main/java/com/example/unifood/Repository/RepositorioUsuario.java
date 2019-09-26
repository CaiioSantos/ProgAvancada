package com.example.unifood.Repository;

import com.example.unifood.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario implements IRepositorioUsuario{

    private static List instance = null;

    private RepositorioUsuario (){
        if (instance == null){
            instance = new ArrayList <Usuario>();
        }
    }



    @Override
    public void cadastrarUsuario(Usuario usuario) {


    }

    @Override
    public void atualizarUsuario(Usuario usuario) {

    }

    @Override
    public void deletarUsuario(Usuario usuario) {

    }

    @Override
    public Usuario pesquisaUsuario(String email) {
        return null;
    }

    @Override
    public List listarUsuarios() {
        return null;
    }
}
