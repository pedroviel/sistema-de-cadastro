# Sistema de cadastro

API Rest desenvolvida por meio de um CRUD simples, onde é possível criar alunos, indicando o seu curso, e cada um tem sua matricula própria gerada como ID no ato de criação.

## Tecnologias utilizadas

- Java
- Spring / Spring Boot
- H2 Database
- Lombok
- Maven

## Como executar

Como é utilizado o H2 Database, o projeto não necessita de um banco de dados externo.

1 - Clonar esse repositório \
2 - Abra na sua IDE \
3 - Atualize as dependências Maven \
4 - Execute SistemaDeCadastroApplication.java

Ao executar a API estará rodando localmente em localhost:8080.

## Endpoints da API

Você poderá testar todas a s requisições em ferramentas como Postman.

* `POST /cadastros` Cadastrar um novo aluno.
* `GET /cadastros?cursoAluno={curso}` Listar alunos pelo curso.
* `GET /cadastros/{uuid}` Buscar aluno pela sua matrícula.
* `PUT /cadastros?nomeAluno={nome}&cursoAluno={curso}` Alterar o cadastro do aluno.
* `DELETE /cadastros?matriculaAluno={uuid}`  Deletar um aluno com sua matrícula como parâmetro.

## Exemplo de payload para o POST

````
{"nomeAluno": "Pedro", "cursoAluno": "Engenharia"}
````