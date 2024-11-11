package login;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver.Manager").newInstance();
            //nome do driver de conexão errado//
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
            //falta de feedback sobre o erro no console, e falta tratamento de erros//
        }
        return conn;
    }
}
