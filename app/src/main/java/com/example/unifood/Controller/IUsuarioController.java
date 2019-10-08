package com.example.unifood.Controller;

import com.example.unifood.Model.Usuario;

import java.util.ArrayList;

public interface IUsuarioController {
    void adicionarUsuario(Usuario usuario);
    void deletarUsuario(Usuario usuario);
    void atualizar(Usuario usuario);
    Boolean acharUsuario (Usuario usuario);
    ArrayList<Usuario> listaUsuario();
}
