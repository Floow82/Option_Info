#include "lib_deque.h"
#include "pile.h"
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

T_pile initPile()
{
    return init();
}

void empile(T_pile p, const void *el)
{
    return InsertFin(p, el);
}
void *depile(T_pile p)
{
    return removeFin(p);
}
int pileVide(const T_pile p)
{
    return SizeDeque(p)==0;
}
void deletePile (T_pile *p)
{
    deleteDeque(p);
}
void printPile(T_pile *p, void (*printElem)(void *))
{
    printDeque(p, printElem);
}
