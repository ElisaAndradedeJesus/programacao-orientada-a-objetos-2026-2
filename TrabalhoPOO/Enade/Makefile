.DEFAULT_GOAL := run

JAVAC := javac
JAVA := java
INPUT ?= input.txt

.PHONY: build run test

build:
	mkdir -p bin
	$(JAVAC) -encoding UTF-8 -d bin src/*.java

# Uma pasta temporaria sem input.txt garante a leitura pelo teclado.
run: build
	@set -eu; classes="$$(pwd)/bin"; pasta=$$(mktemp -d); \
	trap 'rmdir "$$pasta"' EXIT; \
	cd "$$pasta"; $(JAVA) -cp "$$classes" Main

# Mantem abrirEntrada() do professor: procura input.txt na pasta de execucao.
test: build
	@set -eu; classes="$$(pwd)/bin"; \
	test -f "$(INPUT)" || { echo "Arquivo de entrada nao encontrado: $(INPUT)" >&2; exit 1; }; \
	pasta=$$(mktemp -d); \
	trap 'rm -f "$$pasta/input.txt"; rmdir "$$pasta"' EXIT; \
	cp "$(INPUT)" "$$pasta/input.txt"; \
	cd "$$pasta"; $(JAVA) -cp "$$classes" Main
