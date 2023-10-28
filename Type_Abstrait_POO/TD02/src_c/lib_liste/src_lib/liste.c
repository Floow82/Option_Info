#include "liste.h"
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

struct cell
{
    void *data;
    struct cell *next;
    struct cell *prev;
};
struct liste
{
    long size;
    struct cell *first;
    struct cell *last;
    struct cell *position;
};

T_liste initListe()
{
    T_liste l;
    errno = 0;
    l = (T_liste)malloc(sizeof(struct liste));
    if (errno){
        perror("Ya un pb avec ta liste frr");
        return NULL;
    }
    l->size=0;
    l->first=NULL;
    l->last=NULL;
    l->position=NULL;
    return l;
}
void first(const T_liste l)
{
    assert(l != NULL);
    assert(l->size >0);
    l->position = l->first;
}
void last(const T_liste l)
{
    assert(l != NULL);
    assert(l->size >0);
    l->position = l->last;
}
void next(const T_liste l)
{
    assert(l != NULL);
    assert(l->size >0);
    assert(l->position != l->last);
    l->position = l->position->next;
}
void prev(const T_liste l)
{
    assert(l != NULL);
    assert(l->size >0);
    assert(l->position != l->first);
    l->position = l->position->prev;
}
int InsertFirst(T_liste l, const void *el)
{
    struct cell *cell;
    assert(l!= NULL);
    assert(el != NULL);
    cell = (struct cell *)malloc(sizeof(struct cell));
    if (errno)
    {
        perror("Pb allocation cellule \n");
        exit errno;
    }
    cell->data =(void *)el;
    cell->prev =NULL;
    cell->next = l->first;
    if (l->first == NULL)
    {
        l->first = cell;
        l->last = cell;
        l->position = l->first;
    }
    else
    {
        l->first->prev = cell;
        l->first = cell;
    }
    l->size++;
}

int InsertLast(T_liste l, const void *el)
{
    struct cell *cell;
    assert(l != NULL);
    assert( el != NULL);
    cell = (struct cell *)malloc(sizeof(struct cell));
    if (errno)
    {
        perror("Pb allocation cellule \n");
        exit errno;
    }
    cell->data = (void *)el;
    cell->prev = l->last;
    cell->next = NULL;

    if (l->last == NULL)
    {
        l->first = cell;
        l->last = cell;
        l->position = l->first;
    }
    else
    {
        l->last->next = cell;
        l->last = cell;
    }
    l->size++;

}
void *element(T_liste l)
{
    assert(l != NULL);
    assert(l->size > 0);
    return l->position->data;
}
void *RemplaceEl (T_liste l, const void *el)
{
    struct cell *old;
    assert(l != NULL);
    assert( el != NULL);
    old = l->position->data;
    l->position->data = (void *)el;
    return old;
}

void InsertPrev(T_liste l, const void *el)
{
    struct cell *dt;
    assert(l != NULL);
    assert(el != NULL);
    assert(l->position != NULL);
    dt = (struct cell *)malloc(sizeof(struct cell));
    if (errno)
    {
        perror("Pb Allocation cellule ...\n");
        exit errno;
    }
    dt->data = (void *)el;
    dt->prev = l->position->prev;
    dt->next = l->position;
    if (l->first == l->position)
    {
        l->first = dt;
    }
    else
    {
        l->position->prev->next = dt;
    }
    l->position->prev = dt;
    l->position = dt;
    l->size++;

}
void InsertNext(T_liste l, const void *el)
{
    struct cell *dt;
    assert(l != NULL);
    assert(el != NULL);
    assert(l->position != NULL);
    dt = (struct cell *)malloc(sizeof(struct cell));
    if (errno)
    {
        perror("Pb d'allocution de cellule ... \n");
        exit errno;
    }
    dt->data = (void *)el;
    dt->next = l->position->next;
    dt->prev = l->position;

    if (l->position = l->last)
    {
        l->last = dt;
    }
    else
    {
        l->position->next->prev = dt;
    }
    l->position->next = dt;
    l->position = dt;
    l->size++;
}
void *RemoveElem(T_liste l)
{
    void *dataSuppr;
    struct cell *old;
    assert(l != NULL);
    assert(l->position != NULL);
    dataSuppr = element(l);
    old = l->position;
    if (l->size == 1)
    {
        free(old);
        l->first = NULL;
        l->last = NULL;
        l->position = NULL;
        return dataSuppr;
    }
    else if (l->position == l->first)
    {
        l->position->next->prev = NULL;
        l->first = l->position->next;
        l->position = l->first;
        free(old);
        return dataSuppr;
    }
    else if (l->position == l->last)
    {
        l->position->prev->next = NULL;
        l->last = l->position->prev;
        l->position = l->last;
        free(old);
        return dataSuppr;
    }
    else
    {
        l->position->prev->next = l->position->next;
        l->position->next->prev = l->position->prev;
        l->position = l->position->next;
        free(old);
        return dataSuppr;
    }
    l->size--;

}
int listeVide(T_liste l)
{
    return l->size ==0;
}
int SizeListe (const T_liste l)
{
    return l->size;
}
void PrintListe (const T_liste l, void (*printElem)(void *))
{
    struct cell *iter;
    assert(l != NULL);
    printf("Taille de la liste : %ld\n", l->size);
    if (l->first != NULL)
    {
        iter = l->first;
        do{
            printElem(iter->data);
            iter = iter->next;
            if (iter != NULL)
            {
                printf("-");
            }
        } while(iter != NULL);
    }
    printf("--- FIN \n");
}
void deleteListe(T_liste *li)
{
    assert(li != NULL);
    if ((*li)->first != NULL)
    {
        first(*li);
        while ((*li)->first != NULL)
        {
            printf("reste %ld elem ...", (*li)->size);
            RemoveElem(*li);
        }
        printf("\n");
    }
    free(*li);
    *li = NULL;
}
