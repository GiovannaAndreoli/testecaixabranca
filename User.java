package login;

public class User {
    private String nome;

    public User(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    // a função de verificação de usuário também não existe, então não pode ser utilizada pelo main//
    //Em nenhum momento há declaração da classe de senha, sendo assim, a clase main não conseguirá obter dados//
}
