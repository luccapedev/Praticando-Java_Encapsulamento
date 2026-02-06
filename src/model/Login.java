package model;

public class Login {
    private String usuario;
    private String senha;
    private int tentativasRestantes = 3;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String validarLogin(String tentativaUsuario, String tentativaSenha) {
        if (tentativasRestantes > 1) {
            if (!tentativaUsuario.equals(usuario)) {
                return "Usuário incorreto. Tente novamente.";
            }

            if (!tentativaSenha.equals(senha)) {
                tentativasRestantes--;
                return "Senha incorreta. Tentativas restantes: " + tentativasRestantes;
            }
            return "Login bem-sucedido";
        } else {
            return "Quantidade de tentativas excedida. Acesso bloqueado";
        }
    }
}
