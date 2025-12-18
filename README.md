# 🎮 Game Library API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2_Database-003B57?style=for-the-badge&logo=h2&logoColor=white)

Uma API RESTful desenvolvida para gerenciar uma biblioteca pessoal de jogos. O sistema permite criar usuários, adicionar jogos (integrando com a API pública da RAWG para buscar dados reais), listar a coleção, atualizar status de progresso e remover jogos.

## 🚀 Tecnologias Utilizadas

* **Java 25** (Compatível com versões LTS 17/21)
* **Spring Boot 3** - Framework principal
* **Spring Data JPA** - Persistência de dados
* **H2 Database** - Banco de dados em memória (para desenvolvimento rápido)
* **OpenFeign** - Cliente HTTP declarativo para consumir a API da RAWG
* **Lombok** - Redução de código boilerplate
* **Maven** - Gerenciador de dependências

## ⚙️ Funcionalidades

- [x] **Cadastro de Usuários:** Criação de perfis com nome e data de nascimento.
- [x] **Integração Externa:** Busca automática de título e capa do jogo na API da RAWG usando o ID externo.
- [x] **Adicionar à Biblioteca:** Vincula um jogo a um usuário com status inicial.
- [x] **Listagem:** Visualização de todos os jogos de um usuário específico.
- [x] **Atualização:** Alteração de status (ex: JOGANDO para ZERADO) e horas jogadas.
- [x] **Remoção:** Exclusão de jogos da lista do usuário.

## 🛠️ Configuração e Execução

### Pré-requisitos
* Java JDK instalado.
* Maven instalado.
* Uma chave de API gratuita da [RAWG.io](https://rawg.io/apidocs).

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/SEU-USUARIO/game-library.git](https://github.com/SEU-USUARIO/game-library.git)
    ```

2.  **Configure a API Key:**
    Abra o arquivo `src/main/resources/application.properties` e adicione sua chave:
    ```properties
    spring.application.name=game-library
    # Coloque sua chave aqui (não comite este arquivo com a chave real!)
    rawg.api.key=SUA_CHAVE_DA_RAWG_AQUI
    ```

3.  **Execute a aplicação:**
    Via IDE (IntelliJ/Eclipse) ou terminal:
    ```bash
    mvn spring-boot:run
    ```

## 🔌 Endpoints da API

Aqui estão as rotas disponíveis para teste (via Postman ou Insomnia).

### 👤 Usuários

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/api/usuarios/adicionar` | Cria um novo usuário |

**Exemplo de JSON (Body):**
```json
{
  "nome": "Seu Nome",
  "dataNascimento": "1995-05-20"
}


🎮 Biblioteca de Jogos
Método	Endpoint	Descrição
POST	/api/biblioteca/adicionar	Adiciona um jogo (busca dados na RAWG)
GET	/api/biblioteca/listar/{usuarioId}	Lista todos os jogos do usuário
PUT	/api/biblioteca/atualizar	Atualiza status e horas jogadas
DELETE	/api/biblioteca/remover/{usuarioId}/{jogoId}	Remove um jogo da lista

Exemplo - Adicionar Jogo:
JSON

{
  "usuarioId": 1,
  "jogoIdExterno": 3328,
  "status": "JOGANDO"
}

(Nota: 3328 é o ID do The Witcher 3 na RAWG)

Exemplo - Atualizar Jogo:
JSON

{
  "usuarioId": 1,
  "jogoId": 3328,
  "status": "COMPLETO",
  "horasJogadas": 50
}

📝 Status do Projeto

🚧 Em Desenvolvimento / Refatoração 🚧

Próximos passos planejados:

    Implementação de validações (Bean Validation).

    Tratamento global de exceções.

    Documentação automática com Swagger/OpenAPI.

    Testes unitários.

👨‍💻 Autor

Desenvolvido por Moroni Pereira durante estudos de Java e Spring Boot.
