#include "/Users/florineteulieres/Desktop/A3/Type_Abstrait_POO/TD02/src_c/lib_deque/src_lib/lib_deque.h"
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

struct cell
{
    void *data;
    struct cell *prev;
    struct cell *next;
};

struct deque
{
    long size;
    struct cell *head;
    struct cell *queue;
};

T_deque *init()
{
    T_deque *dq;
    errno = 0;
    dq = (T_deque *)malloc(sizeof(T_deque));
    if (errno){
        perror("Pb allocation Deque! \n");
        return NULL;
    }
    dq->size = 0;
    dq->head = NULL;
    dq->queue = NULL;
    return dq;
}
int SizeDeque (const T_deque *dq)
{
    if (dq == NULL){
        return -1;
    }
    else{
        return dq->size;
    }
}

void InsertDebut (T_deque *dq, const void *el)
{
    struct cell *cell;
    assert(dq!=NULL);
    assert(el!=NULL);
    errno = 0;
    cell = (struct cell *)malloc(sizeof(struct cell));
    if (errno)
    {
        perror("Pb allocation cellule \n");
        return;
    }
    cell->data = (void *)el;
    cell->prev = NULL;
    cell->next = dq->head;
    if (dq->head == NULL){
        dq->head = cell;
        dq->queue = cell;
    }
    else{
        dq->head->prev = cell;
        dq->head = cell;
    }
    dq->size++;
}
void InsertFin (T_deque *dq, const void *el)
{
    struct cell *cell;
    assert(dq!=NULL);
    assert(el!=NULL);
    errno=0;
    cell = (struct cell *)malloc(sizeof(struct cell));
    if (errno)
    {
        perror("Pb allocation cellule \n");
        return;
    }
    cell->data = (void *)el;
    cell->prev = dq->queue;
    cell->next = NULL;
    if (dq->queue==NULL){
        dq->head = cell;
        dq->queue = cell;
    }
    else{
        dq->queue->next = cell;
        dq->queue = cell;
    }
    dq->size++;
}
void *RemoveDebut(T_deque *dq)
{
    struct cell *elSuppr = NULL;
    void *data = NULL;
    assert(dq != NULL);
    elSuppr = dq->head;
    if (dq->size == 0)
    {
        return NULL;
    }
    data = elSuppr->data;
    if (dq->head == NULL)
    {
        dq->queue = NULL;
    }
    else
    {
        dq->head = elSuppr->next;
        if (dq->head != NULL)
        {
            dq->head->prev = NULL;
        }
    }
    free(elSuppr);
    dq->size--;
    return data;
}

void *RemoveFin(T_deque *dq)
{
    struct cell *elSuppr = NULL;
    void *data = NULL;
    assert(dq != NULL);
    if (dq->size == 0)
    {
        return NULL;
    }
    else if (dq != NULL && dq->queue != NULL)
    {
        elSuppr = dq->queue;
        data = elSuppr->data;
        dq->queue = dq->queue->prev;

        if (dq->queue != NULL)
        {
            dq->queue->next = NULL;
        }
    }
    free(elSuppr);
    dq->size--;
    return data;
}


void DeleteDeque(T_deque *dq)
{
    assert(dq !=NULL);
    if ((dq)->queue != NULL){
        while((dq)->queue != NULL)
        {
            RemoveFin(dq);
        }
    }
    free(dq);
    dq = NULL;
}

void PrintDeque(const T_deque *dq, void (*printElem)(void *))
{
    struct cell *iter;
    assert(dq != NULL);
    printf("Taille de la pile : %ld \n", dq->size);
    if (dq->head != NULL){
        iter = dq->head;
        do {
            printElem(iter->data);
            iter = iter->next;
            if (iter != NULL)
            {
                printf("-");
            }
        } while (iter != NULL);
    }
    printf("<- fin \n");
}