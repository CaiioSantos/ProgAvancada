package com.example.unifood.Fachada;

import com.example.unifood.Controller.IUsuarioController;
import com.example.unifood.Controller.UsuarioController;
import com.example.unifood.Model.Usuario;

import java.util.ArrayList;

public class Fachada implements IUsuarioController {
        private static Fachada instancia;
        private IUsuarioController usuarioController;

        public static Fachada getInstance(){
            if (instancia == null){
                instancia = new Fachada();
            }
            return instancia;
        }

        private Fachada(){
            usuarioController = UsuarioController.getInstance();
        }

    @Override
    public void adicionarUsuario(Usuario usuario) {
            this.usuarioController.adicionarUsuario(usuario);

    }

    @Override
    public void deletarUsuario(Usuario usuario) {
            this.usuarioController.deletarUsuario(usuario);

    }

    @Override
    public void atualizar(Usuario usuario) {
            this.usuarioController.atualizar(usuario);
    }

    @Override
    public Boolean acharUsuario(Usuario usuario) {
            return this.usuarioController.acharUsuario(usuario);

    }

    @Override
    public ArrayList<Usuario> listaUsuario() {
           return this.usuarioController.listaUsuario();

    }
}
