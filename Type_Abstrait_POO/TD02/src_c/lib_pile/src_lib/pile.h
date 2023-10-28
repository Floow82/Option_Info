#ifndef pile_h
#define pile_h
#include "lib_deque.h"
typedef struct deque *T_pile;
T_pile initPile();
void empile(T_pile p, const void *el);
void *depile(T_pile p);
int pileVide(const T_pile p);
void deletePile (T_pile *p);
void printPile(T_pile *p, void (*printElem)(void *));

#endif