package com.example.unifood.Repository;

import com.example.unifood.Model.Usuario;


import java.util.List;

public interface IRepositorioUsuario {

    void cadastrarUsuario (Usuario usuario);
    void atualizarUsuario (Usuario usuario);
    void deletarUsuario (Usuario usuario);
    Usuario  pesquisaUsuario(String email);
    List listarUsuarios();

}
