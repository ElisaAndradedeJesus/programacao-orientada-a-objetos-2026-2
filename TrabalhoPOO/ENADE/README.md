# ENADE

Trabalho de Programação Orientada a Objetos: cadastro de áreas, cursos e alunos e acompanhamento de resultados do ENADE.

## Requisitos

- JDK 17 ou superior, com `java` e `javac` disponíveis no terminal.
- GNU Make e um terminal Linux/Bash (no Windows, utilize WSL).

Confira a instalação:

```bash
java -version
javac -version
make --version
```

## Pasta de execução

Abra um terminal na pasta `TrabalhoPOO/ENADE`, onde fica o `Makefile`.
Se o terminal estiver na raiz do repositório:

```bash
cd TrabalhoPOO/ENADE
```

## Executar digitando as entradas

```bash
make
```

O comando compila os arquivos de `src` para `bin` e inicia `Main`. Digite as opções do menu e os dados solicitados. Use ponto nas notas decimais (exemplo: `8.5`). Escolha `0` no menu principal para sair.

`make run` tem o mesmo efeito. Nesse modo, a leitura é pelo teclado, mesmo que exista um `input.txt` na pasta do projeto.

## Executar com as entradas do professor

```bash
make test
```

O comando compila e executa usando o arquivo `TrabalhoPOO/Atividade 2/input.txt`, que precisa estar presente no repositório. Não é necessário copiar o arquivo manualmente nem digitar as entradas: elas são lidas automaticamente, e a saída aparece no terminal.

Esse comando apenas executa o programa com as entradas; ele não compara a saída nem garante que o trabalho esteja correto.

Para utilizar outro arquivo, informe seu caminho, relativo à pasta ENADE ou absoluto:

```bash
make test INPUT="/caminho/para/meu-input.txt"
```

O Makefile prepara uma pasta temporária com o arquivo chamado `input.txt`, respeitando a leitura automática implementada em `Entrada.abrirEntrada()`.

## Apenas compilar

```bash
make build
```

Se houver erro de compilação, a execução não começa. Confira o arquivo e a linha indicados na mensagem do compilador.
