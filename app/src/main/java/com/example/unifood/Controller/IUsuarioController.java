package com.example.unifood.Controller;

import com.example.unifood.Model.Usuario;

import java.util.ArrayList;

public interface IUsuarioController {
    void adicionarUsuario(Usuario usuario);
    void deletarUsuario(Usuario usuario);
    void atualizar(Usuario usuario);
    boolean loginUsuario (Usuario usuario);
    Usuario pesquisarUsuario(String email);
    ArrayList<Usuario> listaUsuario();
}