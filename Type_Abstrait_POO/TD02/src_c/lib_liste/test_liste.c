#include "src_lib/liste.h"
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>

void printEntier(void *v)
{
    printf("%d", *((int *)v));
}

int main ()
{
    T_liste liste;
    int v1 = 1;
    int v2 = 2;
    int v3 = 3;
    int v4 = 4;
    int v5 = 5;

    liste = initListe();
    InsertFirst(liste, &v1);
    InsertFirst(liste, &v2);
    PrintListe(liste, printEntier);
    InsertLast(liste, &v3);
    RemoveElem(liste);
    PrintListe(liste, printEntier);
    InsertNext(liste, &v4);
    PrintListe(liste, printEntier);
    deleteListe(&liste);
    return 0;

}