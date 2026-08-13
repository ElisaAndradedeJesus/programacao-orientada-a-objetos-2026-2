JAVAC := javac
JAVA := java
SRC_DIR := src
OUT_DIR := out
MAIN_CLASS := banco.Banco
MAIN_CLASS_FILE := $(OUT_DIR)/$(subst .,/,$(MAIN_CLASS)).class
SOURCES := $(shell find $(SRC_DIR) -type f -name '*.java' 2>/dev/null)

.PHONY: all compile run clean

all: compile

compile:
	@if [ -z "$(SOURCES)" ]; then \
		echo "Nenhum arquivo Java encontrado em $(SRC_DIR)."; \
	else \
		mkdir -p $(OUT_DIR); \
		$(JAVAC) -d $(OUT_DIR) $(SOURCES); \
		echo "Compilação concluída."; \
	fi

run: clean compile
	@if [ ! -f "$(MAIN_CLASS_FILE)" ]; then \
		echo "Classe principal $(MAIN_CLASS) não encontrada."; \
		echo "Verifique se a classe possui o método public static void main(String[] args)."; \
	else \
		$(JAVA) -cp $(OUT_DIR) $(MAIN_CLASS); \
	fi

clean:
	@rm -rf "$(OUT_DIR)"
	@echo "Arquivos compilados removidos."
