package com.example.unifood.Controller;

import com.example.unifood.Model.Usuario;
import com.example.unifood.Repository.RepositorioUsuario;

import java.util.ArrayList;

public class UsuarioController implements IUsuarioController {
        private static UsuarioController instacia;
        private RepositorioUsuario repositorioUsuario = RepositorioUsuario.getInstance();

    public UsuarioController (){

        }
        public static UsuarioController getInstance(){
            if (instacia == null){
                instacia =  new UsuarioController();
            }
            return instacia;
        }


    @Override
    public void adicionarUsuario(Usuario usuario) {
            this.repositorioUsuario.cadastrarUsuario(usuario);

    }

    @Override
    public void deletarUsuario(Usuario usuario) {
        if (this.repositorioUsuario.pesquisaUsuario(usuario.getEmail())== null){
            System.out.println("Cliente não existe");
        }
        else{
            this.repositorioUsuario.deletarUsuario(usuario);
        }
    }

    @Override
    public void atualizar(Usuario usuario) {
            this.repositorioUsuario.atualizarUsuario(usuario);

    }

    public Boolean acharUsuario (Usuario usuario){
        return  this.repositorioUsuario.acharUsuario(usuario);
    }

    @Override
    public ArrayList<Usuario> listaUsuario() {
        return this.repositorioUsuario.listarUsuarios();
    }
}
