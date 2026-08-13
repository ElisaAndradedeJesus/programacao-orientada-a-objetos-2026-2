JAVAC := javac
JAVA := java
SRC_DIR := src
OUT_DIR := out
MAIN_CLASS := Main
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
	@if [ ! -f "$(OUT_DIR)/$(MAIN_CLASS).class" ]; then \
		echo "Classe principal $(MAIN_CLASS) não encontrada."; \
		echo "Adicione um programa executável em $(SRC_DIR)/$(MAIN_CLASS).java."; \
	else \
		$(JAVA) -cp $(OUT_DIR) $(MAIN_CLASS); \
	fi

clean:
	@rm -rf "$(OUT_DIR)"
	@echo "Arquivos compilados removidos."
