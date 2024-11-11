package login;

public class Main {
    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        String login = "usuario";
        String senha = "senha";

        User user = authService.verificarUsuario(login, senha);
        if (user != null) {
            System.out.println("Autenticação bem-sucedida! Nome do usuário: " + user.getNome());
        } else {
            System.out.println("Falha na autenticação. Verifique o login e senha.");
        }
    }
}
