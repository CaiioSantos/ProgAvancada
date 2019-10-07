package com.example.unifood.Repository;

import com.example.unifood.Model.Usuario;


import java.util.ArrayList;

public interface IRepositorioUsuario {

    void cadastrarUsuario (Usuario usuario);
    void atualizarUsuario (Usuario usuario);
    void deletarUsuario (Usuario usuario);
    Boolean acharUsuario (Usuario usuario);
    Usuario  pesquisaUsuario(String email);
    ArrayList listarUsuarios();

}
