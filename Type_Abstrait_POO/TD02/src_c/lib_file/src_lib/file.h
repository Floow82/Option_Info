#ifndef file_h
#define file_h
#include "lib_deque.h"

typedef struct deque *T_file;
T_file intiFile();
void emfile (T_file f, const void *el);
void *defile(T_file f);
int fileVide(const T_file f);
void deleteFile(T_file *f);
void printFile(T_file *f, void (*printElem)(void *));
#endif