CC=gcc
CFLAGS= -Wall -std=c90 -pedantic -g
EXEC=un_test
OBJ_DIR=.obj
SRC_DIR=src_c
BIN_DIR=exec

all: $(EXEC)

un_test: $(BIN_DIR)/un_test

$(BIN_DIR)/un_test: $(OBJ_DIR)/un_test.o
	$(CC) $(CFLAGS) -o $(BIN_DIR)/un_test $(OBJ_DIR)/un_test.o

$(OBJ_DIR)/un_test.o: $(SRC_DIR)/un_test.c
	$(CC) $(CFLAGS) -o $(OBJ_DIR)/un_test.o -c $(SRC_DIR)/un_test.c

clean:
	rm -rf $(OBJ_DIR)/*.o

mrproper : clean
	rm -rf $(BIN_DIR)/$(EXEC)