# Programação Orientada a Objetos 2026_2

Repositório dedicado às atividades, aos exercícios e aos trabalhos desenvolvidos durante a disciplina de Programação Orientada a Objetos, utilizando Java.

## Objetivos

- Organizar os estudos da disciplina
- Documentar a evolução ao longo do semestre
- Praticar os conceitos de programação orientada a objetos com Java
- Centralizar atividades e trabalhos da disciplina

## Estrutura

```text
├── Banco               # Projeto Java de estudo
│   ├── src
│   │   └── Main.java  # Ponto de entrada do programa
│   └── Makefile       # Automação da compilação e execução
├── TrabalhoPOO         # Espaço reservado para o trabalho da disciplina
├── .gitignore          # Arquivos que não devem ser versionados
└── README.md           # Documentação geral do repositório
```

### Sobre os arquivos

- **Banco:** projeto Java independente utilizado nos estudos de programação orientada a objetos. O código-fonte fica em `src`, e o `Makefile` automatiza sua compilação e execução.

- **TrabalhoPOO:** pasta reservada para o trabalho principal da disciplina. No momento, ainda não possui arquivos.

- **README.md:** apresenta o objetivo e a organização geral deste repositório.

## Compilação e execução

Cada projeto Java é independente e possui seu próprio `Makefile`. Primeiro, entre na pasta desejada. Atualmente, o projeto executável é o `Banco`:

```bash
cd Banco
```

Use os seguintes comandos:

```bash
make          # Compila todos os arquivos Java da pasta src
make run      # Limpa, compila e executa a classe Main
make clean    # Remove os arquivos compilados
```

O comando `make compile` também pode ser usado explicitamente para compilar. Os arquivos compilados são criados na pasta `out`, que não deve ser enviada ao repositório.

## Guia de preparação do ambiente

Este passo a passo permite preparar outro computador para editar, compilar e executar os projetos deste repositório.

### 1. Instalar as ferramentas necessárias

Este repositório utiliza:

- **Git:** para baixar e atualizar o repositório
- **JDK 21:** para compilar e executar Java
- **Make:** para utilizar os comandos dos `Makefile`
- **Visual Studio Code:** editor recomendado
- **Extension Pack for Java:** suporte a Java dentro do VS Code

#### Ubuntu ou Linux Mint

Abra um terminal e execute:

```bash
sudo apt update
sudo apt install git openjdk-21-jdk make
```

O VS Code pode ser obtido em [code.visualstudio.com](https://code.visualstudio.com/).

#### Windows

Instale:

1. [Git for Windows](https://git-scm.com/download/win)
2. Um **JDK 21**, como o [Eclipse Temurin](https://adoptium.net/temurin/releases/?version=21)
3. [Visual Studio Code](https://code.visualstudio.com/Download)

Os comandos `make` não vêm instalados por padrão no Windows. A opção mais simples para usar este repositório da mesma forma que no Linux é instalar o [WSL](https://learn.microsoft.com/windows/wsl/install) com Ubuntu e seguir as instruções da seção anterior dentro dele.

#### macOS

Instale primeiro o [Homebrew](https://brew.sh/) e depois execute:

```bash
brew install openjdk@21 make git
```

Instale também o [Visual Studio Code](https://code.visualstudio.com/Download).

### 2. Verificar a instalação

Feche e abra novamente o terminal. Em seguida, execute:

```bash
java -version
javac -version
make --version
git --version
```

Os comandos `java` e `javac` devem mostrar a versão `21`. Se algum comando não for encontrado, a ferramenta correspondente ainda não foi instalada corretamente ou não está configurada no `PATH`.

### 3. Obter o repositório

No GitHub, abra a página deste repositório, clique em **Code** e copie o endereço HTTPS. Depois execute:

```bash
git clone URL_DO_REPOSITORIO
cd NOME_DO_REPOSITORIO
```

Substitua `URL_DO_REPOSITORIO` e `NOME_DO_REPOSITORIO` pelos valores exibidos no GitHub. Se o projeto já estiver salvo no computador, basta abrir sua pasta, sem cloná-lo novamente.

### 4. Abrir o projeto no VS Code

Na raiz do repositório, execute:

```bash
code .
```

Se o comando `code` não estiver disponível, abra o VS Code e use **Arquivo > Abrir Pasta** para selecionar a pasta do repositório.

### 5. Instalar o suporte a Java no VS Code

1. Abra a aba **Extensões** com `Ctrl+Shift+X`.
2. Pesquise por **Extension Pack for Java**.
3. Instale a extensão publicada pela Microsoft.
4. Se solicitado, selecione o JDK 21 instalado.
5. Reinicie a janela do VS Code.

Também é possível instalar a extensão pelo terminal:

```bash
code --install-extension vscjava.vscode-java-pack
```

### 6. Compilar e executar um projeto

Cada atividade ou trabalho deve ser mantido como um projeto independente. Entre na pasta do projeto que deseja executar. Atualmente, utilize:

```bash
cd Banco
make run
```

Comandos disponíveis em cada projeto:

```bash
make          # Compila os arquivos Java
make compile  # Também compila os arquivos Java
make run      # Limpa, compila e executa a classe Main
make clean    # Remove a pasta out e os arquivos compilados
```

### 7. Atualizar o projeto futuramente

Antes de continuar os estudos em outro computador, entre na raiz do repositório e execute:

```bash
git pull
```

Para evitar conflitos, envie para o GitHub as alterações feitas no computador anterior antes de trocar de máquina.

### Solução de problemas comuns

- **`java: command not found`:** instale o JDK 21 e abra novamente o terminal.
- **`javac: command not found`:** foi instalado somente o ambiente de execução; instale o JDK completo.
- **`make: command not found`:** instale o pacote `make` ou utilize o WSL no Windows.
- **`Classe principal Main não encontrada`:** verifique se existe uma classe `Main` com o método `public static void main(String[] args)` dentro de `src`.
- **A extensão Java não reconhece o JDK:** no VS Code, pressione `Ctrl+Shift+P`, procure por **Java: Configure Java Runtime** e selecione o JDK 21.
