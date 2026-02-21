# Sistema de Cadastro de Alunos

Uma API REST simples para o gerenciamento de matrículas de alunos. 

Este sistema permite cadastrar, listar, atualizar e remover alunos de diferentes cursos, garantindo regras de negócio básicas (como evitar duplicidade de matrículas no mesmo curso e validar se um aluno existe antes de deletá-lo).

## Tecnologias Utilizadas

O projeto foi desenvolvido utilizando o ecossistema Spring:

* **Java**
* **Spring Boot 4**
* **Spring Data JPA**
* **H2 Database**
* **Lombok**
* **Maven**

## Como executar o projeto

Como o projeto utiliza o banco de dados H2 em memória, não é necessário instalar nenhum banco de dados externo. Tudo já está configurado para rodar "out of the box".

1. Clone este repositório:
   ```bash
   git clone [https://github.com/pedroviel/sistema-de-cadastro.git](https://github.com/pedroviel/sistema-de-cadastro.git)
   ```
2. Abra o projeto na sua IDE de preferência (IntelliJ, Eclipse, VS Code).
3. Atualize as dependências do Maven.
4. Execute a classe principal `SistemaDeCadastroApplication.java`.

A API estará rodando localmente em `http://localhost:8080`.

### Acessando o Banco de Dados (H2 Console)
Você pode visualizar as tabelas e os dados salvos em tempo real acessando o painel do H2 pelo navegador:

* **URL:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:cadastros-db`
* **User Name:** `sa`
* **Password:** *(deixe em branco)*

## Endpoints da API
Abaixo estão as rotas disponíveis no `CadastroController`:

* `POST /cadastros` - Cadastra um novo aluno.
* `GET /cadastros?cursoAluno={curso}` - Lista todos os alunos matriculados em um curso específico.
* `PUT /cadastros?nomeAluno={nome}&cursoAluno={curso}` - Altera os dados de um aluno existente buscando por nome e curso.
* `DELETE /cadastros?matriculaAluno={uuid}` - Remove um aluno do sistema através de sua matrícula (UUID).

*(Exemplo de payload (JSON) para o POST e PUT)*:

```json
{
  "nomeAluno": "Fulano",
  "emailAluno": "fulano@email.com",
  "cursoAluno": "Engenharia da Computação",
  "idadeAluno": 30
}
```
