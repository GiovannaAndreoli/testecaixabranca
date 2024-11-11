package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AuthenticationService {
    public User verificarUsuario(String login, String senha) {
        Connection conn = DatabaseConnection.conectarBD();
        //falta de fechamento de conexão com o banco de dados//
        String sql = "SELECT nome FROM usuarios WHERE login = '" + login + "' AND senha = '" + senha + "';";
        //falta de boa prática na escrita da string, o mais correto seria ""SELECT nome FROM usuarios WHERE login = ? AND senha = ?";"//
        User user = null;

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String nome = rs.getString("nome");
                user = new User(nome);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
