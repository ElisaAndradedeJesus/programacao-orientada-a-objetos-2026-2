# Comandos do JDK usados para compilar e executar o programa.
JAVAC := javac
JAVA := java

# Pastas que armazenam o código-fonte e os arquivos compilados.
SRC_DIR := src
OUT_DIR := out

# Nome completo da classe principal, incluindo o pacote "banco".
MAIN_CLASS := banco.Banco

# Converte banco.Banco em banco/Banco.class para localizar o arquivo compilado.
MAIN_CLASS_FILE := $(OUT_DIR)/$(subst .,/,$(MAIN_CLASS)).class

# Localiza todos os arquivos Java dentro da pasta src.
SOURCES := $(shell find $(SRC_DIR) -type f -name '*.java' 2>/dev/null)

# Informa ao Make que estes nomes representam comandos, e não arquivos.
.PHONY: all compile run clean

# Alvo padrão: compila, executa e, ao final, remove os arquivos compilados.
all: compile run clean

# Compila todos os arquivos .java e salva os .class na pasta out.
# O teste impede a chamada do compilador quando a pasta src está vazia;
# mkdir -p cria out quando necessário, e javac -d grava os .class nela.
compile:
	@if [ -z "$(SOURCES)" ]; then \
		echo "Nenhum arquivo Java encontrado em $(SRC_DIR)."; \
	else \
		mkdir -p $(OUT_DIR); \
		$(JAVAC) -d $(OUT_DIR) $(SOURCES); \
		echo "Compilação concluída."; \
	fi

# Executa a classe principal usando a pasta out como classpath.
# Este alvo pressupõe que o projeto já tenha sido compilado.
# Antes da execução, o teste confirma que a classe principal foi gerada.
run:
	@if [ ! -f "$(MAIN_CLASS_FILE)" ]; then \
		echo "Classe principal $(MAIN_CLASS) não encontrada."; \
		echo "Verifique se a classe possui o método public static void main(String[] args)."; \
	else \
		$(JAVA) -cp $(OUT_DIR) $(MAIN_CLASS); \
	fi

# Exclui a pasta out e todos os arquivos gerados pela compilação.
clean:
	@rm -rf "$(OUT_DIR)"
	@echo "Arquivos compilados removidos."
