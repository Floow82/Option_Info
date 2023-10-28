#include "lib_deque.h"
#include "file.h"
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

T_file intiFile(){return init();}
void emfile (T_file f, const void *el){return InsertFin(f, el);}
void *defile(T_file f){return RemoveHead(f);}
int fileVide(const T_file f){ return SizeDeque(f)==0;}
void deleteFile(T_file *f){deleteDeque(f);}
void printFile(T_file *f, void (*printElem)(void *)){printDeque(f, printElem);}