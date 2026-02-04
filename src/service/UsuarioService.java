package service;

import model.Usuario;

public class UsuarioService {
    public void redefinirSenha(Usuario usuario, String senha, String novaSenha) {
        if (senha.equals(usuario.getSenha())) {
            usuario.setSenha(novaSenha);
            System.out.println("Senha alterada com sucesso!\n");
        } else {
            System.out.println("Senha atual incorreta. A senha não foi alterada.\n");
        }
    }
}
