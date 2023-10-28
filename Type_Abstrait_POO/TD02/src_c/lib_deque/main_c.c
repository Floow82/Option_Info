#include "src_lib/lib_deque.h"
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>

/* Procédure d'affichage d'un entier */
void printEntier(void *v)
{
    /* attention au "cast" et au déréférencement */
    printf("%d", *((int *)v));
}

int main()
{
    int val1 = 3;
    int val2 = 2;
    int val3 = 5;
    int val4 = 4;
    T_deque *deque;
    int *val_ptr;

    val_ptr = (int *)malloc(sizeof(int));
    *val_ptr = 1;
    deque = init();
    InsertDebut(deque, &val1);
    InsertDebut(deque, &val2);
    PrintDeque(deque, printEntier);
    InsertFin(deque, &val3);
    InsertFin(deque, &val4);
    InsertDebut(deque, val_ptr);
    PrintDeque(deque, printEntier);

    printf("remove head %d ...\n", *((int *)RemoveDebut(deque)));
    printf("remove head %d ...\n", *((int *)RemoveDebut(deque)));
    printf("remove head %d ...\n", *((int *)RemoveDebut(deque)));
    printf("remove head %d ...\n", *((int *)RemoveDebut(deque)));
    printf("remove head %d ...\n", *((int *)RemoveDebut(deque)));

    PrintDeque(deque, printEntier);
    InsertDebut(deque, &val1);
    InsertDebut(deque, &val2);
    InsertFin(deque, &val3);
    InsertFin(deque, &val4);
    InsertDebut(deque, val_ptr);
    PrintDeque(deque, printEntier);
    printf("remove queue %d ...\n", *((int *)RemoveFin(deque)));
    printf("remove queue %d ...\n", *((int *)RemoveFin(deque)));
    printf("remove queue %d ...\n", *((int *)RemoveFin(deque)));
    PrintDeque(deque, printEntier);
    DeleteDeque(deque);
    return 0;
}