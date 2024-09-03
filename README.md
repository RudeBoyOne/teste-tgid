# # Instruções para Clonar e Rodar a Aplicação

Estas instruções irão guiá-lo através do processo de clonagem do repositório e execução da aplicação.

## Pré-requisitos

Certifique-se de ter o seguinte instalado em sua máquina:
- **Git:** Para clonar o repositório
- **Java JDK 21:** Para compilar e rodar a aplicação
- **Gradle:** Para gerenciar dependências e executar tarefas de build

## Maiores informações sobre a modelagem de dados
['Ir para o diretório documentation ⬆️ '](../documentation)

## Passos para Clonar e Rodar a Aplicação

### 1. Clonar o Repositório

Abra um terminal e execute o seguinte comando:

```sh
git clone https://github.com/RudeBoyOne/teste-tgid.git
cd teste-tgid
```

### 2. Compilar o Projeto

Navegue até o diretório do projeto clonado e execute o comando Gradle para compilar o projeto:

```sh
./gradlew build
```

### 3. Executar a Aplicação

Após a compilação bem-sucedida, execute o seguinte comando para rodar a aplicação:

```sh
./gradlew bootRun
```