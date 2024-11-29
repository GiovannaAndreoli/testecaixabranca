package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * A classe User faz o gerenciamento de autenticações de um usuário no sistema.
 * contendo métodos de verificação do usuário dentro do BD*
 */
public class User {
    
    /**
     * Estabelecimento de conexão com o banco de dados MySQL.
     * 
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carregamento do  driver JDBC do MySQL
            Class.forName("com.mysql.Driver.Manager").newInstance();
            
            // String para conexão com  banco de dados
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Se ocorrer um erro, retorna como null
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Atributo armazenando o nome do usuário recuperado do banco de dados.
     */
    public String nome = "";
    
    /**
     * Resultado da verificação do usuário. Verdadeiro se as credenciais forem válidas, caso contrário, falso.
     */
    public boolean result = false;

    /**
     * Verificação de credenciais do login e senha fornecidas.
     * 
     * @param login O nome de usuário a ser verificado.
     * @param senha A senha do usuário a ser verificada.
     * @return Retorna verdadeiro se o usuário for encontrado com as credenciais válidas, caso contrário retorna falso.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD();
        
        // Montagem de SQL usando SQLinjection para verificação de usuário e senha no BD
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";  // melhor usar PreparedStatement para evitar possíveis erros
        sql += " and senha = '" + senha + "';";

        try {
            // Criação de declaração para execução da consulta SQL
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Faz a verificação do resultado
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Tratamento de erro durante a excecução
            e.printStackTrace();
        }
        
        // Retorno de resultado da verificação
        return result;
    }
}