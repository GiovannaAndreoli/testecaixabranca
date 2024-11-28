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

## ETAPA 3:

![Grafo de Fluxo](grafo.png)

## Análise do Grafo de Fluxo

### Complexidade Ciclomática

- \(E = 11\): Número de arestas (conexões no grafo).
- \(N = 10\): Número de nós.
- \(P = 1\): Número de componentes conectados.

\[
V = 11 - 10 + 2 \times 1 = 3
\]

**Complexidade Ciclomática: \(V = 3\)**.

---

### Caminhos Básicos
São 3 caminhos básicos:

1. **1 (Conexão bem-sucedida e usuário válido)**:
   - Início → verificarUsuario → conectarBD (True) → Construir Query → Executa Query → rs.next()? (True) → Result = true → Fim.

2. **2 (Conexão bem-sucedida e usuário inválido)**:
   - Início → verificarUsuario → conectarBD (True) → Construir Query → Executa Query → rs.next()? (False) → Result = false → Fim.

3. **3 (Falha na conexão)**:
   - Início → verificarUsuario → conectarBD (False) → Falha na conexão → Fim.