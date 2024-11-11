# testecaixabranca
Exercício individual de teste de caixa branca para a matéria de UI/UX, Profº Daniel Ohata

## ETAPA 1:
Apontar os erros encontrados no código:

### Em AuthenticationService:
* Falta de fechamento de conexão com o banco de dados;

* Falta de boa prática na escrita da string, o mais correto seria ""SELECT nome FROM usuarios WHERE login = ? AND senha = ?";

### Em DatabaseConnection:

* Nome do driver de conexão errado;

* Falta de feedback sobre o erro no console;

 * Falta tratamento de erros;

### Em User:

* A função de verificação de usuário também não existe, então não pode ser utilizada pelo main;
    
* Em nenhum momento há declaração da classe de senha, sendo assim, a clase main não conseguirá obter dados;

